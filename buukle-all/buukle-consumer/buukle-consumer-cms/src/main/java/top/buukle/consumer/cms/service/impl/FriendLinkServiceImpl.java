package top.buukle.consumer.cms .service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import java.util.ArrayList;
import java.util.List;


import top.buukle.consumer.cms .service.FriendLinkService;
import top.buukle.consumer.cms .dao.FriendLinkMapper;
import top.buukle.consumer.cms .entity.FriendLink;
import top.buukle.consumer.cms .entity.vo.FriendLinkQuery;

@Service
public class FriendLinkServiceImpl implements FriendLinkService{

    @Autowired
    FriendLinkMapper mapper;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<FriendLink> getFriendLinkList(FriendLinkQuery query, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        //List<FriendLink> list = mapper.getFriendLinkList(query);
        List<FriendLink> list = new ArrayList<>();
        return new PageResponse.Builder().build(new PageInfo<>(list));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) {
        List<FriendLink> list = new ArrayList<>();
        //List<FriendLink> list = mapper.fuzzySearchByName("%" + fuzzyText + "%");
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        //if(CollectionUtils.isNotEmpty(list)){
        //    for (FriendLink item: list) {
        //    FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
        //    fuzzySearchListVo.setText(item.getName());
        //    fuzzySearchListVos.add(fuzzySearchListVo);
        //    }
        //}
        return fuzzySearchListVos;
    }

    /**
    * 插入单条数据
    * @param record
    */
    @Override
    public FriendLink insert(FriendLink record) throws Exception{
        mapper.insertSelective(record);
        return record;
    }

    /**
    * 更新单条数据
    * @param record
    */
    @Override
    public int update(FriendLink record) throws Exception{
        return mapper.updateByPrimaryKey(record);
    }

    /**
    * 删除单条数据
    *
    * @param id
    */
    @Override
    public int deleteOne(Integer id) throws Exception{
        return mapper.deleteByPrimaryKey(id);
    }
}