//@ sourceURL=roleList.js
$(function () {
    /*绑定页面按钮操作组件*/
    bindSearchConditionClick();
    /*绑定添加页面保存按钮事件*/
    bindCRUDClick();
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
                ,status: $('#searchStatus').val()
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
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtModified)}}</a></div>'}
                ,{title: '状态', width: 80,templet: '<div>{{formatStatus(d.status)}} </div>'}
                ,{title: '操作',fixed: 'right', width:290, align:'center',templet: '<div>{{formatUserHandle(d.status,d.id,d.bak01,"")}} </div>'}
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

/*绑定页面CRUD事件*/
function bindCRUDClick() {
    /*添加*/
    $('#addRole').off().on('click',function () {
        disableThis($('#addRole'));
        $.ajax({
            url:"/role/addRole",
            dataType:"json",
            type:"post",
            data: $('#addRoleForm').serialize(),
            success:function (data) {
                releaseThis($('#addRole'));
                layui.use("layer",function () {
                    var layer = layui.layer;
                    if(data.status  == 'F'){
                        layer.msg(data.msg, {
                            icon: 2,
                            time: 3000
                        });
                    }
                    if(data.status  == 'S'){
                        layer.msg(data.msg, {
                            icon: 1,
                            time: 3000
                        });
                        //清空添加表单
                        $('.add-input').val('');
                        $("#cancelAddRole").click();
                        reloadTable ();
                    }
                })
            }
        });
    });
    /*编辑*/
    $('#editRole').off().on('click',function () {
        disableThis($('#editRole'));
        $.ajax({
            url:"/role/editRole/"+$('#currentRecordId').val(),
            dataType:"json",
            type:"post",
            data: $('#editRoleForm').serialize(),
            success:function (data) {
                releaseThis($('#editRole'));
                layui.use("layer",function () {
                    var layer = layui.layer;
                    if(data.status  == 'F'){
                        layer.msg(data.msg, {
                            icon: 2,
                            time: 3000
                        });
                    }
                    if(data.status  == 'S'){
                        layer.msg(data.msg, {
                            icon: 1,
                            time: 3000
                        });
                        //清空添加表单
                        $('.add-input').val('');
                        $("#cancelEditRole").click();
                        reloadTable ();
                    }
                })
            }
        });
    });
}
/*详情回显回调*/
function detail(data) {
    for(var key in data){
        if(key == "status"){
            $("#"+key).val(data[key]==0 ? "停用" : "启用");
            continue;
        }else if(key=="gmtCreated" || key=="gmtModified"){
            $("#"+key).val(formatDateTime(data[key]));
            continue;
        }else if(key=="roleLevel"){
           var level= data[key];
            if(level ==0){
                $("#"+key).val('boss管理员');
                continue;
            }
            if(level ==1){
                $("#"+key).val('平台管理员');
                continue;
            }
            if(level ==2){
                $("#"+key).val('代理管理员');
                continue;
            }
            if(level ==3){
                $("#"+key).val('区域管理员');
                continue;
            }
            if(level ==4){
                $("#"+key).val('业务员');
                continue;
            }
            if(level ==5){
                $("#"+key).val('普通用户');
                continue;
            }
        }
        $("#"+key).val(data[key]);
    }
}
/*编辑回显回调*/
function edit(data) {
    releaseThis($('#editButton'));
    var statusHtml = '<select id="statusEdit" class="buukle-frame-input btn-layer-type-selector selector add-input" name="status">'+
        '<option class="select-item" value="" data-status="">------------请选择-------------</option>'+
        '<option class="select-item" value="1" data-status="1">-------------启用---------------</option>'+
        '<option class="select-item" value="0" data-status="0">-------------停用---------------</option>'+
        '</select>';
    var deleteLevel ;
    for(var key in data){
        if(key == "bak01"){
            deleteLevel = data[key];
            break;
        }
    }
    for(var key in data){
        if(key == "status"){
            $("#"+key+"Edit").remove();
            $("#noDelete").remove();
            if(deleteLevel == 0){
                $("#statusFather").append("<span id='noDelete'>系统创建,不允许修改!</span>")
            }else{
                $('#statusFather').append(statusHtml);
                selectValue(key,data[key],Math.random());
            }
            continue;
        }else if(key=="gmtCreated" || key=="gmtModified"){
            continue;
        }
        $("#"+key+"Edit").val(data[key]);
    }
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