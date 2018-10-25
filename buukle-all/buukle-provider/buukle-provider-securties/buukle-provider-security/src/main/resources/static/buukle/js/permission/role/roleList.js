//@ sourceURL=roleList.js
$(function () {
    /*绑定页面按钮操作组件*/
    bindsearchConditionClick();
});
var tableIns;
function renderTable() {
    layui.use('table', function() {
        var table = layui.table;
        //执行渲染
        tableIns = table.render({
            elem: '#table',
            url: '/role/getRoleList',
            page: true,
            where: {
                roleName:   $('#fuzzy-index-0').val()
                ,startTime: ($('#startTime').val()==""?"":$('#startTime').val()+" 00:00:00")
                ,endTime:   ($('#endTime').val()==""?"":$('#endTime').val()+" 23:59:59")
                ,status: $('#status').val()
            },
            method: 'post',
            first:  '首页',
            last:   '尾页',
            request: {
                pageName: 'page',
                limitName: 'limit'
            }
            ,cols: [[
                {field: 'roleName', title: '角色名', width:177}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.modifiedTime)}}</a></div>'}
                ,{title: '状态', width: 80,templet: '<div>{{formatStatus(d.status)}} </div>'}
                ,{title: '操作',fixed: 'right', width:290, align:'center',templet: '<div>{{formatUserHandle(d.status,d.id)}} </div>'}
            ]]
            ,limits: [10, 20, 30,50,100]
            ,limit: 10
            ,done: function (res, pageNo, count) {
                //绑定按钮点击事件
                bindTableBtnsClick();
            }
        });
    });
}
/*重新载入表格*/
function reloadTable() {
    setTimeout(function () {
        tableIns.reload();
    },1000);
}
/*添加*/
$('#addRole').off().on('click',function () {
    $.ajax({
        url:"/role/addRole",
        dataType:"json",
        type:"post",
        data: $('#addRoleForm').serialize(),
        success:function (data) {
            var code = data.code;
            layui.use("layer",function () {
                var layer = layui.layer;
                var cancelB =  $("#cancelAddRole");
                if(code == "F"){
                    layer.msg(data.msg, {icon: 2});
                    cancelB.click();
                    return;
                }
                layer.msg(data.msg, {icon: 1});
                cancelB.click();
                reloadTable();
            })
        }
    });
});
/*详情回显回调*/
function detail(data) {
    for(var key in data){
        if(key == "status"){
            $('#roleStatus').val(data[key]==0?"停用":"启用")
            continue;
        }else if(key=="gmtCreated" || key=="modifiedTime"){
            $("#"+key).val(formatDateTime(data[key]));
            continue;
        }
        $("#"+key).val(data[key]);
    }
}
/*修改回显回调*/
function modify(id, data) {

}
/*初始化分配菜单树对象*/
var setModuleZTreeObj;
/*分配菜单回调*/
function setRoleModule(data) {
    //渲染树
    setModuleZTreeObj = renderSimpleCheckboxZTree(setModuleZTreeObj,data,'tree');
    releaseThis($('#doSetRoleModule'));
    //保存
    $('#doSetRoleModule').off().on('click',function () {
        disableThis($('#doSetRoleModule'));
        var id = $("#currentRecordId").val();
        $.ajax({
            url:"/role/setRoleModule",
            dataType:"json",
            type:"post",
            data:{'ids':getZTreeSelected(setModuleZTreeObj),'id':id},
            success:function (data) {
                var code = data.code;
                layui.use("layer",function () {
                    var layer = layui.layer;
                    var cancelB =  $("#cancelSetRoleModule");
                    if(code == "F"){
                        layer.msg(data.msg, {icon: 2});
                        cancelB.click();
                        return;
                    }
                    layer.msg(data.msg, {icon: 1});
                    cancelB.click();
                    reloadTable();
                })
            }
        });
    })
}