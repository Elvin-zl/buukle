package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.ArticleContent;
import top.buukle.consumer.cms.entity.ArticleContentExample;

@Mapper
public interface ArticleContentMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    long countByExample(ArticleContentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int deleteByExample(ArticleContentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int insert(ArticleContent record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int insertSelective(ArticleContent record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    List<ArticleContent> selectByExampleWithBLOBs(ArticleContentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    List<ArticleContent> selectByExample(ArticleContentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    ArticleContent selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int updateByExampleSelective(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int updateByExample(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int updateByPrimaryKeySelective(ArticleContent record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(ArticleContent record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:02 CST 2018
     */
    int updateByPrimaryKey(ArticleContent record);
}