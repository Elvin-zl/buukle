package top.buukle.consumer.www.entity.vo;

import top.buukle.consumer.www.entity.ArticleComment;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/14.
 * @Description :
 */
public class CommentResponseVo extends ArticleComment {

    /** 回复列表*/
    private List<CommentResponseVo> sons;

    /** 是否是作者*/
    private boolean authorFlag;

    public List<CommentResponseVo> getSons() {
        return sons;
    }

    public void setSons(List<CommentResponseVo> sons) {
        this.sons = sons;
    }

    public boolean isAuthorFlag() {
        return authorFlag;
    }

    public void setAuthorFlag(boolean authorFlag) {
        this.authorFlag = authorFlag;
    }
}
