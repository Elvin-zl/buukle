package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.security .entity.vo.UserQuery;
import top.buukle.security .service.UserService;

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
    @RequestMapping("/getPageList")
    public ModelAndView getPageList(UserQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", userService.getPageList(query));
        modelAndView.setViewName("user/userData");
        return modelAndView;
    }

    /**
     * @description 模糊搜索
     * @param text
     * @param fieldName
     * @return top.buukle.common.call.FuzzyResponse
     * @Author zhanglei1102
     * @Date 2019/8/1
     */
    @RequestMapping("/fuzzySearch")
    @ResponseBody
    public FuzzyResponse fuzzySearch(String text, String fieldName) {
        return userService.fuzzySearch(text,fieldName);
    }
}