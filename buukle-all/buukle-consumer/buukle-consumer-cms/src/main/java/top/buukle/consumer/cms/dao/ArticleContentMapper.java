package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.ArticleContent;
import top.buukle.consumer.cms.entity.ArticleContentExample;

@Mapper
public interface ArticleContentMapper {
    /**
     */
    long countByExample(ArticleContentExample example);

    /**
     */
    int deleteByExample(ArticleContentExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(ArticleContent record);

    /**
     */
    int insertSelective(ArticleContent record);

    /**
     */
    List<ArticleContent> selectByExampleWithBLOBs(ArticleContentExample example);

    /**
     */
    List<ArticleContent> selectByExample(ArticleContentExample example);

    /**
     */
    ArticleContent selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     */
    int updateByExample(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     */
    int updateByPrimaryKeySelective(ArticleContent record);

    /**
     */
    int updateByPrimaryKeyWithBLOBs(ArticleContent record);

    /**
     */
    int updateByPrimaryKey(ArticleContent record);
}