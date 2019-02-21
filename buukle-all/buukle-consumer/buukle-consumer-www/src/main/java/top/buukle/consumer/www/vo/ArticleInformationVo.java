package top.buukle.consumer.www.vo;

import top.buukle.consumer.www.entity.ArticleCat;
import top.buukle.consumer.www.entity.ArticleInfo;
import top.buukle.consumer.www.entity.UserArticlePraiseRelation;
import top.buukle.plugin.security.entity.User;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/23.
 * @Description : 文章发布vo
 */
public class ArticleInformationVo {

    private ArticleInfo articleInfo;
    private User articleAuthor;
    private ArticleCat articleCat;
    private String articleDesc;
    private String articleContent;
    private Integer articleCatId;
    private long articleCommentSum;
    private UserArticlePraiseRelation praiseRelation;


    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }

    public User getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(User articleAuthor) {
        this.articleAuthor = articleAuthor;
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

    public UserArticlePraiseRelation getPraiseRelation() {
        return praiseRelation;
    }

    public void setPraiseRelation(UserArticlePraiseRelation praiseRelation) {
        this.praiseRelation = praiseRelation;
    }

    public long getArticleCommentSum() {
        return articleCommentSum;
    }

    public void setArticleCommentSum(long articleCommentSum) {
        this.articleCommentSum = articleCommentSum;
    }
}
