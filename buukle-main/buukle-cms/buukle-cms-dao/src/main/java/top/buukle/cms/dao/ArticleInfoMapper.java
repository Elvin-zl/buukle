package top.buukle.cms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.cms.entity.ArticleInfo;
import top.buukle.cms.entity.ArticleInfoExample;

import java.util.List;

@Mapper
public interface ArticleInfoMapper {
    /**
     */
    long countByExample(ArticleInfoExample example);

    /**
     */
    int deleteByExample(ArticleInfoExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(ArticleInfo record);

    /**
     */
    int insertSelective(ArticleInfo record);

    /**
     */
    List<ArticleInfo> selectByExampleWithBLOBs(ArticleInfoExample example);

    /**
     */
    List<ArticleInfo> selectByExample(ArticleInfoExample example);

    /**
     */
    ArticleInfo selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    /**
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    /**
     */
    int updateByExample(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    /**
     */
    int updateByPrimaryKeySelective(ArticleInfo record);

    /**
     */
    int updateByPrimaryKeyWithBLOBs(ArticleInfo record);

    /**
     */
    int updateByPrimaryKey(ArticleInfo record);

}