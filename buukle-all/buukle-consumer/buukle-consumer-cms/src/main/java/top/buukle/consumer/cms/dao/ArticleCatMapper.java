package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.ArticleCat;
import top.buukle.consumer.cms.entity.ArticleCatExample;

@Mapper
public interface ArticleCatMapper {
    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    long countByExample(ArticleCatExample example);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    int deleteByExample(ArticleCatExample example);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    int insert(ArticleCat record);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    int insertSelective(ArticleCat record);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    List<ArticleCat> selectByExample(ArticleCatExample example);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    ArticleCat selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    int updateByExampleSelective(@Param("record") ArticleCat record, @Param("example") ArticleCatExample example);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    int updateByExample(@Param("record") ArticleCat record, @Param("example") ArticleCatExample example);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    int updateByPrimaryKeySelective(ArticleCat record);

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    int updateByPrimaryKey(ArticleCat record);
}