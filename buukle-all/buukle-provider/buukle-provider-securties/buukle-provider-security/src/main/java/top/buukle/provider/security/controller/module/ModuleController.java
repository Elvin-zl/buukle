package top.buukle.provider.security.controller.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.provider.security.entity.Module;
import top.buukle.provider.security.service.ModuleService;
import top.buukle.provider.security.vo.query.ModuleQuery;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.response.ModuleButtonListVo;
import top.buukle.provider.security.vo.response.PageResponse;
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
    public List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest) throws Exception {
        return moduleService.getUserModuleTree(httpServletRequest,applicationName);
    }
    /**
     * 分页获取用户信息列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/getModuleList")
    @ResponseBody
    public PageResponse<Module> getModuleList(ModuleQuery query, PageBounds pageBounds) throws Exception {
        return moduleService.getModuleList(query,pageBounds);
    }
    /**
     * 启用/停用 菜单
     * @return
     * @throws Exception
     */
    @RequestMapping("/doBanOrRelease")
    @ResponseBody
    public BaseResponse doBanOrRelease(ModuleQuery query) throws Exception {
        return moduleService.doBanOrRelease(query);
    }

    ///
    /**
     * 获取角色菜单信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getModuleButtonForPage")
    @ResponseBody
    public List<ModuleButtonListVo> getModuleButtonForPage(HttpServletRequest request, Integer id) throws Exception {
        return moduleService.getModuleButtonForPage(request,id);
    }

    /**
     * 分配菜单按钮
     * @param ids
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/setModuleButton")
    @ResponseBody
    public BaseResponse setModuleButton(String ids,ModuleQuery query) throws Exception {
        return moduleService.setModuleButton(ids,query);
    }
}
