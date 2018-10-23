//@ sourceURL=ModuleList.js
$(function () {
    /*绑定页面按钮操作组件*/
    bindsearchConditionClick();
    /*绑定添加页面保存按钮事件*/
    // bindAddModulePageClick();
});
var tableIns;
function renderTable() {
    layui.use('table', function() {
        var table = layui.table;
        //执行渲染
        tableIns = table.render({
            elem: '#table',
            url: '/module/getModuleList',
            page: true,
            where: {
                moduleName:   $('#fuzzy-index-0').val()
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
                {field: 'moduleName', title: '菜单/按钮名', width:177}
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
/*重新载入表数据*/
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

/*分配按钮回调*/
function setModuleButton(data) {
    //渲染树
    rederzTree(data);
    releaseThis($('#doSetModuleButton'));
    //保存
    $('#doSetModuleButton').off().on('click',function () {
        disableThis($('#doSetModuleButton'));
        var id = $("#currentRecordId").val();
        var nodes = zTreeObj.getCheckedNodes(true);
        var ids = '';
        for(var i=0;i<nodes.length;i++){
            ids = ids + nodes[i].id + ',';
        }
        $.ajax({
            url:"/module/setModuleButton",
            dataType:"json",
            type:"post",
            data:{'ids':ids,'id':id},
            success:function (data) {
                var code = data.code;
                layui.use("layer",function () {
                    var layer = layui.layer;
                    var cancelB =  $("#cancelSetModuleButton");
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
/*渲染zTree*/
var zTreeObj ;
function rederzTree(data) {
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        check: {
            chkboxType: { "Y" : "ps", "N" : "ps" },
            enable: true
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        }
    };
    var zNodes = data;
    var t = $("#tree");
    zTreeObj = $.fn.zTree.init(t, setting, zNodes);
}
