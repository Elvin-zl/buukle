package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security .entity.vo.RoleQuery;
import top.buukle.security .service.RoleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description  Role controller
*/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, RoleQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", roleService.getPage(query));
        modelAndView.setViewName("role/" + pageName);
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
    public CommonResponse saveOrEdit(RoleQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return roleService.saveOrEdit(query,request,response);
    }

    /**
     * @description 获取上级角色
     * @param request
     * @param response
     * @return top.buukle.common.call.PageResponse
     * @Author elvin
     * @Date 2019/8/9
     */
    @RequestMapping("/getRoleTree")
    @ResponseBody
    public PageResponse getRoleTree(Integer applicationId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return roleService.getRoleTree(applicationId,request,response);
    }

    /**
     * @description 获取用户角色树
     * @param applicationId
     * @param userId
     * @return top.buukle.common.call.PageResponse
     * @Author zhanglei1102
     * @Date 2019/8/12
     */
    @RequestMapping("/getAppUserRole")
    @ResponseBody
    public PageResponse getAppUserRole(Integer applicationId,String userId,HttpServletRequest request) throws Exception {
        return roleService.getAppUserRole(applicationId,userId,request);
    }

    /**
     * @description 获取角色菜单树
     * @param id
     * @param request
     * @return top.buukle.common.call.PageResponse
     * @Author zhanglei1102
     * @Date 2019/8/13
     */
    @RequestMapping("/getRoleMenuTree")
    @ResponseBody
    public PageResponse getRoleMenuTree(Integer id,HttpServletRequest request) throws Exception {
        return roleService.getRoleMenuTree(id,request);
    }

    /**
     * @description 设置角色菜单按钮
     * @param ids
     * @param id
     * @param request
     * @return top.buukle.common.call.PageResponse
     * @Author zhanglei1102
     * @Date 2019/8/14
     */
    @RequestMapping("/roleMenuSet")
    @ResponseBody
    public CommonResponse roleMenuSet(String ids,Integer id,HttpServletRequest request,HttpServletResponse response) throws Exception {
        return roleService.roleMenuSet(ids,id,request,response);
    }

}