package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.security .entity.vo.UserRoleRelationLogsQuery;
import top.buukle.security .service.UserRoleRelationLogsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description  UserRoleRelationLogs controller
*/
@Controller
@RequestMapping("/userRoleRelationLogs")
public class UserRoleRelationLogsController {

    @Autowired
    private UserRoleRelationLogsService userRoleRelationLogsService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, UserRoleRelationLogsQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", userRoleRelationLogsService.getPage(query));
        modelAndView.setViewName("userRoleRelationLogs/" + pageName);
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
    public CommonResponse saveOrEdit(UserRoleRelationLogsQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return userRoleRelationLogsService.saveOrEdit(query,request,response);
    }
}