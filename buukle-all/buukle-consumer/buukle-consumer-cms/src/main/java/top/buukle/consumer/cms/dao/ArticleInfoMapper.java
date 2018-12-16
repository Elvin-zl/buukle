package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.ArticleInfo;
import top.buukle.consumer.cms.entity.ArticleInfoExample;

@Mapper
public interface ArticleInfoMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    long countByExample(ArticleInfoExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int deleteByExample(ArticleInfoExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int insert(ArticleInfo record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int insertSelective(ArticleInfo record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    List<ArticleInfo> selectByExampleWithBLOBs(ArticleInfoExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    List<ArticleInfo> selectByExample(ArticleInfoExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    ArticleInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int updateByExampleSelective(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int updateByExample(@Param("record") ArticleInfo record, @Param("example") ArticleInfoExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int updateByPrimaryKeySelective(ArticleInfo record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(ArticleInfo record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    int updateByPrimaryKey(ArticleInfo record);
}