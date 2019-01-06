package top.buukle.provider.security.controller.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.provider.security.service.ButtonService;
import top.buukle.plugin.security.vo.query.ButtonQuery;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;

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
    public List<Button> getModuleButtons(@PathVariable("moduleId") Integer moduleId, HttpServletRequest httpServletRequest) throws Exception {
        return buttonService.getModuleButtons(httpServletRequest,moduleId);
    }

    /**
     * 分页获取按钮信息列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/getButtonList")
    @ResponseBody
    public PageResponse<Button> getModuleList(ButtonQuery query, PageBounds pageBounds) throws Exception {
        return buttonService.getButtonList(query,pageBounds);
    }

    /**
     * 启用/停用 按钮
     * @return
     * @throws Exception
     */
    @RequestMapping("/doBanOrRelease")
    @ResponseBody
    public BaseResponse doBanOrRelease(HttpServletRequest request,ButtonQuery query) throws Exception {
        return buttonService.doBanOrRelease(request,query);
    }

    /**
     * 添加按钮
     * @param request
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/addButton")
    @ResponseBody
    public BaseResponse addButton(HttpServletRequest request, ButtonQuery query) throws Exception {
        return buttonService.addButton(request,query);
    }
    /**
     * 修改按钮
     * @param request
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/editButton/{id}")
    @ResponseBody
    public BaseResponse editButton(HttpServletRequest request,@PathVariable("id") Integer id, ButtonQuery query) throws Exception {
        return buttonService.editButton(request,query,id);
    }

    /**
     * 获取按钮详情
     * @param request
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/getButtonDetail")
    @ResponseBody
    public Button getButtonDetail(HttpServletRequest request, ButtonQuery query) throws Exception {
        return buttonService.getButtonDetail(request,query);
    }

    /**
     * 模糊搜索
     * @return
     * @throws Exception
     */
    @RequestMapping("/fuzzySearchByName")
    @ResponseBody
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) throws Exception {
        return buttonService.fuzzySearchByName(fuzzyText);
    }

}
