//@ sourceURL=articleComments.js
/*绑定回复按钮事件*/

$(function () {
    // 绑定回复按钮
    bindSaveReplyClick();
    // 绑定删除按钮
    bindDeleteClick();
});

/*绑定删除按钮*/
function bindDeleteClick() {
    $('.deleteComment').off().on('click',function () {
        // 初始化参数
        var id = $(this).attr('id');
        // 异步删除
        $.ajax({
            url : '/articleComment/deleteComment',
            method : 'post',
            dataType : 'json',
            data : {"id" : id},
            success : function (data) {
                renderComment();
            }
        })
    })
}
/* 绑定回复按钮*/
function bindSaveReplyClick() {
    $('.pl-sub').click(function(){
        var delButton = $('#del-text' + $(this).attr('data-commentId'));
        var pidType = $(this).attr('data-pidType');
        var pid = $(this).attr('data-commentId');
        var comment = $('#pl-text' + $(this).attr('data-commentId')).val();
        // 处理评论和回复
        if(pid == 'root'){
            pid = $('#articleId').val();
            comment = $('#pl-text-root').val();
        }
        delButton.hide();
        if(comment == ''){
            $(this).parent().find('.false span').html('评论内容不能为空哦');
            $(this).parent().find('.false').fadeIn();
            setTimeout(function () {
                $('.false').fadeOut();
            }, 1500);
        }else{
            // 验证登录状态
            if($('#userIdHead').val() == undefined || $('#userIdHead').val() == ''){
                banThis($(this),"操作中");
                $(this).parent().find('.false span').html('请登录后再回复哦~');
                $(this).parent().find('.false').fadeIn();
                setTimeout(function () {
                    $('.false').fadeOut()
                }, 1500);
                releaseThis($(this),"回复");
            }else{
                banThis($(this),"保存中");
                $(this).parent().find('.false span').html('正在保存... ');
                $(this).parent().find('.false').fadeIn();
                var tempThis = $(this);
                setTimeout(function () {
                    $('.false').fadeOut();
                }, 3500);
                // 提交评论
                $.ajax({
                    url : '/articleComment/saveComment',
                    method : 'post',
                    data : {"creator" : $('#userIdHead').val(),"pid" : pid,"pidType":pidType,"comment" : comment,"articleInfoId": $('#articleId').val()},
                    dataType : 'json',
                    success : function (data) {
                        if(data.status == 'S'){
                            tempThis.parent().find('.false span').html('评论成功!');
                            tempThis.parent().find('.false').fadeIn();
                            setTimeout(function () {
                                $('.false').fadeOut()
                            }, 1500);
                            releaseThis(tempThis,"回复");
                            renderComment();
                            var html = '<div class="alert alert-danger false"><i class="fa fa-smile-o"></i>&nbsp;<span>只有登录之后才能评论哦。</span></div>'+
                                '<textarea id="pl-text-root" style="resize: none;" class="form-control" placeholder="说点什么吧..."></textarea>'+
                                '<button type="button" data-commentId="root" data-pidType="1" class="btn btn-success pl-sub">提交评论</button>';
                            $('#commitComment').html(html);
                        }else{
                            delButton.show();
                            tempThis.parent().find('.false span').html('评论失败!' + data.msg);
                            tempThis.parent().find('.false').fadeIn();
                            setTimeout(function () {
                                $('.false').fadeOut()
                            }, 1500);
                            releaseThis(tempThis,"回复");
                        }
                    },
                    error: function(data){
                        delButton.show();
                        tempThis.parent().find('.false span').html('评论失败!' + data.msg);
                        tempThis.parent().find('.false').fadeIn();
                        setTimeout(function () {
                            $('.false').fadeOut()
                        }, 1500);
                        releaseThis(tempThis,"回复");
                    }
                })
            }
        }
    });
}