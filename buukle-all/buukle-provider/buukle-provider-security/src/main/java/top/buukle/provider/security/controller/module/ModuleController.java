package top.buukle.provider.security.controller.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.plugin.security.entity.Module;
import top.buukle.provider.security.service.ModuleService;
import top.buukle.plugin.security.vo.query.ModuleQuery;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.plugin.security.vo.response.*;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;
import top.buukle.common.vo.response.PageResponse;

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
    public BaseResponse doBanOrRelease(HttpServletRequest request,ModuleQuery query) throws Exception {
        return moduleService.doBanOrRelease(request,query);
    }
    /**
     * 添加菜单
     * @return
     * @throws Exception
     */
    @RequestMapping("/addModule")
    @ResponseBody
    public BaseResponse addModule(HttpServletRequest request,ModuleQuery query) throws Exception {
        return moduleService.addModule(request,query,applicationName);
    }

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
    /**
     * 模糊搜索
     * @return
     * @throws Exception
     */
    @RequestMapping("/fuzzySearchByName")
    @ResponseBody
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) throws Exception {
        return moduleService.fuzzySearchByName(fuzzyText);
    }
    /**
     * 查询父级菜单树
     * @return
     * @throws Exception
     */
    @RequestMapping("/getFatherModuleTree")
    @ResponseBody
    public List<RoleModuleListVo> getFatherModuleTree(String clickCallBack) throws Exception {
        return moduleService.getFatherModuleTree(applicationName,clickCallBack);
    }
    /**
     * 查询菜单详情
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/getModuleDetail")
    @ResponseBody
    public ModuleDetailVo getModuleDetail(ModuleQuery query) throws Exception {
        return moduleService.getModuleDetail(query);
    }

    /**
     * 编辑菜单
     */
    @RequestMapping("/editModule/{id}")
    @ResponseBody
    public BaseResponse editModule(HttpServletRequest request,@PathVariable("id")  Integer id, ModuleQuery query) throws Exception {
        return moduleService.editModule(request,id,query,applicationName);
    }

}
