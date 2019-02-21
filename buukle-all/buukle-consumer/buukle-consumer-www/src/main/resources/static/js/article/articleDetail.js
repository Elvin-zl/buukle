$(function(){

    // 绑定滚屏
    bindScroll();
    //渲染文章内容
    renderArticleContent();
    //绑定点赞
    bindPraiseClick();
    //渲染评论
    renderComment();
});

/*绑定滚屏*/
function bindScroll() {
    var scrollTop = 0;
    $(window).scroll(function () {
        var nowScrollTop = $(document).scrollTop();
        if (nowScrollTop > scrollTop) {
            $('.wrap').addClass('hide-wrap');
        } else {
            $('.wrap').removeClass('hide-wrap');
        }
        scrollTop = nowScrollTop;
    });
}
/*渲染文章内容*/
function renderArticleContent() {
    editormd.markdownToHTML("articleContent", {
        htmlDecode      : "style,script,iframe",  // you can filter tags decode
        emoji           : true,
        taskList        : true,
        tex             : true,  // 默认不解析
        flowChart       : true,  // 默认不解析
        sequenceDiagram : false   // 默认不解析
    });
}

/*渲染评论*/
function renderComment() {
    var html = '<div class="alert alert-danger false"><i class="fa fa-smile-o"></i>&nbsp;<span>只有登录之后才能评论哦。</span></div>'+
                '<textarea id="pl-text-root" style="resize: none;" class="form-control" placeholder="说点什么吧..."></textarea>'+
                '<button type="button" data-commentId="root" data-pidType="1" class="btn btn-success pl-sub">提交评论</button>';
    $('#commitComment').html(html);
    $('#comments').load('/articleComment/toArticleComments?articleInfoId='+$('#articleId').val()+'&page=1&limit=5');
}

/*绑定点赞*/
var praiseFlag = false;
function bindPraiseClick() {
    $('#praise').off().on('click',function () {
        var relationId = $('#praiseUserId').val();
        praiseFlag = (relationId != '');
        $.ajax({
            url:'/userArticlePraiseRelation/switchPraise',
            method : 'post',
            data:{"articleId" : $('#articleId').val(),"userId" : $('#userIdHead').val(),"praiseFlag":praiseFlag},
            dataType:'json',
            success:function (data) {
                if(data.status == "S"){
                    // 取消赞成功
                    if(praiseFlag){
                        $('#praiseIcon').removeClass('praise-active-i');
                        $('#praiseUserId').val("");
                        $('#praiseTxt').html('点赞');
                        praiseFlag = false;
                    }
                    else{
                        $('#praiseIcon').addClass('praise-active-i');
                        $('#praiseTxt').html('取消赞');
                        $('#praiseUserId').val(data.msg);
                        praiseFlag = true;
                    }
                }else{
                    $.alert('操作失败,请稍后重试!');
                }
            }
        })
    })
}