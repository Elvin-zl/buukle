//@ sourceURL=buttonList.js
$(function () {
    /*绑定页面按钮操作组件*/
    bindSearchConditionClick();
    /*绑定CRUD页面保存按钮事件*/
    bindCRUDClick();
});
var tableIns;
function renderTable() {
    layui.use('table', function() {
        var table = layui.table;
        //执行渲染
        tableIns = table.render({
            elem: '#table',
            url: '/button/getButtonList',
            page: true,
            where: {
                buttonName:   $('#fuzzy-index-0').val()
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
                 {title: '按钮名',width:177, field: 'buttonName'}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtModified)}}</a></div>'}
                ,{title: '备注', width:177,field: 'bak01'}
                ,{title: '状态', width: 80,templet: '<div>{{formatStatus(d.status)}} </div>'}
                ,{title: '操作',fixed: 'right', width:290, align:'center',templet: '<div>{{formatUserHandle(d.status,d.id,d.bak02)}} </div>'}
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
/*绑定添加页面点击事件*/
function bindCRUDClick() {
    //保存
    $('#addButton').off().on('click',function () {
        disableThis($('#addButton'));
        $.ajax({
            url:'/button/addButton',
            dataType:'json',
            type:'post',
            data:$('#addButtonForm').serialize(),
            success:function (data) {
                releaseThis($('#addButton'));
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
                    $('#closeAddButton').click();
                    reloadTable ();
                }
            }
        });
    });
    //绑定修改保存事件
    $('#editButton').off().on('click',function () {
        disableThis($('#editButton'));
        $.ajax({
            url:'/button/editButton/'+$('#currentRecordId').val(),
            dataType:'json',
            type:'post',
            data:$('#editButtonForm').serialize(),
            success:function (data) {
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
                    $('#closeEditButton').click();
                    reloadTable ();
                }
            }
        });
    });

}
/*详情回显回调*/
function detail(data) {
    for(var key in data){
        if(key == "status"){
            $("#"+key).val(formatInputStatus(data[key]))
            continue;
        }else if(key=="layoutLevel"){
                $("#"+key).val(formatInputLayoutLevel(data[key]));
            continue;
        }else if(key=="operationType"){
                $("#"+key).val(formatInputOperationType(data[key]));
            continue;
        }else if(key=="responseType"){
                $("#"+key).val(formatInputResponseType(data[key]));
            continue;
        }else if(key=="gmtCreated" || key=="gmtModified"){
            $("#"+key).val(formatDateTime(data[key]));
            continue;
        }
        $("#"+key).val(data[key]);
    }
}
/*修改回显回调*/
function edit(data) {
    releaseThis($('#editButton'));
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
        }else if(key=="layoutLevel"){
            selectValue(key,data[key]);
            continue;
        }else if(key=="operationType"){
            selectValue(key,data[key]);
            continue;
        }else if(key=="responseType"){
            selectValue(key,data[key]);
            continue;
        }else if(key=="gmtCreated" || key=="gmtModified"){
            continue;
        }
        $("#"+key+"Edit").val(data[key]);
    }
}
