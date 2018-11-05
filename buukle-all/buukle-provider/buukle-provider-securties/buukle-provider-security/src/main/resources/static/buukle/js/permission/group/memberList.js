//@ sourceURL=userList.js
$(function () {
    /*绑定页面组件和按钮*/
    bindSearchConditionClickForFrame();
});
var tableIns;
function renderTable() {
    layui.use('table', function() {
        var tableForFrame = layui.table;
        //执行渲染
        tableIns = tableForFrame.render({
            elem: '#memberTable',
            url: '/user/getUserList',
            page: true,
            where: {
                username:   $('#fuzzy-index-1').val()
                ,startTime: ($('#startTimeForFrame').val()==""?"":$('#startTimeForFrame').val()+" 00:00:00")
                ,endTime:   ($('#endTimeForFrame').val()==""?"":$('#endTimeForFrame').val()+" 23:59:59")
                ,status: $('#searchStatusForFrame').val()
            },
            method: 'post',
            first:  '首页',
            last:   '尾页',
            request: {
                pageName: 'page',
                limitName: 'limit'
            }
            ,cols: [[
                { title:'<input type="checkbox" id="checkAll" lay-skin="primary">',width:60, align:'center',templet: '<div>{{formatCheckbox(d.userId)}} </div>'}
                ,{field:'id', width:400, title: 'ID',templet: '<div>{{d.userId}} </div>'}
                ,{field: 'username', title: '用户名', width:177}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtModified)}}</a></div>'}
                ,{title: '状态', width: 80,templet: '<div>{{formatStatus(d.status)}} </div>'}
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
