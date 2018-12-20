package top.buukle.consumer.cms .service;

import top.buukle.common.vo.response.PageResponse;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.cms .entity.UserAlbum;
import top.buukle.consumer.cms .entity.vo.UserAlbumQuery;

public interface UserAlbumService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<UserAlbum> getUserAlbumList(UserAlbumQuery query, PageBounds pageBounds);

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    */
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText);
    /**
    * 插入单条数据
    * @param record
    */
    public UserAlbum insert(UserAlbum record) throws Exception;

    /**
    * 更新单条数据
    * @param record
    */
    public int update(UserAlbum record) throws Exception;

    /**
    * 删除单条数据
    * @param id
    */
    public int deleteOne(Integer id) throws Exception;
}