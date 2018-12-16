package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.ArticleDesc;
import top.buukle.consumer.cms.entity.ArticleDescExample;

@Mapper
public interface ArticleDescMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    long countByExample(ArticleDescExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int deleteByExample(ArticleDescExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int insert(ArticleDesc record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int insertSelective(ArticleDesc record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    List<ArticleDesc> selectByExampleWithBLOBs(ArticleDescExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    List<ArticleDesc> selectByExample(ArticleDescExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    ArticleDesc selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int updateByExampleSelective(@Param("record") ArticleDesc record, @Param("example") ArticleDescExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleDesc record, @Param("example") ArticleDescExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int updateByExample(@Param("record") ArticleDesc record, @Param("example") ArticleDescExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int updateByPrimaryKeySelective(ArticleDesc record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(ArticleDesc record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:07 CST 2018
     */
    int updateByPrimaryKey(ArticleDesc record);
}