package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security .entity.vo.MenuQuery;
import top.buukle.security .service.MenuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description  Menu controller
*/
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, MenuQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", menuService.getPage(query));
        modelAndView.setViewName("menu/" + pageName);
        return modelAndView;
    }

    /**
    * @description 新增或者修改
    * @param query
    * @param request
    * @return top.buukle.common.call.CommonResponse
    * @Author elvin
    * @Date 2019/8/5
    */
    @RequestMapping("/saveOrEdit")
    @ResponseBody
    public CommonResponse saveOrEdit(MenuQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return menuService.saveOrEdit(query,request,response);
    }
    /**
     * @description 获取上级菜单
     * @param applicationId
     * @param request
     * @param response
     * @return top.buukle.common.call.PageResponse
     * @Author elvin
     * @Date 2019/8/10
     */
    @RequestMapping("/getMenuTree")
    @ResponseBody
    public PageResponse getMenuTree(Integer applicationId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return menuService.getMenuTree(applicationId,request,response);
    }
}