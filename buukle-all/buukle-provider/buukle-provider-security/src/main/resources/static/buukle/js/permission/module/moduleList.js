//@ sourceURL=ModuleList.js
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
            url: '/module/getModuleList',
            page: true,
            where: {
                moduleName:   $('#fuzzy-index-0').val()
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
                {title: '菜单名称',  field: 'moduleName', width:177}
                ,{title: 'url',  field: 'url', width:300}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtModified)}}</a></div>'}
                ,{title: '备注',field: 'description',  width:177}
                ,{title: '状态', width: 80,templet: '<div>{{formatStatus(d.status)}} </div>'}
                ,{title: '操作',fixed: 'right', width:290, align:'center',templet: '<div>{{formatUserHandle(d.status,d.id,d.bak02,"")}} </div>'}
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

/*初始化父级菜单zTree对象*/
var fatherModuleZTreeObj;
function bindCRUDClick() {
    /*绑定父级菜单点击事件*/
    $('#pName,#pNameEdit').off().on('click',function () {
        //去后台取数据
        $.ajax({
            url:"/module/getFatherModuleTree",
            dataType:"json",
            type:"post",
            data: {"clickCallBack" : 'fatherModuleClickCallback()'},
            success:function (data) {
                //渲染父级菜单数据
                fatherModuleZTreeObj = renderCallbackRedioOrCheckboxZTree(fatherModuleZTreeObj,data,'fatherTree',true);
                //打开父级菜单弹层
                layui.use("layer",function () {
                    var layer = layui.layer;
                    dataBtnBox = layer.open({
                        title:'父级菜单',
                        type:1,
                        content: $('#fatherModuleTree'),
                        area: ['665px', '340px']
                    });
                });
            }
        });
    });

    /*添加*/
    $('#addModule').off().on('click',function () {
        disableThis($('#addModule'));
        $.ajax({
            url:"/module/addModule",
            dataType:"json",
            type:"post",
            data: $('#addModuleForm').serialize(),
            success:function (data) {
                releaseThis($('#addModule'));
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
                        $("#cancelAddModule").click();
                        reloadTable ();
                    }
                })
            }
        });
    });
    /*编辑*/
    $('#editModule').off().on('click',function () {
        disableThis($('#editModule'));
        $.ajax({
            url:"/module/editModule/"+$('#currentRecordId').val(),
            dataType:"json",
            type:"post",
            data: $('#editModuleForm').serialize(),
            success:function (data) {
                releaseThis($('#editModule'));
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
                        $("#cancelEditModule").click();
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
            $('#moduleStatus').val(data[key]==0?"停用":"启用");
            continue;
        }else if(key=="gmtCreated" || key=="gmtModified"){
            $("#"+key).val(formatDateTime(data[key]));
            continue;
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
        }else if(key=="gmtCreated" || key=="gmtModified"){
            continue;
        }
        $("#"+key+"Edit").val(data[key]);
    }
}

/*初始化分配按钮zTree对象*/
var setButtonZTreeObj;
/*分配按钮回调*/
function setModuleButton(data) {
    //渲染树
    setButtonZTreeObj = renderSimpleCheckboxZTree(setButtonZTreeObj,data,'tree');
    releaseThis($('#doSetModuleButton'));
    //保存
    $('#doSetModuleButton').off().on('click',function () {
        disableThis($('#doSetModuleButton'));
        var id = $("#currentRecordId").val();
        $.ajax({
            url:"/module/setModuleButton",
            dataType:"json",
            type:"post",
            data:{'ids':getZTreeSelected(setButtonZTreeObj),'id':id},
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

/**
 * 渲染复杂带回调的单选/复选树
 * @param zTreeObj
 * @param data
 * @param treeId
 * @param isSingle
 * @returns {*}
 */
function renderCallbackRedioOrCheckboxZTree(zTreeObj , data, treeId, isSingle) {
    var setting = {
        callback: {
            beforeCheck: fatherModuleClickCallback
        },
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        check: {
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
    //设置zTree单选复选形式
    if(isSingle){
        setting.check.enable = true;
        setting.check.chkboxType = '';
        setting.check.chkStyle = 'radio';
        setting.check.radioType = 'all';
    }else{
        setting.check.enable = true;
        setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
    }

    var zNodes = data;
    var t = $("#"+ treeId);
    zTreeObj = $.fn.zTree.init(t, setting, zNodes);
    return zTreeObj;
}
/*父级菜单点击回调*/
function fatherModuleClickCallback(treeId, treeNode) {
    // console.log(treeNode.id);
    // console.log();
    if(treeNode == undefined){
        return;
    }
    $('#pName,#pNameEdit').val(treeNode.name);
    $('#pid,#pidEdit').val(treeNode.id);
}