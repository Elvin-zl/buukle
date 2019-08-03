$(function(){
    // 绑定滚屏
    bindScroll();
    //渲染信息流内容
    renderTimelineContent();
    //绑定点赞
    // bindPraiseClick();
    //渲染评论
    renderTimelineComment();
    //渲染微信jsapi
    renderWeChatJsApi();
});

/*渲染微信jsapi*/
function renderWeChatJsApi() {
    // 请求后台获取appid,生成签名的时间戳,签名
    var urlh = location.href.split('#')[0];
    $.ajax({
        url : "/wechatApi/initWXJSInterface",
        method : "post",
        dataType : 'json',
        data : {'url' : urlh},
        success : function(data){
            var url = data.url;

            wx.config({
                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: data.appIds, // 必填，公众号的唯一标识
                timestamp: data.timestamps, // 必填，生成签名的时间戳
                nonceStr: data.nonceStrs, // 必填，生成签名的随机串
                signature: data.signatures,// 必填，签名
                jsApiList: [
                    // 所有要调用的 API 都要加到这个列表中
                    'checkJsApi',
                    'openLocation',
                    'getLocation',
                    'onMenuShareTimeline',
                    'onMenuShareAppMessage'
                ]
            });
            // 设置分享效果
            wx.ready(function(){
                wx.onMenuShareAppMessage({
                    title: $('#title').html(),
                    desc: $('#articleDesc').val(),
                    link: url,
                    imgUrl: $('#titleImage').val(),
                    success : function () {
                        alert("发送成功!");
                    },
                    cancel: function () {
                        alert("取消成功!");
                    }
                });
                wx.onMenuShareTimeline({
                    title: $('#title').html(),
                    desc: $('#articleDesc').val(),
                    link: url,
                    imgUrl: $('#titleImage').val(),
                    success : function () {
                        alert("发送成功!");
                    },
                    cancel: function () {
                        alert("取消成功!");
                    }
                });
            });
        }
    });
}
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
/*渲染信息流内容*/
function renderTimelineContent() {
    editormd.markdownToHTML("timelineContent", {
        htmlDecode      : "style,script,iframe",  // you can filter tags decode
        emoji           : true,
        taskList        : true,
        tex             : true,  // 默认不解析
        flowChart       : true,  // 默认不解析
        sequenceDiagram : false   // 默认不解析
    });
}

/*渲染评论*/
function renderTimelineComment() {
    var html = '<div class="alert alert-danger false"><i class="fa fa-smile-o"></i>&nbsp;<span>只有登录之后才能评论哦。</span></div>'+
                '<textarea id="pl-text-root" style="resize: none;" class="form-control" placeholder="说点什么吧..."></textarea>'+
                '<button type="button" data-commentId="root" data-pidType="1" class="btn btn-success pl-sub">提交评论</button>';
    $('#commitComment').html(html);
    $('#comments').load('/timelineComment/toTimelineComments?timelineInfoId='+$('#timelineInfoId').val()+'&page=1&limit=5');
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