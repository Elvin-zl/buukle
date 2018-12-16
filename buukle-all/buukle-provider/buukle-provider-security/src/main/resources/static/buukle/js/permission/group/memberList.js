//@ sourceURL=memberList.js
$(function () {
    /*绑定页面组件和按钮*/
    bindSearchConditionClickForFrame();
    /*绑定弹层按钮点击事件*/
    bindClick();
});
var tableIns;
function renderTable() {
    layui.use('table', function() {
        var tableForFrame = layui.table;
        //执行渲染
        tableIns = tableForFrame.render({
            elem: '#memberTable',
            url: '/user/getMemberList/'+$('#currentRecordId').val(),
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
                { title:'<input type="checkbox" data-checked="0" id="checkAll" lay-skin="primary">',width:60, align:'center',templet: '<div>{{formatCheckbox(d.userId,d.username)}} </div>'}
                ,{field: 'username', title: '用户名', width:177}
                ,{field:'id', width:350, title: 'ID',templet: '<div>{{d.userId}} </div>'}
                ,{ title:'是否是管理员',width:130, align:'center',templet: '<div>{{formatIsAdmin(d.userId,d.isAdmin,d.username)}} </div>'}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtModified)}}</a></div>'}
                ,{title: '状态', width: 80,templet: '<div>{{formatStatus(d.status)}} </div>'}
            ]]
            ,limits: [10, 20, 30,50,100]
            ,limit: 10
            ,done: function (res, pageNo, count) {
                //绑定按钮点击事件
                bindTableBtnsClick();
                bindCheckboxClick();
            }
        });
    });
}
/*重新加载表单*/
function reloadTable() {
    setTimeout(function () {
        tableIns.reload();
    },1000);
}
/*渲染当前组别*/
function formatGroupBelong(inputGroupsId,inputGroupsName) {
    if(inputGroupsName == null || inputGroupsName == undefined){
        inputGroupsName = "无";
    }
    return '<span class="currentGroups" data-currentGroupsId="'+inputGroupsId+'" style="color: forestgreen;">'+inputGroupsName+'</span>';
}
/*渲染是否属于当前组别*/
function formatIsInCurrentGroups(inputIsBelong) {
    return (inputIsBelong == 1) ? '<i class="layui-icon layui-icon-ok">&#xe605;</i>' : '<i class="layui-icon layui-icon-ok">&#x1006;</i>';
}
function bindClick() {

    /*回显当前组别*/
    $('#currentGroup').html($('#currentRecordName').val());

    /*保存*/
    $('#save').off().on('click',function () {
        //选中的ids
        var checkedIdsSrr = getCheckedIds();
        //管理员ids
        var adminIdsArr = getIsAdminIds();
        var adminIds = new Array;
        for(var i=0;i<adminIdsArr.length;i++){
            if($.inArray(adminIdsArr[i] ,checkedIdsSrr) != -1){
                adminIds.push(adminIdsArr[i]);
            }
        }
        confirmAndDo(checkedIdsSrr,adminIds,true);
    })
    /*保存*/
    $('#delete').off().on('click',function () {
        //选中的ids
        var checkedIdsSrr = getCheckedIds();
        //管理员ids
        var adminIdsArr = getIsAdminIds();
        var adminIds = new Array;
        for(var i=0;i<adminIdsArr.length;i++){
            if($.inArray(adminIdsArr[i] ,checkedIdsSrr) != -1){
                adminIds.push(adminIdsArr[i]);
            }
        }
        confirmAndDo(checkedIdsSrr,adminIds,false);
    })
}
/*确认并执行/取消 移动成员*/
function confirmAndDo(checkedIdsSrr,adminIds,isSave) {
    if(checkedIdsSrr == '' || checkedIdsSrr==undefined){
            layer.msg("请至少勾选一名用户!");
        return;
    }
    layui.use("layer",function () {
        confirmBtnBox = layer.confirm('您确认将选中的用户<span style="color:red">['+ (isSave ? "移入" : "移出")+']</span>本组吗?' +
            '<br/>选中的用户列表 : '+ getCheckedUsernames() + ';'+
            (isSave ? '<br/>其中管理员为 : ' + getIsAdminUsernames() : ''),
            {
            btn: ['确认','取消'],
            title: '请确认'
        }, function(){
            disableThis($('.layui-layer-btn0'));
            $('.layui-layer-btn0').parent().prepend("<a class='layui-layer-btn0' style='display:none'>确认</a>")
            $('.layui-layer-btn0').html("执行中 ... ")
            $.ajax({
                url: url,
                dataType: 'json',
                type: 'post',
                data:data,
                success: function (data) {
                    layer.msg(data.msg == null ? "操作成功!" : data.msg , {
                        icon: 1,
                        time: 1000
                    });
                    reloadTable ();
                },
                error: function(XMLHttpRequest, textStatus, errorThrown){
                    alert("调用接口失败!返回码 : "+textStatus);
                }
            });
        });
    });
}

/*获取选中用户名*/
function getCheckedUsernames() {
    var boxList = $('.buukle-checkbox');
    var namesArr = new Array;
    for(var i=0 ;i<boxList.length;i++){
        if($(boxList[i]).attr('data-checked') == '1'){
            namesArr.push($(boxList[i]).attr('data-username'));
        }
    }
    return namesArr;
}
/*获取选中的管理元用户名*/
function getIsAdminUsernames() {
    var listArr = $('.buukle-isAdmin');
    var nameArr = new Array;
    for(var i=0;i<listArr.length;i++){
        nameArr.push($(listArr[i]).attr('data-userId')+"_isAdmin");
    }
    var isAdminUsernames = new Array;
    for(var j = 0;j<nameArr.length;j++){
        if($("input[name="+nameArr[j]+"]:checked").val() != '-1'){
            isAdminUsernames.push($("input[name="+nameArr[j]+"]:checked").attr('data-username'));
        }
    }
    return isAdminUsernames;
}