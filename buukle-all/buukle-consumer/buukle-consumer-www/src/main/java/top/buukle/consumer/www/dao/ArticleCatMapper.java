package top.buukle.consumer.www.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.ArticleCat;
import top.buukle.consumer.www.entity.ArticleCatExample;

import java.util.List;

@Mapper
public interface ArticleCatMapper {
    /**
     */
    long countByExample(ArticleCatExample example);

    /**
     */
    int deleteByExample(ArticleCatExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(ArticleCat record);

    /**
     */
    int insertSelective(ArticleCat record);

    /**
     */
    List<ArticleCat> selectByExample(ArticleCatExample example);

    /**
     */
    ArticleCat selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") ArticleCat record, @Param("example") ArticleCatExample example);

    /**
     */
    int updateByExample(@Param("record") ArticleCat record, @Param("example") ArticleCatExample example);

    /**
     */
    int updateByPrimaryKeySelective(ArticleCat record);

    /**
     */
    int updateByPrimaryKey(ArticleCat record);
}