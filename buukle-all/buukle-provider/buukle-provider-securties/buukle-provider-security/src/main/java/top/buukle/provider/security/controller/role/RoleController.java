package top.buukle.provider.security.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.provider.security.entity.Role;
import top.buukle.provider.security.service.RoleService;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.query.RoleQuery;
import top.buukle.provider.security.vo.response.FuzzySearchListVo;
import top.buukle.provider.security.vo.response.PageResponse;
import top.buukle.provider.security.vo.response.RoleModuleListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/17.
 * @Description :
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    /**
     * 分页获取用户信息列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/getRoleList")
    @ResponseBody
    public PageResponse<Role> getRoleList(RoleQuery roleQuery, PageBounds pageBounds) throws Exception {
        return roleService.getRoleList(roleQuery,pageBounds);
    }
    /**
     * 启用/停用 角色
     * @return
     * @throws Exception
     */
    @RequestMapping("/doBanOrRelease")
    @ResponseBody
    public BaseResponse doBanOrRelease(HttpServletRequest request,RoleQuery query) throws Exception {
        return roleService.doBanOrRelease(request,query);
    }
    /**
     * 获取角色菜单信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getRoleModuleForPage")
    @ResponseBody
    public List<RoleModuleListVo> getRoleModuleForPage(HttpServletRequest request, Integer id) throws Exception {
        return roleService.getRoleModuleForPage(request,id);
    }

    /**
     * 分配角色菜单
     * @param ids
     * @param userQuery
     * @return
     * @throws Exception
     */
    @RequestMapping("/setRoleModule")
    @ResponseBody
    public BaseResponse setRoleModule(String ids,RoleQuery userQuery) throws Exception {
        return roleService.setRoleModule(ids,userQuery);
    }

    /**
     * 模糊搜索
     * @return
     * @throws Exception
     */
    @RequestMapping("/fuzzySearchByName")
    @ResponseBody
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) throws Exception {
        return roleService.fuzzySearchByName(fuzzyText);
    }

    /**
     * 添加角色
     * @param request
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRole")
    @ResponseBody
    public BaseResponse addRole(HttpServletRequest request,RoleQuery query) throws Exception {
        return roleService.addRole(request,query);
    }

    /**
     * 查询角色详情
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/getRoleDetail")
    @ResponseBody
    public Role getRoleDetail(RoleQuery query) throws Exception {
        return roleService.getRoleDetail(query);
    }

    /**
     * 编辑角色
     * @param request
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/editRole/{id}")
    @ResponseBody
    public BaseResponse editRole(HttpServletRequest request, @PathVariable Integer id, RoleQuery query) throws Exception {
        return roleService.editRole(request,id,query);
    }
}
