/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.provider.security.constants.SecurityConstants;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.provider.security.dao.UserMapper;
import top.buukle.plugin.security.entity.User;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.GroupsService;
import top.buukle.provider.security.dao.GroupsMapper;
import top.buukle.plugin.security.entity.Groups;
import top.buukle.plugin.security.vo.query.GroupsQuery;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 组别service
 * @author elvin
 *
 */
@Service("groupsService")
public class GroupsServiceImpl implements GroupsService {
	@Resource
	private GroupsMapper groupsMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public void save(Groups groups) throws Exception {
		groupsMapper.insert(groups);
	}
	@Override
	public void update(Groups groups) throws Exception {
		groupsMapper.updateByPrimaryKeySelective(groups);
	}
	@Override
	public void delete(Groups groups) throws Exception {
	}

	/**
	 * 分页获取组别列表
	 * @param query
	 * @param pageBounds
	 * @return
	 */
	@Override
	public PageResponse<Groups> getGroupsList(GroupsQuery query, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<Groups> list = groupsMapper.getGroupsList(query);
        return new PageResponse.Builder().build(new PageInfo<>(list));
	}

    /**
     * 模糊搜素
     * @param fuzzyText
     * @return
     */
	@Override
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) {
        List<Groups> groupsList = groupsMapper.fuzzySearchByName("%" + fuzzyText + "%");
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(groupsList)){
            for (Groups groups: groupsList) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                fuzzySearchListVo.setText(groups.getName());
                fuzzySearchListVos.add(fuzzySearchListVo);
            }
        }
        return fuzzySearchListVos;
    }

    /**
     * 添加组别
     * @param request
     * @param query
     * @return
     */
    @Override
    public BaseResponse addGroups(HttpServletRequest request, GroupsQuery query) throws InvocationTargetException, IllegalAccessException {
        groupsMapper.insert(this.validateAddParam(request, query));
        //清除组别相关缓存
        this.refreshCaChe(query,true);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 清除缓存
     * @param query
     * @param isAdd
     */
    private void refreshCaChe(GroupsQuery query, boolean isAdd) {
        //更新全局组别缓存
        UserInvoker.clearGlobalCacheInfoByType(Groups.class);
        if(!isAdd){
            //清除拥有该组别用户的组别缓存 ==>> TODO 此处可优化为异步线程处理
            List<User> users = userMapper.getUserByGroupsId(query.getId());
            if(CollectionUtils.isNotEmpty(users)){
                for (User user : users) {
                    UserInvoker.clearUserCacheInfoByType(Groups.class,user.getUserId());
                }
            }
        }
    }

    /**
     * 查询组别详情
     * @param query
     * @return
     */
    @Override
    public Groups getGroupsDetail(GroupsQuery query) {
        return groupsMapper.selectByPrimaryKey(query.getId());
    }

    /**
     * 编辑组别
     * @param request
     * @param id
     *@param query
     * @return
     */
    @Override
    public BaseResponse editGroups(HttpServletRequest request, Integer id, GroupsQuery query) throws InvocationTargetException, IllegalAccessException {
        //校验参数
        this.validateUpdateParam(query);
        query.setId(id);
        Groups groups = this.assGroups(request, query, false);
        groupsMapper.updateByPrimaryKeySelective(groups);
        //更新缓存
        refreshCaChe(query,false);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 起停用组别
     * @param request
     * @param query
     * @return
     */
    @Override
    public BaseResponse doBanOrRelease(HttpServletRequest request, GroupsQuery query) throws InvocationTargetException, IllegalAccessException {
        if(query == null){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
        }
        Groups button = groupsMapper.selectByPrimaryKey(query.getId());
        if(button.getBak02().equals(SecurityConstants.DELETE_LEVEL_SYSTEM) && query.getStatus() != null && query.getStatus().equals(SecurityStatusConstants.STATUS_CLOSE)){
            throw new BaseException(BaseResponseCode.EDIT_FORBIDDEN);
        }
        if(query.getStatus().equals(SecurityStatusConstants.STATUS_OPEN)){
            query.setStatus(SecurityStatusConstants.STATUS_CLOSE);
        }else{
            query.setStatus(SecurityStatusConstants.STATUS_OPEN);
        }
        groupsMapper.updateByPrimaryKeySelective(this.assGroups(request, query, false));
        //更新缓存
        this.refreshCaChe(query,false);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 校验添加参数
     * @param request
     * @param query
     * @return
     */
    private Groups validateAddParam(HttpServletRequest request, GroupsQuery query) throws InvocationTargetException, IllegalAccessException {
        if(StringUtil.isEmpty(query.getName())){
            throw new BaseException(BaseResponseCode.GROUPS_ADD_NAME_NULL);
        }
        if(query.getStatus() == null){
            throw new BaseException(BaseResponseCode.GROUPS_ADD_STATUS_NULL);
        }
        return this.assGroups(request, query, true);
    }

    /**
     * 校验参数
     * @param query
     */
    private void validateUpdateParam(GroupsQuery query) {
        Groups groups = groupsMapper.selectByPrimaryKey(query.getId());
        if(null == groups){
            throw new BaseException(BaseResponseCode.FAILED);
        }
        if(groups.getBak01().equals(SecurityConstants.DELETE_LEVEL_SYSTEM)  && query.getStatus() !=null && query.getStatus().equals(SecurityStatusConstants.STATUS_CLOSE)){
            throw new BaseException(BaseResponseCode.EDIT_FORBIDDEN);
        }
        if(groups.getBak01().equals(SecurityConstants.DELETE_LEVEL_SYSTEM)){
            query.setStatus(SecurityStatusConstants.STATUS_OPEN);
        }
        if(StringUtil.isEmpty(query.getName())){
            throw new BaseException(BaseResponseCode.GROUPS_EDIT_NAME_NULL);
        }
        if(null == query.getStatus()){
            throw new BaseException(BaseResponseCode.GROUPS_EDIT_STATUS_NULL);
        }
    }
    /**
     * 组装角色
     * @param request
     * @param query
     * @param isAdd
     * @return
     */
    private Groups assGroups(HttpServletRequest request, GroupsQuery query, boolean isAdd) throws InvocationTargetException, IllegalAccessException {
        Groups groups = new Groups();
        User operator = UserInvoker.getUser(CookieUtil.getUserCookie(request));
        BeanUtils.copyProperties(groups,query);
        if(isAdd){
            groups.setGmtCreated(new Date());
            groups.setCreatorCode(operator.getUserId());
            groups.setCreator(operator.getUsername());
            groups.setBak01(SecurityConstants.DELETE_LEVEL_TRUE);
        }else{
            groups.setModifier(operator.getUsername());
            groups.setGmtModified(new Date());
            groups.setModifierCode(operator.getUserId());
        }
        return groups;
    }
}
