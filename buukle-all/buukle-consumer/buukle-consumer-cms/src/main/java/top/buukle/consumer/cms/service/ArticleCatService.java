package top.buukle.consumer.cms .service;

import top.buukle.common.vo.response.PageResponse;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.cms .entity.ArticleCat;
import top.buukle.consumer.cms .entity.vo.ArticleCatQuery;

public interface ArticleCatService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<ArticleCat> getArticleCatList(ArticleCatQuery query, PageBounds pageBounds);

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    */
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText);
    /**
    * 插入单条数据
    * @param record
    */
    public ArticleCat insert(ArticleCat record) throws Exception;

    /**
    * 更新单条数据
    * @param record
    */
    public int update(ArticleCat record) throws Exception;

    /**
    * 删除单条数据
    * @param id
    */
    public int deleteOne(Integer id) throws Exception;
}