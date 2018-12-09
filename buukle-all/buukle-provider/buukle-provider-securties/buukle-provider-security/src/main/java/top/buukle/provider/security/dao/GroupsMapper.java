package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.common.annotation.DataIsolationAnnotation;
import top.buukle.provider.security.entity.Groups;
import top.buukle.provider.security.entity.GroupsExample;
import top.buukle.provider.security.vo.query.GroupsQuery;

import java.util.List;

public interface GroupsMapper {
    int countByExample(GroupsExample example);

    int deleteByExample(GroupsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Groups record);

    int insertSelective(Groups record);

    List<Groups> selectByExample(GroupsExample example);

    Groups selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Groups record, @Param("example") GroupsExample example);

    int updateByExample(@Param("record") Groups record, @Param("example") GroupsExample example);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);

    /**
     * 根据用户id获取用户组别
     * @param userId
     * @return
     */
    List<Groups> getUserGroupsByUserId(String userId);

    /**
     * 分页获取组别列表
     * @param query
     * @return
     */
    @DataIsolationAnnotation(tableName = "groups")
    List<Groups> getGroupsList(GroupsQuery query);

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    @DataIsolationAnnotation(tableName = "groups")
    List<Groups> fuzzySearchByName(@Param("fuzzyText") String fuzzyText);

    /**
     * 获取全局组别列表
     * @param groupsQuery
     * @return
     */
    List<Groups> getGroupsListWithNoIsolation(GroupsQuery groupsQuery);
}