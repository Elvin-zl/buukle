package top.buukle.provider.security.controller.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.provider.security.entity.Button;
import top.buukle.provider.security.entity.ButtonType;
import top.buukle.provider.security.service.ButtonService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description : 按钮controller
 */
@Controller
@RequestMapping("/button")
public class ButtonController {

    @Autowired
    private ButtonService buttonService;

    /**
     * 获取全局按钮类型
     * @return
     */
    @RequestMapping("/getButtonTypes")
    @ResponseBody
    public List<ButtonType> getButtonTypes() {
        return buttonService.getButtonTypes();
    }
    /**
     * 获取用户菜单下的按钮
     * @param moduleId
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/getModuleButtons/{moduleId}")
    @ResponseBody
    public List<Button> getModuleButtons(@PathVariable("moduleId") Integer moduleId, HttpServletRequest httpServletRequest) {
        return buttonService.getModuleButtons(httpServletRequest,moduleId);
    }
}
