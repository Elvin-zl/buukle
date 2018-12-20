package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.ArticleDesc;
import top.buukle.consumer.cms.entity.ArticleDescExample;

@Mapper
public interface ArticleDescMapper {
    /**
     */
    long countByExample(ArticleDescExample example);

    /**
     */
    int deleteByExample(ArticleDescExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(ArticleDesc record);

    /**
     */
    int insertSelective(ArticleDesc record);

    /**
     */
    List<ArticleDesc> selectByExampleWithBLOBs(ArticleDescExample example);

    /**
     */
    List<ArticleDesc> selectByExample(ArticleDescExample example);

    /**
     */
    ArticleDesc selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") ArticleDesc record, @Param("example") ArticleDescExample example);

    /**
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleDesc record, @Param("example") ArticleDescExample example);

    /**
     */
    int updateByExample(@Param("record") ArticleDesc record, @Param("example") ArticleDescExample example);

    /**
     */
    int updateByPrimaryKeySelective(ArticleDesc record);

    /**
     */
    int updateByPrimaryKeyWithBLOBs(ArticleDesc record);

    /**
     */
    int updateByPrimaryKey(ArticleDesc record);
}