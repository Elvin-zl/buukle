$(function () {
    // 分页
    doPage();
})

/** 分页*/
function doPage() {
    layui.use(['laypage','layer'], function() {
        var laypage = layui.laypage;
        laypage({
            cont: 'pageBar'
            ,pages: $('#totalPage').val()
            ,curr: $('#page').val()
            ,skin: '#1E9FFF'
            ,layout : ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,limits : '[10, 20, 30, 40, 50]'
            ,jump: function(obj, first){
                if(!first){
                    loadPage(obj.curr);
                }
            }
        });
    })
}
/** 加载页面*/
function loadPage(page) {
    // 显示遮罩
    showdiv();
    var multiSelects = $('.multiSelect');
    var params = "";
    $.each(multiSelects, function (i, obj) {
        $(obj).select2({placeholder:$(obj).attr('data-multiHolder')});
        params+= "&" +$(obj).attr('data-multiField') + "=" + $(obj).val();
    })
    $('#table-list').load($('#table-list').attr('data-url'),$('#searchForm').serialize() + "&page=" +  page + params,function (responseTxt,statusTxt,xhr) {
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
         iframeObj = $(window.frameElement).attr('name');
        // 全选
        bindChooseAll(form);
        // 删
        bindDel(dialog);
        // 改
        bindEdit(iframeObj);
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
/** 删除*/
function bindDel(dialog) {
    $('.delOneBtn').off().on('click', function() {
        var url=$(this).attr('data-url');
        var userId=$(this).attr('data-userId');
        url = url + "?id=" + $(this).attr('data-id') + ((userId =="" || userId==undefined) ? "" : "&userId=" + userId);
        dialog.confirm({
            message:'您确定删除本条记录吗？',
            success:function(){
                banThis($(this),'删除中..');
                var thisObj =  $(this);
                $.ajax({
                    url : url,
                    method : 'post',
                    dataType : 'json',
                    success : function (data) {
                        if(data.head.status=='S'){
                            layer.msg('删除成功!');
                            $('#refresh').click();
                        }else{
                            layer.msg(data.head.msg);
                        }
                        releaseThis(thisObj,'删除');
                    }
                })
            },
            cancel:function(){
                layer.msg('您取消了删除本条记录操作')
            }
        });
        return false;
    }).mouseenter(function() {
        dialog.tips('删除本条', '.delOneBtn');
    });
}
/** 修改*/
function bindEdit(iframeObj) {
    $('.editBtn').off().on('click', function() {
        var url=$(this).attr('data-url');
        var userId=$(this).attr('data-userId');
        url = url + "?id=" + $(this).attr('data-id') + ((userId =="" || userId==undefined) ? "" : "&userId=" + userId);
        parent.page("编辑", url, iframeObj, w = "700px", h = "620px");
        return false;
    }).mouseenter(function() {
        dialog.tips('编辑', '.editBtn');
    })
}

/** 跳转*/
function bindGo() {
    $('.goBtn').off().on('click', function() {
        var url=$(this).attr('data-url');
        var id = $(this).attr('data-id');
        window.location.href=url+"?id="+id;
        return false;
    })
}