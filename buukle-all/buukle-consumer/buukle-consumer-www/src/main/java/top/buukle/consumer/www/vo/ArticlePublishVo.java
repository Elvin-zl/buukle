package top.buukle.consumer.www.vo;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/23.
 * @Description : 文章发布vo
 */
public class ArticlePublishVo {

    private String title;
    private String articleDesc;
    private String articleContent;
    private String images;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getArticleCatId() {
        return articleCatId;
    }

    public void setArticleCatId(Integer articleCatId) {
        this.articleCatId = articleCatId;
    }
}
