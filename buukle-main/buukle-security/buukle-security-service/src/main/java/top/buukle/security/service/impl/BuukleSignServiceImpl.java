package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.status.StatusConstants;

import top.buukle.security .dao.BuukleSignMapper;
import top.buukle.security .dao.CommonMapper;
import top.buukle.security .entity.User;
import top.buukle.security .entity.BuukleSign;
import top.buukle.security .entity.BuukleSignExample;
import top.buukle.security .entity.vo.BaseQuery;
import top.buukle.security .entity.vo.BuukleSignQuery;
import top.buukle.security .plugin.util.SessionUtil;
import top.buukle.security .service.BuukleSignService;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.constants.BuukleSignEnums;
import top.buukle.security .service.exception.SystemException;
import top.buukle.security .service.util.ConvertHumpUtil;
import top.buukle.util.DateUtil;
import top.buukle.util.JsonUtil;
import top.buukle.util.StringUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description BuukleSignService实现类
*/
@Service("buukleSignService")
public class BuukleSignServiceImpl implements BuukleSignService{

    @Autowired
    private BuukleSignMapper buukleSignMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((BuukleSignQuery)query).getPage(),((BuukleSignQuery)query).getPageSize());
        List<BuukleSign> list = buukleSignMapper.selectByExample(this.assExampleForList(((BuukleSignQuery)query)));
        PageInfo<BuukleSign> pageInfo = new PageInfo<>(list);
        return new PageResponse.Builder().build(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
    }

    /**
     * 根据id删除记录状态数据
     * @param id 删除数据实例
     * @param request httpServletRequest
     * @param response
     * @return
     */
    @Override
    public CommonResponse delete(Integer id, HttpServletRequest request, HttpServletResponse response) {
        if(buukleSignMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, BuukleSignEnums.status.DELETED.value(),request,response)) != 1){
            throw new SystemException(SystemReturnEnum.DELETE_INFO_EXCEPTION);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 批量删除
     * @param ids
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public CommonResponse deleteBatch(String ids, HttpServletRequest request, HttpServletResponse response) {
        String trimIds = ids.trim();
        String[] split = trimIds.split(",");
        if(StringUtil.isEmpty(trimIds) || split.length<1){
            throw new SystemException(SystemReturnEnum.USER_BATCH_DELETE_IDS_NULL);
        }
        List<Integer> idList = JsonUtil.parseArray(JsonUtil.toJSONString(Arrays.asList(split)), Integer.class);
        BuukleSignExample buukleSignExample = new BuukleSignExample();
        BuukleSignExample.Criteria criteria = buukleSignExample.createCriteria();
        criteria.andIdIn(idList);
        BuukleSign buukleSign = new BuukleSign();

        User operator = SessionUtil. getOperator(request, response);
        buukleSign.setGmtModified(new Date());
        buukleSign.setModifier(operator.getUsername());
        buukleSign.setModifierCode(operator.getUserId());

        buukleSign.setStatus(BuukleSignEnums.status.DELETED.value());
        buukleSignMapper.updateByExampleSelective(buukleSign,buukleSignExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.buukle.security.entity.BuukleSign
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public BuukleSign selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new BuukleSign();
        }
        BuukleSign buukleSign = buukleSignMapper.selectByPrimaryKey(id);
        return buukleSign == null ? new BuukleSign() : buukleSign;
    }

    /**
     * @description 新增或者修改
     * @param query
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/5
     */
    @Override
    public CommonResponse saveOrEdit(BuukleSignQuery query, HttpServletRequest request, HttpServletResponse response) {
        validateParamForSaveOrEdit(query);
        // 新增
        if(query.getId() == null){
            this.save(query,request,response);
        }
        // 更新
        else{
            this.update(query,request,response);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * 模糊搜素
     * @param text 模糊的字符
     * @param fieldName 模糊字段名
     * @return FuzzyResponse
     */
    @Override
    public FuzzyResponse fuzzySearch(String text, String fieldName) {
        FuzzyVo fuzzyVo = new FuzzyVo();
        fuzzyVo.setText(text);
        fuzzyVo.setFieldName(fieldName);
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("BuukleSign"));
        return new FuzzyResponse.Builder().build(commonMapper.fuzzySearch(fuzzyVo));
    }

    /**
     * 保存记录
     * @param query  查询实体
     * @param request httpServletRequest
     * @param response
     * @return
     */
    @Override
    public CommonResponse save(BaseQuery query, HttpServletRequest request, HttpServletResponse response) {

        buukleSignMapper.insert(this.assQueryForInsert((BuukleSignQuery)query,request,response));
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * 更新记录
     * @param query
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResponse update(BaseQuery query, HttpServletRequest request, HttpServletResponse response) {
        BuukleSignQuery buukleSignQuery = ((BuukleSignQuery)query);

        BuukleSignExample example = new BuukleSignExample();
        BuukleSignExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(buukleSignQuery.getId());
        User operator = SessionUtil. getOperator(request, response);
        buukleSignQuery.setGmtModified(new Date());
        buukleSignQuery.setModifier(operator.getUsername());
        buukleSignQuery.setModifierCode(operator.getUserId());
        buukleSignMapper.updateByExampleSelective(buukleSignQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(BuukleSignQuery query) {
        // TODO
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private BuukleSign assQueryForInsert(BuukleSignQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(BuukleSignEnums.status.INIT.value());
        query.setGmtCreated(new Date());
        User operator = SessionUtil.getOperator(request, response);
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());

        return query;
    }

    /**
     * 组装更新状态实体
     * @param id
     * @param status
     * @param request
     * @param response
     * @return
     */
    private BuukleSign assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        BuukleSignQuery infoQuery = new BuukleSignQuery();
        User operator = SessionUtil. getOperator(request, response);
        infoQuery.setId(id);
        infoQuery.setStatus(status);
        infoQuery.setGmtModified(new Date());
        infoQuery.setModifier(operator.getUsername());
        infoQuery.setModifierCode(operator.getUserId());
        return infoQuery;
    }

    /**
     * 组装分页参数
     * @param query
     * @return
     */
    private BuukleSignExample assExampleForList(BuukleSignQuery query) {
        BuukleSignExample example = new BuukleSignExample();
        BuukleSignExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(query.getId() != null){
            criteria.andIdEqualTo(query.getId());
        }
        // TODO
        if(StringUtil.isNotEmpty(query.getStates())){
            List list = new ArrayList();
            for (String state : query.getStates().split(",")) {
                list.add(Integer.parseInt(state));
            }
            criteria.andStatusIn(list);
        }
        criteria.andStatusNotEqualTo(StatusConstants.DELETED);
        example.setOrderByClause("gmt_modified desc");
        return example;
    }
}