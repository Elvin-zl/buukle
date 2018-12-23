package top.buukle.consumer.cms.vo;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/23.
 * @Description : 文章发布vo
 */
public class ArticlePublishVo {

    private String title;
    private String articleDesc;
    private String articleContent;
    private Integer articleCatId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
