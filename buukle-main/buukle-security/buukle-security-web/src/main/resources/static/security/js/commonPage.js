$(function () {
    // 分页
    doPage($('#pageSign').val());
})
/** 分页*/
function doPage(pageSign) {
    layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',   'element'], function() {
        var laypage = layui.laypage;
        laypage({
            cont: 'pageBar'
            ,pages: $('#totalPage').val()
            ,curr: $('#page').val()
            ,skin: '#1E9FFF'
            ,layout : 'count'
            ,limits : '[10, 20, 30, 40, 50]'
            ,jump: function(obj, first){
                if(!first){
                    loadPage(pageSign,obj.curr);
                }
            }
        });
    })
}
/** 加载页面*/
function loadPage(pageSign,page) {
    // 显示遮罩
    showdiv();
    var multiSelects = $('.multiSelect');
    var params = "";
    $.each(multiSelects, function (i, obj) {
        $(obj).select2({placeholder:$(obj).attr('data-multiHolder')});
        params+= "&" +$(obj).attr('data-multiField') + "=" + $(obj).val();
    })
    $('#table-list').load("/"+ pageSign +"/getPageList",$('#searchForm').serialize() + "&page=" +  page + params,function (responseTxt,statusTxt,xhr) {
        if(statusTxt=="success"){
            // 初始化页面脚本
            initCommonPage();
            // 隐藏遮罩
            hidediv();
        }else{
            $('#table-list').html('<span>出现异常 ! Error: '+ xhr.status +' </span>');
            $('#pageBar').hide();
            hidediv();
        }
    });
}
/** 初始化*/
function initCommonPage() {
    layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',   'element'], function() {
        var form = layui.form(),  $ = layui.jquery, dialog = layui.dialog;
        var iframeObj = $(window.frameElement).attr('name');
        var tableList = $('#table-list');
        // 全选
        bindChooseAll(form);
        // 增
        bindAdd(tableList,iframeObj);
        // 删
        bindDel(tableList,dialog);
        // 改
        bindEdit(tableList,iframeObj);
        // 跳
        bindGo();
    });
}
/** 绑定全选*/
function bindChooseAll(form) {
    form.on('checkbox(allChoose)', function(data) {
        var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
        child.each(function(index, item) {
            item.checked = data.elem.checked;
        });
        form.render('checkbox');
    });
    // 渲染表单
    form.render();
}
/** 显示遮罩*/
function showdiv() {
    document.getElementById("shadow").style.display ="block";
}
/** 隐藏遮罩*/
function hidediv() {
    document.getElementById("shadow").style.display ='none';
}
/** 添加*/
function bindAdd(tableList,iframeObj) {
    tableList.on('click', '.add-btn', function() {
        var url=$(this).attr('data-url');
        //将iframeObj传递给父级窗口
        parent.page("菜单添加", url, iframeObj, w = "700px", h = "620px");
        return false;
    });
}
/** 删除*/
function bindDel(tableList,dialog) {
    tableList.on('click', '.del-btn', function() {
        var url=$(this).attr('data-url');
        var id = $(this).attr('data-id');
        dialog.confirm({
            message:'您确定要进行删除吗？',
            success:function(){
                layer.msg('确定了')
            },
            cancel:function(){
                layer.msg('取消了')
            }
        });
        return false;
    });
}
/** 修改*/
function bindEdit(tableList, iframeObj) {
    tableList.on('click', '.edit-btn', function() {
        var That = $(this);
        var id = That.attr('data-id');
        var url=That.attr('data-url');
        //将iframeObj传递给父级窗口
        parent.page("菜单编辑", url + "?id=" + id, iframeObj, w = "700px", h = "620px");
        return false;
    })
}
/** 跳转*/
function bindGo() {
    $('#table-list,.tool-btn').on('click', '.go-btn', function() {
        var url=$(this).attr('data-url');
        var id = $(this).attr('data-id');
        window.location.href=url+"?id="+id;
        return false;
    })
}