package top.buukle.security.api.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.code.BaseReturnEnum;
import top.buukle.common.exception.CommonException;
import top.buukle.common.status.StatusConstants;
import top.buukle.security.api.ApiUserService;
import top.buukle.security.dao.*;
import top.buukle.security.entity.*;
import top.buukle.security.entity.vo.MenuTreeNode;
import top.buukle.security.plugin.util.SessionUtil;
import top.buukle.security.service.constants.MenuEnums;
import top.buukle.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
* @author elvin
* @description UserService实现类
*/
@Service
public class ApiUserServiceImpl implements ApiUserService{


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ButtonMapper buttonMapper;
    @Autowired
    private ApplicationMapper applicationMapper;

    /**
     * @description 内部登陆
     * @param user
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/3
     */
    @Override
    public CommonResponse innerLogin(User user, HttpServletRequest request, HttpServletResponse response) {
        this.validationParam(user);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(users) || users.size() != 1){
            throw new CommonException(BaseReturnEnum.LOGIN_FAILED_PARAM_WRONG);
        }
        User userInfo = users.get(0);
        // 缓存用户信息
        User user1 = new User();
        user1.setId(userInfo.getId());
        user1.setGmtLastLogin(new Date());
        userMapper.updateByPrimaryKeySelective(user1);
        SessionUtil.cacheUser(userInfo,request,response);
        // 查询用户拥有菜单资源目录
        List<Menu> menuList = menuMapper.getUserMenuListByUserId(userInfo.getUserId());

        if(!CollectionUtils.isEmpty(menuList)){
            List<Menu> menuDisplay = new ArrayList<>();
            // 筛选可见菜单
            for (Menu menu: menuList) {
                // 菜单类型 && 菜单可见 && 排序
                if(MenuEnums.type.MENU.value().equals(menu.getType()) && MenuEnums.display.DISPLAY_BLOCK.value().equals(menu.getDisplay()) && menu.getOrderNo() != null){
                    menuDisplay.add(menu);
                }
            }
            // 组装用户每个应用的可见菜单
            MenuExample menuExample = new MenuExample();
            MenuExample.Criteria menuExampleCriteria = menuExample.createCriteria();
            menuExampleCriteria.andPidEqualTo(0);
            List<Menu> menus = menuMapper.selectByExample(menuExample);
            Map<String,MenuTreeNode> userApplicationMenuDisplayed = new HashMap<>();
            if(!CollectionUtils.isEmpty(menus)){
                for (Menu menu: menus) {
                    if(menu.getPid().equals(0)){ //
                        MenuTreeNode rootNodeDisplay = new MenuTreeNode();
                        BeanUtils.copyProperties(menu,rootNodeDisplay);
                        Application application = applicationMapper.selectByPrimaryKey(menu.getApplicationId());
                        // 组装应用下用户可见菜单树
                        this.assUserMenuTree(rootNodeDisplay,menuDisplay);
                        userApplicationMenuDisplayed.put(application == null ? "" : application.getCode(),rootNodeDisplay);
                    }
                }
            }
            // 缓存用户可见菜单数组
            SessionUtil.cache(request,SessionUtil.USER_MENU_TREE_KEY,userApplicationMenuDisplayed);
            // 缓存用户角色目录
            SessionUtil.cache(request,SessionUtil.USER_ROLE_LIST_KEY,roleMapper.selectUserRoles(userInfo.getUserId()));
            // 查询用户按钮目录
            List<Button> buttonList = this.getUserButtonList(menuList);
            // 缓存用户按钮目录
            SessionUtil.cache(request,SessionUtil.USER_BUTTON_LIST_KEY,buttonList);
            // 缓存用户所有资源url清单
            SessionUtil.cache(request,SessionUtil.USER_URL_LIST_KEY,this.assUserMenuUrlList(menuList,buttonList));
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 组装用户所有资源url清单
     * @param menuList
     * @param buttonList
     * @return java.util.List<java.lang.String>
     * @Author elvin
     * @Date 2019/8/3
     */
    private List<String> assUserMenuUrlList(List<Menu> menuList, List<Button> buttonList) {
        List<String> list = new ArrayList<>();
        for (Menu menu: menuList) {
            list.add(menu.getUrl());
        }
        for (Button button: buttonList) {
            list.add(button.getUrl());
        }
        return list;
    }

    /**
     * @description 组装用户按钮目录
     * @param menuList
     * @return java.util.List<top.buukle.security.entity.Button>
     * @Author elvin
     * @Date 2019/8/3
     */
    private List<Button> getUserButtonList(List<Menu> menuList) {
        List<Integer> menuIdList = new ArrayList<>();
        for (Menu menu: menuList) {
            menuIdList.add(menu.getId());
        }
        ButtonExample buttonExample = new ButtonExample();
        ButtonExample.Criteria criteria = buttonExample.createCriteria();
        criteria.andMenuIdIn(menuIdList);
        criteria.andStatusEqualTo(MenuEnums.status.PUBLISED.value());
        List<Button> buttons = buttonMapper.selectByExample(buttonExample);
        return CollectionUtils.isEmpty(buttons) ? new ArrayList<>() : buttons;
    }

    /**
     * @description 组装菜单树
     * @param node
     * @param menuList
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    private void assUserMenuTree(MenuTreeNode node, List<Menu> menuList) {
        List<MenuTreeNode> nodeList = new ArrayList<>();
        for (Menu menu: menuList) {
            if(menu.getPid().equals(node.getId())){
                MenuTreeNode menuTreeNode = new MenuTreeNode();
                BeanUtils.copyProperties(menu,menuTreeNode);
                assUserMenuTree(menuTreeNode,menuList);
                nodeList.add(menuTreeNode);
            }
        }
        node.setSubMenuList(nodeList);
    }

    /**
     * @description 验证参数
     * @param user
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    private void validationParam(User user) {
        if(null == user){
            throw new CommonException(BaseReturnEnum.LOGIN_FAILED);
        }
        if(StringUtil.isEmpty(user.getUsername()) || StringUtil.isEmpty(user.getPassword())){
            throw new CommonException(BaseReturnEnum.LOGIN_FAILED_PARAM_NULL);
        }
    }
}