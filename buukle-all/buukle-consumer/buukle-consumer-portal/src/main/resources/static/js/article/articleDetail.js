$(function(){
    //渲染文章内容
    renderArticleContent();
    //绑定点赞
    bindPraiseClick();

})

/*渲染文章内容*/
function renderArticleContent() {
    tui.Editor.factory({
        el: document.querySelector('#articleContent'),
        viewer: true,
        height: '500px',
        exts: ['table', 'uml', 'chart'],
        initialValue: $('#articleContentTxt').val()
    });
}

var praiseFlag = false;
/*绑定点赞*/
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