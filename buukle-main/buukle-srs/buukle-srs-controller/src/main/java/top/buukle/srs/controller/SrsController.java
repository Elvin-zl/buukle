package top.buukle.srs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.security.entity.Role;
import top.buukle.security.entity.constants.MenuEnums;
import top.buukle.security.entity.vo.MenuTreeNode;
import top.buukle.security.plugin.util.SessionUtil;
import top.buukle.srs.service.BaseService;
import top.buukle.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 2:11
 */
@Controller
@RequestMapping("/srs")
public class SrsController {

    @Autowired
    private Environment env;

    private WebApplicationContext webApplicationContext ;

    /**
     * security 主页面控制器
     * @param modelAndView
     * @return
     */
    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        String applicationName = env.getProperty("spring.application.name");
        String nameSuffix = applicationName.split("-")[1];
        modelAndView.addObject("nameSuffix",nameSuffix);
        modelAndView.addObject("user",SessionUtil.getUser(request, response));
        MenuTreeNode menuTreeNode = ((Map<String, MenuTreeNode>) SessionUtil.get(request, SessionUtil.USER_MENU_TREE_KEY)).get(applicationName);
        // 返回左侧菜单树的引用
        modelAndView.addObject("menuList",menuTreeNode == null ? new ArrayList<MenuTreeNode>() : menuTreeNode.getSubMenuList());
        // 返回首页引用
        modelAndView.addObject("welcome",menuTreeNode == null ? new MenuTreeNode() : menuTreeNode.getSubMenuList().get(0));
        // 返回顶部菜单树的引用
        modelAndView.addObject("topMenuList",menuTreeNode == null ? new ArrayList<MenuTreeNode>() : this.getTopMenuList(menuTreeNode.getSubMenuList()));
        // 返回角色引用
        modelAndView.addObject("role",((Map<String,Role>)SessionUtil.get(request,SessionUtil.USER_ROLE_MAP_KEY)).get(applicationName));
        modelAndView.setViewName("home");
        return modelAndView;
    }

    /**
     * @description 获取顶部菜单列表
     * @param subMenuList
     * @return java.util.List<top.buukle.security.entity.Menu>
     * @Author elvin
     * @Date 2019/8/18
     */
    private List<MenuTreeNode> getTopMenuList(List<MenuTreeNode> subMenuList) {
        List<MenuTreeNode> topMenuList = new ArrayList<>();
        this.getTopMenuList(topMenuList,subMenuList);
        return topMenuList;
    }

    /**
     * @description 获取顶部菜单列表
     * @param topMenuList
     * @param subMenuList
     * @return void
     * @Author elvin
     * @Date 2019/8/18
     */
    private void getTopMenuList(List<MenuTreeNode> topMenuList, List<MenuTreeNode> subMenuList) {
        for (MenuTreeNode menuTreeNode: subMenuList) {
            if(MenuEnums.display.DISPLAY_BLOCK.value().equals(menuTreeNode.getDisplay()) && MenuEnums.positionType.LEFT_AND_TOP.value().equals(menuTreeNode.getPositionType())){
                topMenuList.add(menuTreeNode);
            }
            if(!CollectionUtils.isEmpty(menuTreeNode.getSubMenuList())){
                this.getTopMenuList(topMenuList,menuTreeNode.getSubMenuList());
            }

        }
    }

    /**
     * security 子页面控制器
     * @param entity
     * @param operationAndViewName
     * @param modelAndView
     * @return
     */
    @RequestMapping("/{entity}/{operationAndViewName}")
    public ModelAndView security(
                                 Integer id,
                                 String ids ,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @PathVariable("entity") String entity ,
                                 @PathVariable("operationAndViewName")  String operationAndViewName,
                                 ModelAndView modelAndView) throws IOException {
        Object o = null;
        // 增改页面
        if(operationAndViewName.endsWith("CrudView") || operationAndViewName.endsWith("SetView")){
            webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            o = ((BaseService) webApplicationContext.getBean(entity + "Service")).selectByPrimaryKeyForCrud(request,id);
        }
        // 删除结果
        if(operationAndViewName.endsWith("CrudJson")){
            webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            o = ((BaseService) webApplicationContext.getBean(entity + "Service")).delete(id,request,response);
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JsonUtil.toJSONString(o));
            return null;
        }
        // 批删结果
        if(operationAndViewName.endsWith("BatchDeleteJson")){
            webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            o = ((BaseService) webApplicationContext.getBean(entity + "Service")).deleteBatch(ids,request,response);
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JsonUtil.toJSONString(o));
            return null;
        }
        modelAndView.addObject("record",o).setViewName("/" + entity + "/" + operationAndViewName);
        return modelAndView;
    }

    /**
     * @description 模糊搜索
     * @param entity
     * @param text
     * @param fieldName
     * @param request
     * @return top.buukle.common.call.FuzzyResponse
     * @Author elvin
     * @Date 2019/8/4
     */
    @RequestMapping("/{entity}/fuzzy/search")
    @ResponseBody
    public FuzzyResponse fuzzySearch(@PathVariable("entity") String entity,String text, String fieldName,HttpServletRequest request) {
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        return ((BaseService) webApplicationContext.getBean(entity + "Service")).fuzzySearch(text, fieldName);
    }

}
