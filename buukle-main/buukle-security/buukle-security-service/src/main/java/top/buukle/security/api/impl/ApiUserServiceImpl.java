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
import top.buukle.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private ButtonMapper buttonMapper;

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
        // 查询用户拥有菜单资源目录
        List<Menu> menuList = menuMapper.getUserMenuListByUserId(userInfo.getUserId());
        // 初始化菜单根节点
        MenuTreeNode rootNode = new MenuTreeNode();
        rootNode.setName("根目录");
        rootNode.setId(0);
        if(!CollectionUtils.isEmpty(menuList)){
            // 组装用户菜单树
            this.assUserMenuTree(rootNode,menuList);
            // 缓存用户菜单树
            SessionUtil.cache(request,SessionUtil.USER_MENU_TREE_KEY,rootNode);
            // 查询用户按钮目录
            List<Button> buttonList = this.getUserButtonList(menuList);
            // 缓存用户按钮目录
            SessionUtil.cache(request,SessionUtil.USER_BUTTON_LIST_KEY,buttonList);
            // 缓存用户所有资源url清单
            SessionUtil.cache(request,SessionUtil.USER_URL_LIST_KEY,this.assUserMenuUrlList(menuList,buttonList));
        }
        // 缓存用户信息
        User user1 = new User();
        user1.setId(userInfo.getId());
        user1.setGmtLastLogin(new Date());
        userMapper.updateByPrimaryKeySelective(user1);
        SessionUtil.cacheUser(userInfo,request,response);
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
        criteria.andStatusEqualTo(StatusConstants.OPEN);
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