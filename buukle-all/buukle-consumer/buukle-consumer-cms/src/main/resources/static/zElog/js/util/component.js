//@ sourceURL=component.js
/*确认框按钮对象*/
var confirmBtnBox;
/*数据框按钮对象*/
var dataBtnBox;
/*绑定搜索控件点击事件*/
function bindsearchConditionClick() {
    /*绑定模糊搜索*/
    bindFuzzySearchItemsClick();
    //渲染日期控件
    renderDate();
    //绑定搜索按钮点击事件
    bindSearchBtnClick();
    //绑定清空按钮点击事件
    bindEmptyBtnClick();
    //渲染页面级别按钮组
    renderPageLevelButton();
    //渲染列表
    renderTable();
    //公共初始化
    initPage();
}
/*公共初始化*/
function initPage() {
    //初始化父页面主题
    initIndexTheme();
    //初始化按钮主题
    initBtnTheme();
}
/*初始化父页面主题*/
function initIndexTheme() {
    parent.$("#themeCss").attr('href',parent.$('#currentDBTheme').val());
}
/*初始化按钮主题*/
function initBtnTheme() {
    var themeUrl = parent.$("#themeCss").attr('href');
    $('#btnThemeCss').attr('href',themeUrl);
}

/*渲染模糊搜索效果,事件*/
function bindFuzzySearchItemsClick() {
    var fuzzyUrl = '';
    var fuzzyText = '';
    var fuzzyIndex = '';
    //change事件
    $('.fuzzy-input').on('keyup',function () {
        fuzzyUrl = $(this).attr('data-fuzzyUrl');
        fuzzyIndex = $(this).attr('id');
        fuzzyText = $(this).val();
        //请求数据并生成搜索建议框
        getFuzzyData(fuzzyUrl,fuzzyText,fuzzyIndex);
    });
    //请求数据
    function getFuzzyData(fuzzyUrl, fuzzyText,fuzzyIndex) {
        if(fuzzyText == ''){
            fuzzyText = '!@#$%^%$-+';
        }
        $.ajax({
            url:fuzzyUrl,
            type:'post',
            data:{"fuzzyText":fuzzyText},
            dataType:'json',
            success:function (data) {
                //生成建议框
                genAdvertiseSearchItem(data,fuzzyIndex);
            }
        });
    }
    //生成建议框
    function genAdvertiseSearchItem(data,fuzzyIndex) {
        var html = '';
        for(var i = 0;i < data.length;i++){
            html += '<label class="layui-form-label fuzzyItem theme-btn">'+data[i].text+'</label>';
        }
        var indexArr = fuzzyIndex.split('-');
        var fuzzyDiv =  $('#fuuzyDiv-id-'+indexArr[2]);
        fuzzyDiv.html(html);
        fuzzyDiv.show();
        //绑定模糊搜索建议框事件
        bindFuzzySlidAndClick();
    }
    //绑定建议框事件
    function bindFuzzySlidAndClick() {
        //划过效果
        var fuzzyItem =  $('.fuzzyItem');
        fuzzyItem.on('mouseover',function () {
            $(this).css('background-color','#0c9a8d');
        });
        fuzzyItem.on('mouseleave',function () {
            $(this).css('background-color','whitesmoke');
        });
        //点击事件
        fuzzyItem.on('click',function () {
            var fuzzyIndex = $(this).parent().attr('data-fuuzyIndex');
            $('#fuzzy-index-'+fuzzyIndex).val($(this).html());
            $(this).parent().html('');
            $('.fuzzySearchDiv').hide();
        })
    }
}

/*渲染日期控件*/
function renderDate() {
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#startTime',format: 'yyyy-MM-dd'
        });
        laydate.render({
            elem: '#endTime',format: 'yyyy-MM-dd'
        });
    });
}
/*绑定搜索按钮*/
function bindSearchBtnClick() {
    $('#searchBtn').off().on('click',function () {
        renderTable();
    })
}
/*绑定清空按钮*/
function bindEmptyBtnClick() {
    $('#emptyBtn').off().on('click',function () {
        $('.search-condition').val('');
        $('.search-condition-select').val('');
    })
}
/*渲染页面级别按钮*/
function renderPageLevelButton() {
    var currentTabModuleId = parent.$(".layui-this").attr('lay-id');
    var pageBtnText = parent.$('#pageBtn-'+currentTabModuleId).val();
    var pageBtns =  JSON.parse(pageBtnText);
    var html = '';
    for(var i = 0;i < pageBtns.length;i++){
        html = '<span  class="layui-btn empty-btn layui-btn-primary  buukle-table-btn" data-responseType="'+pageBtns[i].buttonResponseType+'" data-operationType="'+pageBtns[i].buttonOperationType+'" data-url="'+pageBtns[i].url+'">'+pageBtns[i].moduleName+'</span>';
    }
    if(html != ''){
        $('#emptyBtn').after(html);
    }
}
/**
 * 配置列表级别按钮组
 * param  inputState : 当前记录的状态
 * param  id         : 当前记录的id
 * */
