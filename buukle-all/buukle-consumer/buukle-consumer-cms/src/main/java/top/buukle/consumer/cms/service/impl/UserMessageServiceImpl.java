package top.buukle.consumer.cms .service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms.entity.UserMessageExample;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;


import top.buukle.consumer.cms .service.UserMessageService;
import top.buukle.consumer.cms .dao.UserMessageMapper;
import top.buukle.consumer.cms .entity.UserMessage;
import top.buukle.consumer.cms .entity.vo.UserMessageQuery;

@Service
public class UserMessageServiceImpl implements UserMessageService{

    @Autowired
    UserMessageMapper mapper;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<UserMessage> getUserMessageList(UserMessageQuery query, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(mapper.selectByExample(this.assExample(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<UserMessage> list = mapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (UserMessage item: list) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                //fuzzySearchListVo.setText(item.get);
                fuzzySearchListVos.add(fuzzySearchListVo);
            }
        }
        return fuzzySearchListVos;
    }

    /**
    * 插入单条数据
    * @param record
    */
    @Override
    public UserMessage insert(UserMessage record) throws Exception{
        mapper.insertSelective(record);
        return record;
    }

    /**
    * 更新单条数据
    * @param record
    */
    @Override
    public int update(UserMessage record) throws Exception{
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

    /**
    * 组装分页参数
    * @param query
    * @return
    */
    private UserMessageExample assExample(UserMessageQuery query) {
        UserMessageExample example = new UserMessageExample();
        UserMessageExample.Criteria criteria = example.createCriteria();
            if(StringUtil.isNotEmpty(query.getStartTime())){
                criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
            }
            if(StringUtil.isNotEmpty(query.getEndTime())){
                criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
            }
            if(null != query.getStatus()){
                criteria.andStatusEqualTo(query.getStatus());
            }
        return example;
    }

    /**
    * 组装模糊搜索Example
    * @param fuzzyText
    * @return
    */
    private UserMessageExample assFuzzyExample(String fuzzyText) {
        UserMessageExample example = new UserMessageExample();
        UserMessageExample.Criteria criteria = example.createCriteria();
        //criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}