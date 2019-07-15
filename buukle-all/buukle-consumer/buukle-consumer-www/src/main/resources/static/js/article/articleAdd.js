$(function(){
    // 绑定上传题图
    bindTitleImageClick();
    // 渲染markdown编辑器
    renderMarkdownEditor();
    // 绑定分类按钮
    bindCloseButton();
    // 绑定发布,草稿,预览按钮
    bindPublishClick();
});

/*绑定发布,草稿,预览按钮*/
function bindPublishClick() {
    // 绑定发布
    $('#publish').off().on('click',function () {
        var pre;
        if($('#images').val() != '' && $('#images').val() != undefined){
            pre = '<div align="center">![题图]('+$('#images').val()+')</div>\r\n';
        }
        $('#infoModel').modal('toggle');
        $('#articleContent').val(pre + testEditor.getMarkdown());
        $.ajax({
            url:'/articleInfo/publish',
            method:'post',
            dataType:'json',
            data:$('#form').serialize(),
            success:function (data) {
                if(data.status=='S'){
                    $('#infoTxt').html('发布成功!');
                    location.href=location.href;
                }else{
                    $('#infoTxt').html('发布失败,原因:' + data.msg);
                }
                setTimeout(function () {
                    $('#infoModel').modal('toggle');
                },3000);
            }
        })
    });
    // 绑定草稿

    // 绑定预览
    $('#preScans').off().on('click',function () {
        alert('暂不支持预览');
    });

}
/*绑定分类按钮*/
function bindCloseButton() {
    // 异步查询分类树
    $('#cat').off().on('click',function () {
        // 获取分类树并渲染
        $.ajax({
            url:'/articleCat/getArticleCatFatherTree',
            method:'post',
            dataType:'json',
            success:function (data) {
                // 渲染分类树
                $('#articleCatTree').find('li').remove();
                layui.use('tree', function(){
                    layui.tree({
                        elem: '#articleCatTree',
                        nodes:  data,
                        click:function (node) {
                            $('#articleCat').val(node.name);
                            $('#articleCatId').val(node.id);
                            $('#catSpan').html(node.name);
                            $('#catSpan1').html(node.name);
                        }
                    });
                });
                $('#articleCatTree').show();
            }
        })
    });
    // 绑定分类弹层的返回按钮
    $('#close').off().on('click',function () {
        $('#articleCatModel').modal('toggle');
    })
}
/*渲染markdown编辑器*/
var testEditor;
function renderMarkdownEditor() {
    testEditor = editormd("markdown",{
        height: '900px',
        syncScrolling : "single",
        path:"/static/editormd/lib/",
        //启动本地图片上传功能
        imageUpload:true,
        emoji:true,
        imageFormats   : ["jpg", "jpeg", "gif", "png"],
        imageUploadURL : "/upload/uploadImageMarkdown"
    });
}
/*绑定上传题图*/
function bindTitleImageClick() {
    // 绑定点击事件
    $('#titleImage').off().on('click',function(){
        if($('#images').val() == '' || $('#images').val() == undefined){
            // 上传文件
            $(".tailoring-container").toggle();
        }else{
            // 删除文件
            $('#images').val('');
            $('#titleImgFile').val('');
            $('#titleImage').css('background-image','url("")');
            $('#titleImage').height('');
            $('.titleImageText').html('添加题图');
            $('.titleImageText').css('background-color','white');
        }
    });
    // 绑定鼠标悬浮
    $('#titleImage').on("mouseover mouseout",function(event){
        if(event.type == "mouseover"){
            $('.titleImageIcon').show();
            if($('#images').val() == '' ||   $('#images').val() == undefined){
                $('.titleImageText').html('添加题图');
                $('.titleImageText').css('background-color','white');
            }else{
                $('.titleImageText').html('删除题图');
                $('.titleImageText').css('background-color','white');
            }
            $('.titleImageText').show();
            $('.titleImageSubText').show();
        }else if(event.type == "mouseout"){
            if($('#images').val() != undefined &&  $('#images').val() != '' ){
                $('.titleImageIcon').hide();
                $('.titleImageText').hide();
                $('.titleImageText').css('background-color','white');
                $('.titleImageSubText').hide();
            }
        }
    })
}
/*上传图片回调*/
function afterUploadImg(data) {
    if(data.status == 'S'){
        $('#titleImage').css('background-image','url('+data.msg+')');
        var width = $('#titleImage').width();
        $('#titleImage').height((width/4)*3);
        $('#images').val(data.msg);
        $('.titleImageIcon').hide();
        $('.titleImageText').hide();
        $('.titleImageText').css('background-color','white');
        $('.titleImageSubText').hide();
    }else{
        alert(data.msg);
    }
}