package top.buukle.consumer.www.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.ArticleComment;
import top.buukle.consumer.www.entity.ArticleCommentExample;

@Mapper
public interface ArticleCommentMapper {
    /**
     */
    long countByExample(ArticleCommentExample example);

    /**
     */
    int deleteByExample(ArticleCommentExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(ArticleComment record);

    /**
     */
    int insertSelective(ArticleComment record);

    /**
     */
    List<ArticleComment> selectByExample(ArticleCommentExample example);

    /**
     */
    ArticleComment selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    /**
     */
    int updateByExample(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    /**
     */
    int updateByPrimaryKeySelective(ArticleComment record);

    /**
     */
    int updateByPrimaryKey(ArticleComment record);

    long selectCountOfArticle(@Param("articleInfoId") Integer articleInfoId);

}