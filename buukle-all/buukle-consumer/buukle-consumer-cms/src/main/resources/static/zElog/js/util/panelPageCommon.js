/*渲染本页按钮*/
function renderBtns() {
    /*渲染页面级别按钮*/
    renderPageLevelBtn();
    /*渲染列表级别按钮*/
    renderTableLevelBtn();
    /*绑定按钮事件*/
    bindTableBtnsClick();
}
/*渲染页面级别按钮*/
function renderPageLevelBtn() {
    var currentTabModuleId = parent.$(".layui-this").attr('lay-id');
    var pageBtnText = parent.$('#pageBtn-'+currentTabModuleId).val();
    var pageBtns =  JSON.parse(pageBtnText);
    var html = '';
    for(var i = 0;i < pageBtns.length;i++){
        html = '<span  class="layui-btn buukle-table-btn theme-btn buukle-right-padel-page-btn" data-responseType="'+pageBtns[i].buttonResponseType+'" data-operationType="'+pageBtns[i].buttonOperationType+'" data-url="'+pageBtns[i].url+'">'+pageBtns[i].moduleName+'</span>';
    }
    if(html != ''){
        $('#pageLevelBtn').html(html);
    }
}
/*渲染列表级别按钮*/
function renderTableLevelBtn() {
    var currentTabModuleId = parent.$(".layui-this").attr('lay-id');
    var tableBtnText = parent.$('#tableBtn-'+currentTabModuleId).val();
    var buttons =  JSON.parse(tableBtnText);
    var html = '';
    for (var i = 0; i < buttons.length; i++) {
        if(buttons[i].buttonOperationType != 4 && buttons[i].buttonOperationType != 5 && buttons[i].buttonOperationType != 6){
            //修改
            if(buttons[i].buttonOperationType == 2){
                html += '<a class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-id="" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'"  data-url="'+buttons[i].url+'">'+buttons[i].moduleName+'</a>'
            }
            //删除
            else if(buttons[i].buttonOperationType == 1){
                html += '<a class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-id="" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'"   data-url="'+buttons[i].url+'">'+buttons[i].moduleName+'</a>'
            }
        }
    }
    $('#tableLevelBtn').html(html);
}
/*绑定按钮点击事件*/
function bindTableBtnsClick() {
    $('.buukle-table-btn').off().on('click',function () {
        $('.layui-layer-content').html('');
        var btnsTypesText = parent.$('#globalBtnType').val();
        //全局按钮操作类型
        var btnsTypes =  JSON.parse(JSON.parse(btnsTypesText));
        //按钮响应类型        (按钮响应类型 ==> 0:confirm(确认框) 1:frame(弹层))
        var dataResponseType = $(this).attr('data-responseType');
        //当前按钮操作类型    (按钮操作类型 ==> 0:添加 1删除 2:修改 3:详情 4: 申请启用 5:审核 6;启/停用 7:分配角色 8:分配菜单)
        var dataOperationType = $(this).attr('data-operationType');
        //按钮执行的url
        var url = $(this).attr('data-url');
        //当前按钮的名称 用于弹框提示
        var btnName = "<span style='color: red'>"+$(this).html()+"</span>";
        //当前按钮所在行对应记录的状态
        var status = $(this).attr('data-state');
        //当前按钮所在行对应记录的ID
        var id =  $(this).attr('data-id');
        //当前按钮名称
        var moduleName = $(this).html();
        //缓存当前操作的id到隐藏域
        if(id != undefined && id != ''){
            $('#currentRecordId').val(id);
        }
        for (var i = 0 ; i < btnsTypes.length; i++){
            if(dataResponseType == 0 && dataOperationType == btnsTypes[i].btnCode ){//conform  确认框
                layui.use("layer",function () {
                    var layer = layui.layer;
                    confirmBtnBox = layer.confirm('您确认执行[ '+btnName+' ]操作吗?', {
                        btn: ['确认','取消'],
                        title: '请确认'
                    }, function(){
                        $.ajax({
                            url: url,
                            dataType: 'json',
                            type: 'post',
                            data:{"id": id,"status":status},
                            success: function (data) {
                                layer.msg(data.msg, {
                                    icon: 1,
                                    time: 1000
                                });
                                reloadTable ();
                            }
                        });
                    });
                });
                break;
            }

            if(dataResponseType == 1 && dataOperationType == btnsTypes[i].btnCode){//frame 弹层
                if(url != ''){
                    //取出按钮url数据,并判断按钮类型回显数据
                    $.ajax({
                        url: url+"?v="+Math.random(),
                        dataType: 'json',
                        data:{"id":id},
                        cache:false,
                        type: 'post',
                        success: function (data) {
                            doCallback(eval(btnsTypes[i].btnId),[data]);
                        }
                    });
                }
                //弹出相应的弹层框
                var  DomId = btnsTypes[i].btnId;
                var width = '970px';
                var height = '550px';
                //添加时放大弹框
                /*if(btnsTypes[i].btnCode == 0){
                 width = '1110px';
                 height = '700px';
                 }*/
                layui.use("layer",function () {
                    var layer = layui.layer;
                    dataBtnBox = layer.open({
                        title:moduleName,
                        type:1,
                        content: $('#'+DomId),
                        area: [width, height]
                    });
                });
                //初始化弹层内富文本编辑器
                if($('#layEditFlag').val() == 1){
                    initTheLayEdit();
                }
                break;
            }
        }
    })
}
/*动态回调*/
function doCallback(fn,args){
    fn.apply(this, args);
}