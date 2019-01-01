//@ sourceURL=userArticleDetail.js
$(function () {
    //公共初始化
    commonInit();
    //绑定输入校验
    bindInputValidate();
    //绑定按钮点击事件
    bindButtonClick();
    //加载文章数据
    loadArticleInfo();
    //绑定滚轮监听
    bindListener();


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
    //返回
    $('#cancel').off().on('click',function () {
        $('.layui-this', window.parent.document).click();
    })
}

/*校验提交参数*/
function paramValidate() {
    if(!articleTitleFlag ){
        $('#titleErrorMsg').html("题目格式错误!");
        releaseThis($('#publish'));
        releaseThis($('#draft'));
        return false;
    }else{
        $('#titleErrorMsg').html("");
    }
    if(!articleCatFlag ){
        $('#catErrorMsg').html('请选择选择文章类别!');
        releaseThis($('#draft'));
        releaseThis($('#publish'));
        return false;
    }else{
        $('#catErrorMsg').html('');
    }
    if(!articleAbstractFlag){
        $('#abstractErrorMsg').html('文章摘要格式错误!');
        releaseThis($('#draft'));
        releaseThis($('#publish'));
        return false;
    }else{
        $('#abstractErrorMsg').html('');
    }
    return true;
}
/*绑定输入校验*/
var articleTitleFlag = false;
var articleAbstractFlag = false;
var articleCatFlag = false;
var articleCat_frame_index = '';
function bindInputValidate() {
    //输入题目
    var regTittle = new  RegExp(/^([\w]|[\u4e00-\u9fa5]|[()]|[（）]|[ ,]|[,]|[-]|[_]|[:]|[<]|[>]|[《]|[》]){0,64}$/);
    $('#addTitle').off().on('change',function () {
        var articleTitle = $(this).val().trim();
        if(articleTitle == ''){
            articleTitleFlag = false;
            $('#titleErrorMsg').html("题目不能为空!");
            return;
        }
        if(!regTittle.test(articleTitle)){
            articleTitleFlag = false;
            $('#titleErrorMsg').html("题目格式错误!");
            return;
        }else{
            articleTitleFlag = true;
            $('#titleErrorMsg').html("");
            return;
        }
    })
    //输入分类
    $('#addCat').off().on('click',function () {
        $(this).attr('disabled',true);
        $.ajax({
            url:'/articleCat/getArticleCatTree',
            dataType:'json',
            type:'post',
            success:function (data) {
                $('#articleCatTree').find('li').remove();
                layui.use('tree', function(){
                    layui.tree({
                        elem: '#articleCatTree' //传入元素选择器
                        ,nodes:  data,
                        click:function (node) {
                            articleCatFlag = true;
                            $('#addCat').val(node.name);
                            $('#pid').val(node.id);
                        }
                    });
                });
                layui.use("layer",function () {
                    var layer = layui.layer;
                    articleCat_frame_index  = layer.open({
                        title:"选择文章类别",
                        type:1,
                        closeBtn: 0,
                        content: $('#articleCatTree'),
                        area: ['500px', '346px']
                    });
                });
            }
        });
    })
    /*防止二次点击*/
    $('#yes').off().on('click',function () {
        if(articleCatFlag){
            $('#addCat').attr('disabled',false);
            $('#articleCatTree').css('display','none');
            $('#articleCatTree').hide();
            layer.close(articleCat_frame_index);
        }else{
            layer.msg('请选择父级分类~', {icon: 5});
        }
    });
    //输入摘要
    var regArticleAbstract = new  RegExp(/^([\w]|[\u4e00-\u9fa5]|[()]|[（）]|[ ,]|[,]|[-]|[_]|[:]|[<]|[>]|[《]|[》]){0,128}$/);
    $('#addAbstract').off().on('change',function () {
        var articleAbstract = $(this).val().trim();
        if(articleAbstract == ''){
            $('#abstractErrorMsg').html("文章摘要不能为空!");
            articleAbstractFlag = false;
        }else if(!regArticleAbstract.test(articleAbstract)){
            $('#abstractErrorMsg').html("文章摘要格式错误!");
            articleAbstractFlag = false;
        }else{
            articleAbstractFlag = true;
            $('#abstractErrorMsg').html('');
        }
    })
}

//加载文章数据
function loadArticleInfo() {
    $.ajax({
        url:'/articleInfo/getArticleInformation',
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
            //渲染markdown组件
            markdownInit(data.articleContent);
        }
    });

}

/*初始化markdown组件*/
function markdownInit(content) {
    // 渲染markdown
    tui.Editor.factory({
        el: document.querySelector('#viewerSection'),
        viewer: true,
        height: '500px',
        exts: ['table', 'uml', 'chart'],
        initialValue:content
    });
}