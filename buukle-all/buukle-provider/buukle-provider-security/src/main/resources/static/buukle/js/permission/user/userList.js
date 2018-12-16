//@ sourceURL=userList.js
$(function () {
    /*绑定页面组件和按钮*/
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
            url: '/user/getUserList',
            page: true,
            where: {
                username:   $('#fuzzy-index-0').val()
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
                {field: 'username', title: '用户名', width:177}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtModified)}}</a></div>'}
                ,{title: '状态', width: 80,templet: '<div>{{formatStatus(d.status)}} </div>'}
                ,{title: '操作',fixed: 'right', width:290, align:'center',templet: '<div>{{formatUserHandle(d.status,d.userId,d.bak02,d.username)}} </div>'}
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
/*绑定页面CRUD点击事件*/
function bindCRUDClick() {
    /*添加*/
    $('#addUser').off().on('click',function () {
        disableThis($('#addUser'));
        $.ajax({
            url:"/user/addUser",
            dataType:"json",
            type:"post",
            data: $('#addUserForm').serialize(),
            success:function (data) {
                releaseThis($('#addUser'));
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
                        $("#cancelAddUser").click();
                        reloadTable ();
                    }
                })
            }
        });
    });
    /*编辑*/
    $('#editUser').off().on('click',function () {
        disableThis($('#editUser'));
        $.ajax({
            url:"/user/editUser/"+$('#currentRecordId').val(),
            dataType:"json",
            type:"post",
            data: $('#editUserForm').serialize(),
            success:function (data) {
                releaseThis($('#editUser'));
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
                        $("#cancelEditUser").click();
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
        if(key == "username"){
            $("#"+key).html(data[key]);
            continue;
        }else if(key == "gender"){
            $("#"+key).html(data[key]==0?"女":"男");
            continue;
        }else if(key == "status"){
            $("#"+key).html(data[key]==0?"停用":"启用");
            continue;
        }else if(key == "userId"){
            $("#"+key).html(data[key]);
            continue;
        }else if(key=="gmtCreated" || key=="gmtModified"){
            $("#"+key).html(formatDateTime(data[key]));
            continue;
        }
        $("#"+key).html(data[key]);
    }
}
/*修改回显回调*/
function edit(data) {
    releaseThis($('#editUser'));
    var statusHtml = '<select id="statusEdit" class="buukle-frame-input btn-layer-type-selector selector add-input" name="status">'+
        '<option class="select-item" value="" data-status="">------------请选择-------------</option>'+
        '<option class="select-item" value="1" data-status="1">-------------启用---------------</option>'+
        '<option class="select-item" value="0" data-status="0">-------------停用---------------</option>'+
        '</select>';
    var deleteLevel ;
    for(var key in data){
        if(key == "bak02"){
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
        }else if(key=="gender"){
            selectValue(key,data[key],Math.random());
            continue;
        }else if(key=="gmtCreated" || key=="gmtModified"){
            continue;
        }
        $("#"+key+"Edit").val(data[key]);
    }
}
/*分配角色回调*/
function setUserRole(data) {
    $('#nameForSetUserRole').html($('#currentRecordName').val());
    //初始化用户所选角色最低等级为100
    var roleLevel = 100;
    //渲染用户角色,并返回用户所选角色最高等级
    roleLevel = renderUserRoles(data,roleLevel);
    //维护所属关系
    syncDisplayBelongingSelect(roleLevel);
    //释放保存按钮
    releaseThis($('#doSetUserRole'));
    //绑定角色点击事件,动态调整用户所属关系的展示
    $('.selectRole').off().on('click',function () {
        //重置用户所选角色最低等级为100
        roleLevel = 100;
        //筛选用户所选角色最高等级
        $.each($('input:checkbox'),function(){
            if(this.checked){
               var thisLevel = $(this).attr('data-roleLevel');
               if(thisLevel  < roleLevel){
                   roleLevel = thisLevel;
               }
            }
        });
        //维护所属关系
        syncDisplayBelongingSelect(roleLevel);
    });
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
                layui.use("layer",function () {
                    var layer = layui.layer;
                    var cancelB =  $("#cancelSetUserRole");
                    if(data.status == "F"){
                        layer.msg(data.msg, {icon: 2});
                        releaseThis($('#doSetUserRole'));
                        return;
                    }
                    layer.msg(data.msg, {icon: 1});
                    cancelB.click();
                    reloadTable();
                })
            }
        })
    })
    /** 动态展示所属选项框*/
    function syncDisplayBelongingSelect(roleLevel) {
        //清空之前内容
        $('#select-index-idStr-1').val('');
        $('#select-index-idStr-2').val('');
        $('#select-index-idStr-3').val('');
        $('#select-index-idStr-4').val('');
        //清空之前隐藏域
        $('#select-index-1').val('');
        $('#select-index-2').val('');
        $('#select-index-3').val('');
        $('#select-index-4').val('');
        //boss 或 平台
        $('#roleLevel').val(roleLevel);
        if(roleLevel == 0 ||  roleLevel == 1){
            $('#roleFirst').html('直属boss管辖');
            $('#roleFirst').css('display','block');
            $('.platform-belonging').hide();
            $('.agent-belonging').hide();
            $('.group-belonging').hide();
            $('.salesman-belonging').hide();
            return;
        }
        //代理
        if(roleLevel == 2){
            $('#roleFirst').css('display','none');
            $('#roleFirst').html('');
            $('.platform-belonging').show();
            $('.agent-belonging').hide();
            $('.group-belonging').hide();
            $('.salesman-belonging').hide();
            return;
        }
        //区域
        if(roleLevel == 3){
            $('#roleFirst').css('display','none');
            $('#roleFirst').html('');
            $('.platform-belonging').show();
            $('.agent-belonging').show();
            $('.group-belonging').hide();
            $('.salesman-belonging').hide();
            return;
        }
        //业务员
        if(roleLevel == 4){
            $('#roleFirst').css('display','none');
            $('#roleFirst').html('');
            $('.platform-belonging').show();
            $('.agent-belonging').show();
            $('.group-belonging').show();
            $('.salesman-belonging').hide();
            return;
        }
        //业务员
        if(roleLevel == 5){
            $('#roleFirst').css('display','none');
            $('.platform-belonging').show();
            $('.agent-belonging').show();
            $('.group-belonging').show();
            $('.salesman-belonging').show();
            return;
        }
        //没有选择角色
        if(roleLevel == 100){
            $('#roleFirst').html('请选择角色!');
            $('#roleFirst').css('display','block');
            $('.platform-belonging').hide();
            $('#select-index-idStr-1').val('');
            $('.agent-belonging').hide();
            $('#select-index-idStr-2').val('');
            $('.group-belonging').hide();
            $('#select-index-idStr-3').val('');
            $('.salesman-belonging').hide();
            $('#select-index-idStr-4').val('');
            return;
        }
    }
}
/* 渲染用户角色*/
function renderUserRoles(data,roleLevel) {
    var html = '';
    for(var i = 0; i<data.length;i++){
        var checkVelue = data[i].isSelected == 1?'checked':'';
        if(data[i].isSelected && data[i].roleLevel  < roleLevel){
            roleLevel = data[i].roleLevel;
        }
        html +='<input class="clearAbleBuukle selectRole" data-roleLevel="'+data[i].roleLevel+'" style="margin-left: 25px;" '+checkVelue+' value="'+data[i].id+'" name="ids" type="checkbox">'+data[i].roleName;
    }
    $('#roleListContains').html(html);
    return roleLevel;
}
