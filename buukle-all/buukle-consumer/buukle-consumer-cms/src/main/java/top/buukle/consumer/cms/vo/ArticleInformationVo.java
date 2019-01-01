package top.buukle.consumer.cms.vo;

import top.buukle.consumer.cms.entity.ArticleCat;
import top.buukle.consumer.cms.entity.ArticleInfo;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/23.
 * @Description : 文章发布vo
 */
public class ArticleInformationVo {

    private ArticleInfo articleInfo;
    private ArticleCat articleCat;
    private String articleDesc;
    private String articleContent;
    private Integer articleCatId;

    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }

    public ArticleCat getArticleCat() {
        return articleCat;
    }

    public void setArticleCat(ArticleCat articleCat) {
        this.articleCat = articleCat;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArticleCatId() {
        return articleCatId;
    }

    public void setArticleCatId(Integer articleCatId) {
        this.articleCatId = articleCatId;
    }
}
