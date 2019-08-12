layui.config({
    base: '/static/security/js/module/'
}).extend({
    dialog: 'dialog',
});
layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',   'element'], function() {
    layer = layui.layer, $ = layui.jquery,  dialog = layui.dialog; var iframeObj = $(window.frameElement).attr('name');
    // 绑定添加
    bindAdd(iframeObj);
    // 绑定批删
    bindDelBitch();
    // 绑定查询
    bindSearch();

});

/** 绑定查询*/
function bindSearch() {
    $('#search').off('click').on('click',function () {
        loadPage(1);
    })
}

/** 绑定添加*/
function bindAdd(iframeObj) {
    $('.addBtn').off('click').click(function() {
        var url=$(this).attr('data-url');
        parent.page("添加", url, iframeObj, w = "700px", h = "620px");
        return false;
    }).mouseenter(function() {
        dialog.tips('添加', '.addBtn');
    })
}

/** 绑定批删*/
function bindDelBitch() {
    $('.delBtn').off('click').click(function() {
        var url=$(this).attr('data-url');
        dialog.confirm({
            message:'您确定要删除选中项?',
            success:function(){
                banThis($(this),'删除中..');
                var thisObj =  $(this);
                var ids= [];
                $("input[name='batchCheckBox']:checked").each(function(i){
                    ids.push($(this).attr('data-id'));

                });
                $.ajax({
                    url : url,
                    method : 'post',
                    dataType : 'json',
                    data:{"ids": ids.toString()},
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
                layer.msg('您取消了删除选中项操作')
            }
        })
        return false;

    }).mouseenter(function() {
        dialog.tips('批量删除', '.delBtn');
    })
}

/** 控制iframe窗口的刷新操作 */
var iframeObjName;
function page(title, url, obj, w, h) {
    if(title == null || title == '') {
        title = false;
    };
    if(url == null || url == '') {
        url = "404.html";
    };
    if(w == null || w == '') {
        w = '700px';
    };
    if(h == null || h == '') {
        h = '350px';
    };
    iframeObjName = obj;
    //如果手机端，全屏显示
    if(window.innerWidth <= 768) {
        var index = layer.open({
            type: 2,
            title: title,
            area: [320, h],
            fixed: false, //不固定
            content: url
        });
        layer.full(index);
    } else {
        var index = layer.open({
            type: 2,
            title: title,
            area: [w, h],
            fixed: false, //不固定
            content: url
        });
    }
}

/** 刷新子页,关闭弹窗 */
function refresh() {
    //根据传递的name值，获取子iframe窗口，执行刷新
    if(window.frames[iframeObjName]) {
        window.frames[iframeObjName].location.reload();
    } else {
        window.location.reload();
    }
    layer.closeAll();
}
function banThis(obj,msg){
    obj.html(msg);
    obj.attr("disabled",true);
}
function releaseThis(obj,msg){
    $('.clearAble').val('');
    obj.html(msg);
    obj.attr("disabled",false);
}
function renderSelectedTree(tree,data,elem,idTarget){
    $(elem).empty();
    tree.render({
        elem: elem
        ,data: data.body.list
        ,click: function(obj){
            $("input:hidden[name="+idTarget+"]").val(obj.data.id);
            $("input:hidden[name="+idTarget+"]").prev().html(obj.data.title);
        }

    });
    $(elem).parent().parent().parent().off().on("click", ".layui-select-title", function (e) {
        $(".layui-form-select").not($(this).parents(".layui-form-select")).removeClass("layui-form-selected");
        $(this).parents(".downpanel").toggleClass("layui-form-selected");
        var subId = $(elem).attr('data-subTree');
        $('#' + subId).empty();
        $('#' + subId + 'Input').val('');
        $('#' + subId + 'Span').html('请选择');
        layui.stope(e);
    }).on("click", "dl i", function (e) {
        layui.stope(e);
    });
    $(document).off().on("click", function (e) {
        $(".layui-form-select").removeClass("layui-form-selected");
    });
}