package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.status.StatusConstants;

import top.buukle.security .dao.ItemMapper;
import top.buukle.security .dao.CommonMapper;
import top.buukle.security .entity.User;
import top.buukle.security .entity.Item;
import top.buukle.security .entity.ItemExample;
import top.buukle.security .entity.vo.BaseQuery;
import top.buukle.security.entity.vo.DynamicCondition;
import top.buukle.security .entity.vo.ItemQuery;
import top.buukle.security .plugin.util.SessionUtil;
import top.buukle.security .service.ItemService;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.constants.ItemEnums;
import top.buukle.security .service.exception.SystemException;
import top.buukle.security .service.util.ConvertHumpUtil;
import top.buukle.util.DateUtil;
import top.buukle.util.JsonUtil;
import top.buukle.util.StringUtil;
import top.buukle.util.log.BaseLogger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
* @author elvin
* @description ItemService实现类
*/
@Service("itemService")
public class ItemServiceImpl implements ItemService{

    private static final BaseLogger LOGGER = BaseLogger.getLogger(ItemServiceImpl.class);
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((ItemQuery)query).getPage(),((ItemQuery)query).getPageSize());
        List<Item> list = itemMapper.selectByExample(this.assExampleForList(((ItemQuery)query)));
        PageInfo<Item> pageInfo = new PageInfo<>(list);
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
        if(itemMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, ItemEnums.status.DELETED.value(),request,response)) != 1){
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
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andIdIn(idList);
        Item item = new Item();

        User operator = SessionUtil. getOperator(request, response);
        item.setGmtModified(new Date());
        item.setModifier(operator.getUsername());
        item.setModifierCode(operator.getUserId());

        item.setStatus(ItemEnums.status.DELETED.value());
        itemMapper.updateByExampleSelective(item,itemExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.buukle.security.entity.Item
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public Item selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new Item();
        }
        Item item = itemMapper.selectByPrimaryKey(id);
        return item == null ? new Item() : item;
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
    public CommonResponse saveOrEdit(ItemQuery query, HttpServletRequest request, HttpServletResponse response) {
        validateParamForSaveOrEdit(query);
        // json化商品表单数据
        query.setDetail(JsonUtil.toJSONString(handleParams(request.getParameterMap())));
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
     * @description 商品列表查询接口
     * @return top.buukle.common.call.CommonResponse
     * @Author zhanglei1102
     * @Date 2019/8/7
     *
     * @param query
     */
    @Override
    public PageResponse itemList(Map<String, String> query) {
        ItemQuery<Map<String, String>> mapItemQuery = this.handleQueryParams(query);
        Integer pageNo = mapItemQuery.getPage();
        Integer pageSize = mapItemQuery.getPageSize();
        PageHelper.startPage(pageNo,pageSize);
        List<Item> list = itemMapper.itemList(this.creatCondition(query));
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        return new PageResponse.Builder().build(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
    }

    private ItemQuery<Map<String, String>> handleQueryParams(Map<String,String> paramMap){
        ItemQuery<Map<String, String>> itemQuery=new ItemQuery<>();
        //封装排序参数
//        String sortParams=paramMap.get("sortParams");
//        if(StringUtil.isNotEmpty(sortParams)){
//            List<Sort> sorts = Lists.newArrayList();
//            List<Map<String,String>> sortList= JsonUtils.parseObject(sortParams,List.class);
//            for(Map<String,String> sortMap:sortList){
//                for(String key:sortMap.keySet()){
//                    if(sortMap.get(key) == null){
//                        continue;
//                    }
//                    sorts.add(new Sort(sortMap.get(key),key));
//                }
//            }
//            pageQuery.setSort(sorts);
//        }
        itemQuery.setPage(Integer.valueOf(paramMap.get("pageNo"),Integer.valueOf(paramMap.get("pageSize"))));
        paramMap.remove("pageNo");
        paramMap.remove("pageSize");
        return itemQuery;
    }

    private String creatCondition(Map<String, String> queryMap) {
        List<DynamicCondition> conditions = StringUtil.isEmpty(queryMap.get("rangeParams")) ? null : JsonUtil.parseArray(queryMap.get("rangeParams"),DynamicCondition.class);
        queryMap.remove("rangeParams");
        String condition = StringUtil.EMPTY;
        if(!CollectionUtils.isEmpty(conditions)){
            for (DynamicCondition dynamicCondition: conditions) {
                if(StringUtil.isNotEmpty(dynamicCondition.getBegin())){ //  detail -> '$.fundCloseBeginDate'  < "2019-06-10";
                    condition += " and detail -> '$."+ dynamicCondition.getAttrName() +"'  > '"+ dynamicCondition.getBegin() +"' ";
                }
                if(StringUtil.isNotEmpty(dynamicCondition.getEnd())){
                    condition += " and detail -> '$."+ dynamicCondition.getAttrName() +"'  < '"+ dynamicCondition.getEnd() +"' ";
                }
            }
        }
        if(queryMap.size() > 0){
            for (Map.Entry entry: queryMap.entrySet()) {
                condition += " and detail -> '$."+ entry.getKey() +"'  = '"+ entry.getValue() +"' ";
            }
        }
        return condition;
    }

    private Map<String, String> handleParams(Map<String, String[]> map) {

        Map<String, String> item = Maps.newHashMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.indexOf("[]") > 0) {
                item.put(key.replace("[]", ""), JsonUtil.toJSONString(entry.getValue()));
            } else {
                item.put(key, entry.getValue()[0]);
            }
        }
        return item;
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("Item"));
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

        itemMapper.insert(this.assQueryForInsert((ItemQuery)query,request,response));
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
        ItemQuery itemQuery = ((ItemQuery)query);

        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemQuery.getId());
        User operator = SessionUtil. getOperator(request, response);
        itemQuery.setGmtModified(new Date());
        itemQuery.setModifier(operator.getUsername());
        itemQuery.setModifierCode(operator.getUserId());
        itemMapper.updateByExampleSelective(itemQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(ItemQuery query) {
        // TODO
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private Item assQueryForInsert(ItemQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(ItemEnums.status.INIT.value());
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
    private Item assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        ItemQuery infoQuery = new ItemQuery();
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
    private ItemExample assExampleForList(ItemQuery query) {
        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(query.getId() != null){
            criteria.andIdEqualTo(query.getId());
        }
        if( StringUtil.isNotEmpty(query.getSkuname())){
            criteria.andSkunameEqualTo(query.getSkuname());
        }
        if( StringUtil.isNotEmpty(query.getStates())){
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