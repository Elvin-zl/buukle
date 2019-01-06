package top.buukle.provider.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.provider.security .service.IpBlackListService;
import top.buukle.plugin.security.entity.IpBlackList;
import top.buukle.plugin.security.entity.vo.IpBlackListQuery;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description IpBlackList controller
*/
@Controller
@RequestMapping("/ipBlackList")
public class IpBlackListController{

    @Autowired
    IpBlackListService ipBlackListService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getIpBlackListList")
    @ResponseBody
    public PageResponse<IpBlackList> getIpBlackListList(IpBlackListQuery query,PageBounds pageBounds) throws Exception {
        return ipBlackListService.getIpBlackListList(query,pageBounds);
    }

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    * @throws Exception
    */
    @RequestMapping("/fuzzySearchByText")
    @ResponseBody
    public List<FuzzySearchListVo>  fuzzySearchByText(String fuzzyText) throws Exception {
        return ipBlackListService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteIpBlackList")
    @ResponseBody
    public BaseResponse deleteIpBlackList(IpBlackListQuery query, HttpServletRequest request) throws Exception {
        return ipBlackListService.deleteIpBlackList(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getIpBlackListDetail")
    @ResponseBody
    public IpBlackList getIpBlackListDetail(IpBlackListQuery query) throws Exception {
        return ipBlackListService.getIpBlackListDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveIpBlackList")
    @ResponseBody
    public BaseResponse saveIpBlackList(IpBlackListQuery query, HttpServletRequest request) throws Exception {
        return ipBlackListService.saveIpBlackList(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateIpBlackList")
    @ResponseBody
    public BaseResponse updateIpBlackList(IpBlackListQuery query, HttpServletRequest request) throws Exception {
        return ipBlackListService.updateIpBlackList(query,request);
    }

}