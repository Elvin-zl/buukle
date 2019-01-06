package top.buukle.provider.security.controller.groups;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/11/3.
 * @Description : 权限组controller
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Groups;
import top.buukle.provider.security.service.GroupsService;
import top.buukle.plugin.security.vo.query.GroupsQuery;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;
    /**
     * 获取组别信息列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/getGroupsList")
    @ResponseBody
    public PageResponse<Groups> getGroupsList(GroupsQuery query, PageBounds pageBounds) throws Exception {
        return groupsService.getGroupsList(query,pageBounds);
    }

    /**
     * 模糊搜索
     * @return
     * @throws Exception
     */
    @RequestMapping("/fuzzySearchByName")
    @ResponseBody
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) throws Exception {
        return groupsService.fuzzySearchByName(fuzzyText);
    }

    /**
     * 添加组别
     * @param request
     * @param query
     * @return
     */
    @RequestMapping("/addGroups")
    @ResponseBody
    public BaseResponse addGroups(HttpServletRequest request, GroupsQuery query) throws InvocationTargetException, IllegalAccessException {
        return groupsService.addGroups(request,query);
    }


    /**
     * 查询组别详情
     * @param query
     * @return
     */
    @RequestMapping("/getGroupsDetail")
    @ResponseBody
    public Groups getGroupsDetail(GroupsQuery query) {
        return groupsService.getGroupsDetail(query);
    }

    /**
     * 编辑组别
     * @param request
     * @param id
     *@param query
     * @return
     */
    @RequestMapping("/editGroups/{id}")
    @ResponseBody
    public BaseResponse editGroups(HttpServletRequest request, @PathVariable("id") Integer id, GroupsQuery query) throws InvocationTargetException, IllegalAccessException {
        return groupsService.editGroups(request,id,query);
    }

    /**
     * 起停用组别
     * @param request
     * @param query
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @RequestMapping("/doBanOrRelease")
    @ResponseBody
    public BaseResponse doBanOrRelease(HttpServletRequest request, GroupsQuery query) throws InvocationTargetException, IllegalAccessException {
        return groupsService.doBanOrRelease(request,query);
    }

    /**
     * 加载成员管理列表
     * @param modelAndView
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @RequestMapping("/getMemberList")
    public ModelAndView getMemberList(ModelAndView modelAndView) throws InvocationTargetException, IllegalAccessException {
        modelAndView.setViewName("/permission/groups/memberList");
        return modelAndView;
    }
}
