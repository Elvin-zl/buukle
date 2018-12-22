//@ sourceURL=managerArticleList.js
$(function () {
    /*绑定页面按钮操作组件*/
    bindSearchConditionClick();
    /*绑定当前页面事件*/
    bindCurrentPageCilck();
});
var tableIns;
function renderTable() {
    layui.use('table', function() {
        var table = layui.table;
        //执行渲染
        tableIns = table.render({
            elem: '#table',
            url: '/articleInfo/getAuditArticleInfoList',
            page: true,
            where: {
                title:   $('#fuzzy-index-0').val()
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
                {field:'title',title: '题目', width:230}
                ,{field: 'likeNumber',align:'center', title: '赞数', width:60}
                /*,{field: 'ariticleAuthor',align:'center', title: '作者', width:70}*/
                ,{title: '创建时间',align:'center', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{field: 'property02',align:'center', title: '浏览量', width:80}
                ,{title: '状态',align:'center', width: 110,templet: '<div>{{formatArticleManagerStatus(d.status)}} </div>'}
                ,{title: '操作',fixed: 'right', width:290, align:'center',templet: '<div>{{formatUserHandle(d.status,d.id,d.username)}} </div>'}
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
            $('#roleStatus').val(data[key]==0?"停用":"启用");
            continue;
        }else if(key=="gmtCreated" || key=="modifiedTime"){
            $("#"+key).val(formatDateTime(data[key]));
            continue;
        }
        $("#"+key).val(data[key]);
    }
}
/*修改回显回调*/
function modify(data) {
    for(var key in data){
        if(key == "status"){
            $('#roleStatus').val(data[key]==0?"停用":"启用");
            continue;
        }else if(key=="gmtCreated" || key=="modifiedTime"){
            $("#modify-"+key).val(formatDateTime(data[key]));
            continue;
        }
        $("#modify-"+key).val(data[key]);
    }
}
/*审核回显回调*/
function audit(data) {
    for(var key in data){
        if(key == "status"){
            $('#roleStatus').val(data[key]==0?"停用":"启用");
            continue;
        }else if(key=="gmtCreated" || key=="modifiedTime"){
            $("#audit-"+key).val(formatDateTime(data[key]));
            continue;
        }
        $("#audit-"+key).val(data[key]);
    }
}
/*绑定当前业务事件*/
function bindCurrentPageCilck() {
    /*审核通过*/
    $('#auditPassArticle').off().on('click',function () {
        var articleId = $('#currentRecordId').val();
        $.ajax({
           url:'/article/auditPassArticle/'+articleId,
           type:'post',
           dataType:'json',
           success:function (data) {
               layer.msg(data.msg, {
                   icon: 1,
                   time: 1000
               });
               reloadTable ();
           }
       })
    });
    /*审核不通过*/
    $('#auditBanArticle').off().on('click',function () {
        var articleId = $('#currentRecordId').val();
        $.ajax({
            url:'/article/auditBanArticle/'+articleId,
            type:'post',
            dataType:'json',
            success:function (data) {
                layer.msg(data.msg, {
                    icon: 1,
                    time: 1000
                });
                reloadTable();
            }
        })
    });
}