function formatUserHandle(inputState,id) {
    var currentTabModuleId = parent.$(".layui-this").attr('lay-id');
    var tableBtnText = parent.$('#tableBtn-'+currentTabModuleId).val();
    var buttons =  JSON.parse(tableBtnText);
    var html = '';
    for (var i = 0; i < buttons.length; i++) {
        // 1. 处理常规按钮渲染展示
        if(buttons[i].buttonOperationType != 4 && buttons[i].buttonOperationType != 5 && buttons[i].buttonOperationType != 6){
            //详情
            if(buttons[i].buttonOperationType == 3){
                html += '<a class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].moduleName+'</a>'
            }
            //修改
            else if(buttons[i].buttonOperationType == 2 && inputState != 4){
                html += '<a class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].moduleName+'</a>'
            }
            //删除
            else if(buttons[i].buttonOperationType == 1){
                html += '<a  class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].moduleName+'</a>'
            }
            //其他
            else if(inputState != 4){
                html += '<a class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].moduleName+'</a>'
            }
        }
        //2. 处理申请( [启用/解禁]...等)变更状态按钮动态展示
        else if( buttons[i].buttonOperationType == 4 && (inputState == 0 || inputState == 5)){
            if(inputState == 0){
                html += '<a style="background-color: #5f6b70;" class="layui-btn layui-btn-mini buukle-table-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].moduleName+'</a>'
            }
            if(inputState == 5){
                html += '<a style="background-color: #5f6b70;" class="layui-btn layui-btn-mini buukle-table-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">重新申请</a>'
            }
        }
        //3. 处理( [审核] ...等)变更状态按钮动态展示
        else if(buttons[i].buttonOperationType == 5 && (inputState == 3 ||inputState == 4)){
            html += '<a style="background-color: #5f6b70;" class="layui-btn layui-btn-mini buukle-table-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].moduleName+'</a>'
        }
        //4. 处理 [启/停用] 按钮动态展示
        else if(buttons[i].buttonOperationType == 6){
            if( (inputState == 3)){
                html += ''
            }else if(inputState == 0 || inputState == 5){
                html += '<a class="layui-btn layui-btn-mini buukle-table-btn theme-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">解禁</a>'
            }else if(inputState == 1){
                html += '<a class="layui-btn layui-btn-mini buukle-table-btn theme-btn" data-responseType="'+buttons[i].buttonResponseType+'" data-operationType="'+buttons[i].buttonOperationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">封禁</a>'
            }
        }
    }
    return html;
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
/*---------------------------------元素级别工具---------------------------------------*/
/*格式化时间戳*/
function formatDateTime(inputTime) {
    var date = new Date(inputTime);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    h = h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    var second = date.getSeconds();
    minute = minute < 10 ? ('0' + minute) : minute;
    second = second < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
}
/*格式化状态值*/
function formatStatus(inputState) {
    var status = inputState == 0 ? "<span style='color: red;'>停用</span>" : "<span style='color: forestgreen'>启用</span>";
    return  status;
}
/*格式化用户文章列表状态值*/
function formatArticleStatus(inputState) {
    var status = '未知' ;
    if(inputState == 0){
        status = "<span style='color: red'>封禁</span>";
    }else if(inputState == 1){
        status = "<span style='color: forestgreen;'>发布成功</span>";
    }else if(inputState == 3){
        status = "<span style='color: #6e5f5f;'>发布审核中</span>";
    }else if(inputState == 4){
        status = "<span style='color: #7b7eb8;'>解禁审核中</span>";
    }else if(inputState == 5){
        status = "<span style='color: red;'>审核未通过</span>";
    }
    return  status;
}
/*格式化管理员文章列表状态值*/
function formatArticleManagerStatus(inputState) {
    var status = '未知' ;
    if(inputState == 0){
        status = "<span style='color: red'>封禁</span>";
    }else if(inputState == 1){
        status = "<span style='color: forestgreen;'>审核通过</span>";
    }else if(inputState == 3){
        status = "<span style='color: #7b7eb8;'>[发布]待审核</span>";
    }else if(inputState == 4){
        status = "<span style='color: #6e5f5f;'>[解禁]待审核</span>";
    }else if(inputState == 5){
        status = "<span style='color: red;'>审核不通过</span>";
    }
    return  status;
}

/*layui弹框提示工具组件*/
function alertMsg(data){
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.msg(data);
    });
}
/*输入框红色边框提示*/
function addRedBorderClass(item) {
    item.css('border','1px solid #f11a1ab0');
}
/*输入框聚焦取消红框*/
function removeRedBorderClass(item) {
    item.css('border','1px solid #c1c2c6');
}
/*去除空格*/
function Trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
