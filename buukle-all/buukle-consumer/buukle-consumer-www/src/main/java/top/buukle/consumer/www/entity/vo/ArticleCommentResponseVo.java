package top.buukle.consumer.www.entity.vo;

import top.buukle.consumer.www.entity.ArticleComment;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/14.
 * @Description :
 */
public class ArticleCommentResponseVo  extends ArticleComment {

    /** 回复列表*/
    private List<ArticleCommentResponseVo> sons;

    /** 是否是作者*/
    private boolean authorFlag;

    public List<ArticleCommentResponseVo> getSons() {
        return sons;
    }

    public void setSons(List<ArticleCommentResponseVo> sons) {
        this.sons = sons;
    }

    public boolean isAuthorFlag() {
        return authorFlag;
    }

    public void setAuthorFlag(boolean authorFlag) {
        this.authorFlag = authorFlag;
    }
}
