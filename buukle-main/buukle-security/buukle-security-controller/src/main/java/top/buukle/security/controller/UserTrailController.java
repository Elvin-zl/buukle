package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.security .entity.vo.UserTrailQuery;
import top.buukle.security .service.UserTrailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description  UserTrail controller
*/
@Controller
@RequestMapping("/userTrail")
public class UserTrailController {

    @Autowired
    private UserTrailService userTrailService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, UserTrailQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", userTrailService.getPage(query));
        modelAndView.setViewName("userTrail/" + pageName);
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
    public CommonResponse saveOrEdit(UserTrailQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return userTrailService.saveOrEdit(query,request,response);
    }
}