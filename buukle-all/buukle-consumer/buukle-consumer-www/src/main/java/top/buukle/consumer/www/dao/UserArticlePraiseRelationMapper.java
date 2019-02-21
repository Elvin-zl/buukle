package top.buukle.consumer.www.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.UserArticlePraiseRelation;
import top.buukle.consumer.www.entity.UserArticlePraiseRelationExample;

@Mapper
public interface UserArticlePraiseRelationMapper {
    /**
     */
    long countByExample(UserArticlePraiseRelationExample example);

    /**
     */
    int deleteByExample(UserArticlePraiseRelationExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(UserArticlePraiseRelation record);

    /**
     */
    int insertSelective(UserArticlePraiseRelation record);

    /**
     */
    List<UserArticlePraiseRelation> selectByExample(UserArticlePraiseRelationExample example);

    /**
     */
    UserArticlePraiseRelation selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") UserArticlePraiseRelation record, @Param("example") UserArticlePraiseRelationExample example);

    /**
     */
    int updateByExample(@Param("record") UserArticlePraiseRelation record, @Param("example") UserArticlePraiseRelationExample example);

    /**
     */
    int updateByPrimaryKeySelective(UserArticlePraiseRelation record);

    /**
     */
    int updateByPrimaryKey(UserArticlePraiseRelation record);
}