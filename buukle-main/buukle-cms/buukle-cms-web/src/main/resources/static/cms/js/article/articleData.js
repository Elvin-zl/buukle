layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',   'element'], function() {
    var laypage = layui.laypage,
        form = layui.form, layer = layui.layer,
        $ = layui.jquery, dialog = layui.dialog;
    //分页
    laypage({
        cont: 'pageBar'
        ,pages: $('#totalPage').val()
        ,curr: $('#page').val()
        ,skin: '#1E9FFF'
        ,layout : 'count'
        ,limits : '[10, 20, 30, 40, 50]'
        ,jump: function(obj, first){
            if(!first){$('#table-list').load("/articleInfo/getPageList?page=" + obj.curr); }
        }
    });
    //全选
    form.on('checkbox(allChoose)', function(data) {
        var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
        child.each(function(index, item) {
            item.checked = data.elem.checked;
        });
        form.render('checkbox');
    });
    //渲染表单
    form.render();
    //获取当前iframe的name值
    var iframeObj = $(window.frameElement).attr('name');
    //列表添加
    var tableList = $('#table-list');
    tableList.on('click', '.add-btn', function() {
        var url=$(this).attr('data-url');
        //将iframeObj传递给父级窗口
        parent.page("菜单添加", url, iframeObj, w = "700px", h = "620px");
        return false;
    });
    //列表删除
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
    //列表跳转
    $('#table-list,.tool-btn').on('click', '.go-btn', function() {
        var url=$(this).attr('data-url');
        var id = $(this).attr('data-id');
        window.location.href=url+"?id="+id;
        return false;
    })
    //编辑栏目
    tableList.on('click', '.edit-btn', function() {
        var That = $(this);
        var id = That.attr('data-id');
        var url=That.attr('data-url');
        //将iframeObj传递给父级窗口
        parent.page("菜单编辑", url + "?id=" + id, iframeObj, w = "700px", h = "620px");
        return false;
    })
});