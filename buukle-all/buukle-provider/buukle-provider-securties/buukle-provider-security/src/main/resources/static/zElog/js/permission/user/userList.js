//@ sourceURL=userList.js
$(function () {
    /*绑定页面组件和按钮*/
    bindsearchConditionClick();
});
var tableIns;
function renderTable() {
    layui.use('table', function() {
        var table = layui.table;
        //执行渲染
        tableIns = table.render({
            elem: '#table',
            url: '/user/getUserList',
            page: true,
            where: {
                username:   $('#fuzzy-index-0').val()
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
                {field: 'username', title: '用户名', width:177}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtModified)}}</a></div>'}
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
function reloadTable() {
    setTimeout(function () {
        tableIns.reload();
    },1000);
}
/*详情回显回调*/
function detail(data) {
    for(var key in data){
        if(key == "username"){
            $("#uname").val(data[key]);
            continue;
        }else if(key == "property01"){
            $("#"+key).val(data[key]==0?"女":"男")
            continue;
        }else if(key == "state"){
            $("#"+key).val(data[key]==0?"停用":"启用")
            continue;
        }else if(key=="creatTime" || key=="updateTime"){
            $("#"+key).val(formatDateTime(data[key]));
            continue;
        }
        $("#"+key).val(data[key]);
    }
}
/*修改回显回调*/
function modify(id, data) {

}
/*分配角色回调*/
function setUserRole(data) {
    //渲染用户角色
    renderUserRoles(data);
    releaseThis($('#doSetUserRole'));
    //保存
    $('#doSetUserRole').off().on('click',function () {
        disableThis( $('#doSetUserRole'));
        $('#setUserRoleId').val($('#currentRecordId').val());
        $.ajax({
            url:'/user/doSetUserRole',
            type:'post',
            dataType:'json',
            data:$('#setUserRoleForm').serialize(),
            success:function (data) {
                var code = data.code;
                layui.use("layer",function () {
                    var layer = layui.layer;
                    var cancelB =  $("#cancelSetUserRole");
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
        })
    })
}
/*渲染用户角色*/
function renderUserRoles(data) {
    var html = '';
    for(var i = 0; i<data.length;i++){
        var checkVelue = data[i].isSelected == 1?'checked':'';
     html +='<input class="clearAbleBuukle" style="margin-left: 25px;" '+checkVelue+' value="'+data[i].id+'" name="ids" type="checkbox">'+data[i].roleName;
    }
    $('#roleListContains').html(html);
}
