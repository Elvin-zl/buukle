//@ sourceURL=ArticleCatList.js
$(function () {
    /*显示文章分类树*/
    showTheCatTree();
    /*渲染本页按钮*/
    renderBtns();
});

/*显示文章分类树*/
function showTheCatTree() {
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
                        getTreeNodeInfo(node);
                    }
                });
            });
        }
    });
}
/*点击分类获取信息并填充右侧列表*/
function getTreeNodeInfo(node) {
    $('#detail').show();
    $.ajax({
        url:'/articleCat/getCategoryInfo/'+node.id,
        dataType:'json',
        type:'post',
        success:function (data) {
            $('#articleCat').html(data.articleCat);
            $('#creator').html(data.creator);
            $('#gmtCreated').html(formatDateTime(data.gmtCreated));
            $('#updateBy').html(data.updateBy);
            $('#updateTime').html(formatDateTime(data.updateTime));
            $('#desc').html(data.description);
            $('#nodeName').html(data.articleCat);
            $('.buukle-pannel-btn').attr('data-id',data.id);
        }
    })
}
/*add按钮回调*/
function add(data){
    $('#fatherCat').attr('disabled','disabled');
    $('#fatherCatTreeContain').html('');
    layui.use('tree', function(){
        layui.tree({
            elem: '#fatherCatTreeContain' //传入元素选择器
            ,nodes:  data,
            click:function (node) {
                var item = $('#fatherCat');
                item.val(node.name);
                $('#pid').val(node.id);
                removeRedBorderClass(item);
                $('#alert').hide();
            }
        });
    });
    $('#fatherCategoryTree').show();
    bindParamValidateAndSaveCategory();
}

/*修改按钮回调*/
function edit(data){


}
/*保存分类*/
var isRightParam = false;
function bindParamValidateAndSaveCategory() {
    //参数输入即时校验
    validateInputParam();
    //保存
    save();

}
/*参数输入即时校验*/
function validateInputParam() {
    $('.buukle-validate').on('keyup change',function () {
        //聚焦消失红框
        removeRedBorderClass($(this));
        $(this).val(Trim($(this).val()));
    });
    //分类名称格式校验
    var reg = /^([\w]|[\u4e00-\u9fa5]){0,30}$/;
    addArticleCatFlag = false;
    $('#addArticleCat').on('blur',function () {
        if(!$(this).val().match(reg)){
            addRedBorderClass($(this));
            alertMsg("分类名称格式不正确!");
        }else if($(this).val() == ''){
            addRedBorderClass($(this));
            alertMsg("分类名称格式不能为空");
        }
        else{
            addArticleCatFlag = true;
            removeRedBorderClass($(this));
        }
    })
}
/*保存文章分类*/
function save() {
    $('#addCategory').off().on('click',function () {
        disableThis($('#addCategory'));
        if(validateRequiredParam()){
            $.ajax({
                url : '/articleCat/saveArticleCat',
                type : 'post',
                dataType : 'json',
                data: $('#addCategoryForm').serialize(),
                success : function (data) {
                    releaseThis($('#addCategory'));
                    var code = data.code;
                    layui.use("layer",function () {
                        var layer = layui.layer;
                        var cancelB =  $("#cancelAddCategory");
                        if(code == "F"){
                            layer.msg(data.msg, {icon: 2});
                            cancelB.click();
                            return;
                        }
                        layer.msg(data.msg, {icon: 1});
                        cancelB.click();
                        //刷新页面
                        window.location.href=window.location.href;
                    })
                }
            })
        }
    });
}

/*校验必输项*/
function validateRequiredParam() {
    //分类名称校验
    if($('#addArticleCat').val() ==''){
        var item = $('#addArticleCat');
        addRedBorderClass(item);
        item.focus();
        alertMsg("请输入分类名称!");
        return false;
    }else if(!addArticleCatFlag){
        var item = $('#addArticleCat');
        addRedBorderClass(item);
        item.focus();
        alertMsg("分类名称格式不正确");
        return false;
    }
    //父级分类校验
    if($('#fatherCat').val() ==''){
        var item = $('#fatherCat');
        addRedBorderClass(item);
        item.focus();
        alertMsg("请点选父级分类!");
        return false;
    }
    //状态值校验
    if($('#addStatus').val() ==''){
        var item = $('#addStatus');
        addRedBorderClass(item);
        item.focus();
        alertMsg("请选择分类状态!");
        return false;
    }
    return true;
}
