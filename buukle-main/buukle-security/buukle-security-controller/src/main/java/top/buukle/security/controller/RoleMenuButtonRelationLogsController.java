package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.security .entity.vo.RoleMenuButtonRelationLogsQuery;
import top.buukle.security .service.RoleMenuButtonRelationLogsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description  RoleMenuButtonRelationLogs controller
*/
@Controller
@RequestMapping("/roleMenuButtonRelationLogs")
public class RoleMenuButtonRelationLogsController {

    @Autowired
    private RoleMenuButtonRelationLogsService roleMenuButtonRelationLogsService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, RoleMenuButtonRelationLogsQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", roleMenuButtonRelationLogsService.getPage(query));
        modelAndView.setViewName("roleMenuButtonRelationLogs/" + pageName);
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
    public CommonResponse saveOrEdit(RoleMenuButtonRelationLogsQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return roleMenuButtonRelationLogsService.saveOrEdit(query,request,response);
    }
}