package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.ArticleComment;
import top.buukle.consumer.cms.entity.ArticleCommentExample;

@Mapper
public interface ArticleCommentMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    long countByExample(ArticleCommentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    int deleteByExample(ArticleCommentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    int insert(ArticleComment record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    int insertSelective(ArticleComment record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    List<ArticleComment> selectByExample(ArticleCommentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    ArticleComment selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    int updateByExampleSelective(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    int updateByExample(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    int updateByPrimaryKeySelective(ArticleComment record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:03:58 CST 2018
     */
    int updateByPrimaryKey(ArticleComment record);
}