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
        url:'/category/getArticleCatTree',
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
        url:'/category/getCategoryInfo/'+node.id,
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
            $('.buukle-table-btn').attr('data-id',data.id);
        }
    })
}
/*add按钮回调*/
var tempFaterCategory='';
function add(data){
    tempFaterCategory = data;
    bindShowFatherModuleTree();
}

/*父级分类树回显*/
function bindShowFatherModuleTree(){
    $('#fatherCat').on('click',function () {
        $('#fatherCat').attr('disabled','disabled');
        $('#fatherCatTreeContain').html('');
        layui.use('tree', function(){
            layui.tree({
                elem: '#fatherCatTreeContain' //传入元素选择器
                ,nodes:  tempFaterCategory,
                click:function (node) {
                    var item = $('#fatherCat');
                    item.val(node.name);
                    $('#pid').val(node.id);
                    removeRedBorderClass(item);
                }
            });
        });
        layui.use("layer",function () {
            var layer = layui.layer;
            layer.open({
                closeBtn: 0,
                title:"选择父级菜单",
                type:1,
                content: $('#fatherCategoryTree'),
                area: ['500px', '320px']
            });
        });
    });
    /*防止二次点击*/
    $('#yes').off().on('click',function () {
        $('#fatherCat').attr('disabled',false);
    })
    //参数校验
    bindParamValidateAndSaveCategory();
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
        if(validateRequiredParam()){
            $.ajax({
                url : '/category/addCat',
                type : 'post',
                dataType : 'json',
                data: $('#addCategoryForm').serialize(),
                success : function (data) {
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
                        $('.layui-reload',window.parent.document).click();
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
