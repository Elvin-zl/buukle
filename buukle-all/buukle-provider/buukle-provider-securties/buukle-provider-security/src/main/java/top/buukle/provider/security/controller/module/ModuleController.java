package top.buukle.provider.security.controller.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.provider.security.service.ModuleService;
import top.buukle.provider.security.vo.result.ModuleNavigationVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/9.
 * @Description :
 */
@Controller
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    /**  应用名 */
    @Value("${spring.application.name}")
    private String applicationName;
    /**
     * 获取用户主菜单树
     * @param httpServletRequest
     */
    @RequestMapping("/getUserModuleTree")
    @ResponseBody
    public List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest) {
        return moduleService.getUserModuleTree(httpServletRequest,applicationName);
    }

}
