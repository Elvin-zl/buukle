package top.buukle.consumer.cms .service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.cms .entity.UserAlbum;
import top.buukle.consumer.cms .entity.vo.UserAlbumQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description UserAlbumService 接口类
*/
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
    * 逻辑删除单条数据
    * @param query
    * @param request
    * @return
    */
    BaseResponse deleteUserAlbum(UserAlbumQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    UserAlbum getUserAlbumDetail(UserAlbumQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveUserAlbum(UserAlbumQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateUserAlbum(UserAlbumQuery query, HttpServletRequest request);
}