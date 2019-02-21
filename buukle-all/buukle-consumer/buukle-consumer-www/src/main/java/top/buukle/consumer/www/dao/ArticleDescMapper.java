package top.buukle.consumer.www.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.ArticleDesc;
import top.buukle.consumer.www.entity.ArticleDescExample;

import java.util.List;

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