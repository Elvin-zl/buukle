package top.buukle.consumer.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.consumer.cms.vo.ArticleInformationVo;
import top.buukle.consumer.cms.vo.ArticlePublishVo;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.response.PageResponse;

import top.buukle.consumer.cms .service.ArticleInfoService;
import top.buukle.consumer.cms .entity.ArticleInfo;
import top.buukle.consumer.cms .entity.vo.ArticleInfoQuery;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description ArticleInfo controller
*/
@Controller
@RequestMapping("/articleInfo")
public class ArticleInfoController{

    @Autowired
    ArticleInfoService articleInfoService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleInfoList")
    @ResponseBody
    public PageResponse<ArticleInfo> getUserList(ArticleInfoQuery query,PageBounds pageBounds) throws Exception {
        return articleInfoService.getArticleInfoList(query,pageBounds);
    }
    /**
    * 获取我的文章列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserArticleInfoList")
    @ResponseBody
    public PageResponse<ArticleInfo> getUserArticleInfoList(ArticleInfoQuery query,PageBounds pageBounds) throws Exception {
        return articleInfoService.getUserArticleInfoList(query,pageBounds);
    }
    /**
    * 获取文章审核列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getAuditArticleInfoList")
    @ResponseBody
    public PageResponse<ArticleInfo> getAuditArticleInfoList(ArticleInfoQuery query,PageBounds pageBounds) throws Exception {
        return articleInfoService.getAuditArticleInfoList(query,pageBounds);
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
        return articleInfoService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteArticleInfo")
    @ResponseBody
    public BaseResponse deleteArticleInfo(ArticleInfoQuery query, HttpServletRequest request) throws Exception {
        return articleInfoService.deleteArticleInfo(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleInfoDetail")
    @ResponseBody
    public ArticleInfo getArticleInfoDetail(ArticleInfoQuery query) throws Exception {
        return articleInfoService.getArticleInfoDetail(query);
    }

    /**
    * 查看文章详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleInformation")
    @ResponseBody
    public ArticleInformationVo getArticleAllInformation(ArticleInfoQuery query) throws Exception {
        return articleInfoService.getArticleAllInformation(query);
    }
    /**
    * 查看文章详情--审核用
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleInformationForAudit")
    @ResponseBody
    public ArticleInformationVo getArticleInformationForAudit(ArticleInfoQuery query,HttpServletRequest request) throws Exception {
        return articleInfoService.getArticleInformationForAudit(query,request);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveArticleInfo")
    @ResponseBody
    public BaseResponse saveArticleInfo(ArticleInfoQuery query, HttpServletRequest request) throws Exception {
        return articleInfoService.saveArticleInfo(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateArticleInfo")
    @ResponseBody
    public BaseResponse updateArticleInfo(ArticleInfoQuery query, HttpServletRequest request) throws Exception {
        return articleInfoService.updateArticleInfo(query,request);
    }

    /**
    * 发布文章
    * @param publishVo
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/publish")
    @ResponseBody
    public BaseResponse publish(ArticlePublishVo publishVo, HttpServletRequest request) throws Exception {
        return articleInfoService.doPublish(publishVo,request);
    }

    /**
    * 草稿文章
    * @param publishVo
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/draft")
    @ResponseBody
    public BaseResponse draft(ArticlePublishVo publishVo, HttpServletRequest request) throws Exception {
        return articleInfoService.doDraft(publishVo,request);
    }

    /**
     * 审核文章
     * @param articleInfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/auditArticle")
    @ResponseBody
    public BaseResponse auditArticle(ArticleInfo articleInfo, HttpServletRequest request) throws Exception {
        return articleInfoService.auditArticle(articleInfo,request);
    }
}