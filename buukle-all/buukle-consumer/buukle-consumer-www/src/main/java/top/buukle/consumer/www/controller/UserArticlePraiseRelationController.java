package top.buukle.consumer.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.response.PageResponse;

import top.buukle.consumer.www.service.UserArticlePraiseRelationService;
import top.buukle.consumer.www.entity.UserArticlePraiseRelation;
import top.buukle.consumer.www.entity.vo.UserArticlePraiseRelationQuery;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description UserArticlePraiseRelation controller
*/
@Controller
@RequestMapping("/userArticlePraiseRelation")
public class UserArticlePraiseRelationController{

    @Autowired
    UserArticlePraiseRelationService userArticlePraiseRelationService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserArticlePraiseRelationList")
    @ResponseBody
    public PageResponse<UserArticlePraiseRelation> getUserArticlePraiseRelationList(UserArticlePraiseRelationQuery query,PageBounds pageBounds) throws Exception {
        return userArticlePraiseRelationService.getUserArticlePraiseRelationList(query,pageBounds);
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
        return userArticlePraiseRelationService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteUserArticlePraiseRelation")
    @ResponseBody
    public BaseResponse deleteUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request) throws Exception {
        return userArticlePraiseRelationService.deleteUserArticlePraiseRelation(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserArticlePraiseRelationDetail")
    @ResponseBody
    public UserArticlePraiseRelation getUserArticlePraiseRelationDetail(UserArticlePraiseRelationQuery query) throws Exception {
        return userArticlePraiseRelationService.getUserArticlePraiseRelationDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveUserArticlePraiseRelation")
    @ResponseBody
    public BaseResponse saveUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request) throws Exception {
        return userArticlePraiseRelationService.saveUserArticlePraiseRelation(query,request);
    }

    /**
    * 点赞/取消赞
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/switchPraise")
    @ResponseBody
    public BaseResponse switchPraise(UserArticlePraiseRelationQuery query, HttpServletRequest request) throws Exception {
        return userArticlePraiseRelationService.doSwitchPraise(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateUserArticlePraiseRelation")
    @ResponseBody
    public BaseResponse updateUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request) throws Exception {
        return userArticlePraiseRelationService.updateUserArticlePraiseRelation(query,request);
    }

}