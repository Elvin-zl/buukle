package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.security .entity.vo.UserQuery;
import top.buukle.security .service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description User controller
*/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView userPage(@PathVariable("pageName") String pageName, UserQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", userService.getPage(query));
        modelAndView.setViewName("user/" + pageName);
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
    public CommonResponse saveOrEdit(UserQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return userService.saveOrEdit(query,request,response);
    }

    /**
     * @description 设置用户角色
     * @param ids
     * @param query
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author zhanglei1102
     * @Date 2019/8/13
     */
    @RequestMapping("/userRoleSet")
    @ResponseBody
    public CommonResponse userRoleSet(Integer applicationId,String ids, UserQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return userService.userRoleSet(applicationId,ids,query,request,response);
    }
}