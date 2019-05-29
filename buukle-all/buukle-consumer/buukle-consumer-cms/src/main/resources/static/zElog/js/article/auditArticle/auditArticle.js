//@ sourceURL=userArticleDetail.js
$(function () {
    //公共初始化
    commonInit();
    //绑定按钮点击事件
    bindButtonClick();
    //加载文章数据
    loadArticleInfo();
    //绑定滚轮监听
    // bindListener();
});
/*绑定滚轮监听*/
function bindListener() {
    $(document).scroll(function(){
        var top=$(document).scrollTop();
        if(top<30){
            $('#articleTitleAbs').show();
        }
        else{
            $('#articleTitleAbs').hide();
        }
    })
}
/*绑定按钮点击事件*/
function bindButtonClick() {
    // 返回
    $('#cancel').off().on('click',function () {
        $('.layui-this', window.parent.document).click();
    });
    // 审核通过
    $('#auditPass').off().on('click',function () {
        if(banThis($(this),"审核中...")){
            $.ajax({
                url:'/articleInfo/auditArticle',
                data:{"id" : $("#current",window.parent.document).attr('data-id'),"status" : 1},
                dataType:'json',
                type:'post',
                success:function (data) {
                    if(data.code == 'S'){

                    }
                    freeThis($(this),"通过");
                }
            });
        }
    });
    // 审核不通过
    $('#auditReject').off().on('click',function () {
        $.ajax({
            url:'/articleInfo/auditArticle',
            data:{"id" : $("#current",window.parent.document).attr('data-id'),"status" : 0},
            dataType:'json',
            type:'post',
            success:function (data) {

            }
        });
    });
}
//加载文章数据
function loadArticleInfo() {
    $.ajax({
        url:'/articleInfo/getArticleInformationForAudit',
        data:{"id" : $("#current",window.parent.document).attr('data-id')},
        dataType:'json',
        type:'post',
        success:function (data) {
            //渲染题目
            $('#title').val(data.articleInfo.title);
            //渲染分类
            $('#articleCat').val(data.articleCat.articleCat);
            //渲染摘要
            $('#articleDesc').val(data.articleDesc);
            //渲染作者
            $('#creator').val(data.articleInfo.articleAuthor);
            //渲染创建时间
            $('#gmtCreated').val(formatDateTime(data.articleInfo.gmtCreated));
            //渲染更新时间
            $('#gmtModified').val(formatDateTime(data.articleInfo.gmtModified));
            //渲染审核者
            $('#auditor').val((data.articleInfo.bak02 == "" || data.articleInfo.bak02 == undefined) ? "无" : data.articleInfo.bak02);
            //渲染markdown组件
            markdownInit(data.articleContent);
        }
    });
}

/*初始化markdown组件*/
function markdownInit(content) {
    content = content.replace('align="center"','align="center" style="padding: 0 400px;"');
    /*渲染文章内容*/
    $('#append-test').html(content);
    // console.log(content);
    editormd.markdownToHTML("articleContent", {
        htmlDecode      : "style,script,iframe",  // you can filter tags decode
        emoji           : true,
        taskList        : true,
        tex             : true,  // 默认不解析
        flowChart       : true,  // 默认不解析
        sequenceDiagram : false   // 默认不解析
    });
}