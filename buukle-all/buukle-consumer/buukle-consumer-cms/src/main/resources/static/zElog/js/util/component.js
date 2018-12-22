//@ sourceURL=component.js
/*确认框按钮对象*/
var confirmBtnBox;
/*数据框按钮对象*/
var dataBtnBox;
/*绑定控件点击事件*/
function bindSearchConditionClick() {
    /*绑定模糊搜索*/
    bindFuzzySearchItemsClick();
    /*绑定下拉框*/
    bindSelectSearchItemsClick();
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
/*绑定弹层控件点击事件*/
function bindSearchConditionClickForFrame() {
    /*绑定模糊搜索*/
    bindFuzzySearchItemsClick();
    //渲染日期控件
    renderDateForFrame();
    //绑定搜索按钮点击事件
    bindSearchBtnClickForFrame();
    //绑定清空按钮点击事件
    bindEmptyBtnClickForFrame();
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
    //隐藏列表框
    $("body").click(function () {
        $('.fuzzy-item-div').hide();
    });
    //文本框输入
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
            return;
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
            html += '<div class="layui-form-label fuzzy-item">'+data[i].text+'</div> ';
        }
        var indexArr = fuzzyIndex.split('-');
        var fuzzyDiv =  $('#fuzzy-items-index-'+indexArr[2]);
        fuzzyDiv.html(html);
        fuzzyDiv.show();
        //绑定模糊搜索建议框事件
        bindFuzzySlidAndClick();
    }
    //绑定建议框事件
    function bindFuzzySlidAndClick() {
        //划过效果
        var fuzzyItem =  $('.fuzzy-item');
        fuzzyItem.on('mouseover',function () {
            $(this).css('background-color','#808693');
        });
        fuzzyItem.on('mouseleave',function () {
            $(this).css('background-color','whitesmoke');
        });
        //点击事件
        fuzzyItem.on('click',function () {
            var fuzzyIndex = $(this).parent().attr('data-fuzzyIndex');
            $('#fuzzy-index-'+fuzzyIndex).val($(this).html());
            $(this).parent().html('');
            $('.fuzzy-item-div').hide();
        })
    }
}

/*渲染下拉效果,事件*/
function bindSelectSearchItemsClick() {
    //隐藏列表框
    $("body").click(function () {
        $('.select-item-div').hide();
    });
    //初始化参数
    var selectUrl = '';
    var selectIndex = '';
    var selectType = '';
    var superCode = '';
    //change事件
    $('.select-input').on('click',function () {
        selectUrl = $(this).attr('data-selectUrl');
        selectIndex = $(this).attr('id');
        selectType = $(this).attr('data-selectType');
        superCode = $(this).attr('data-superCode');
        //请求数据并生成搜索建议框
        getSelectData(selectUrl,selectIndex,selectType,superCode,$(this));
    });
    //请求数据
    function getSelectData(selectUrl, selectIndex,selectType,superCode,thisObj) {
        if(selectType == ''){
            return;
        }
        $.ajax({
            url:selectUrl,
            type:'post',
            data:{"selectType":selectType,"superCode":superCode},
            dataType:'json',
            success:function (data) {
                if(data.status == 'F'){
                    thisObj.focus();
                    addRedBorderClass(thisObj);
                    layer.msg(data.msg);
                    return;
                }
                //生成建议框
                genAdvertiseSelectItem(data,selectIndex,selectType);
            }
        });
    }
    //生成建议框
    function genAdvertiseSelectItem(data,selectIndex,selectType) {
        var html = '';
        for(var i = 0;i < data.length;i++){
            html += '<div class="layui-form-label select-item" data-selectType='+selectType+' data-idStr="'+data[i].idStr+'" data-idInteger="'+data[i].idInteger+'">'+data[i].text+'</div>';
        }
        var indexArr = selectIndex.split('-');
        var selectDiv =  $('#select-items-index-'+indexArr[2]);
        selectDiv.html(html);
        selectDiv.show();
        //绑定下拉建议框事件
        bindSelectSlidAndClick();
    }
    //绑定建议框事件
    function bindSelectSlidAndClick() {
        //划过效果
        var selectItem =  $('.select-item');
        selectItem.on('mouseover',function () {
            this.style.cursor='hand';
            $(this).css('background-color','#808693');
        });
        selectItem.on('mouseleave',function () {
            $(this).css('background-color','whitesmoke');
        });
        //点击事件
        selectItem.on('click',function () {
            var selectIndex = $(this).parent().attr('data-selectIndex');
            $('#select-index-'+selectIndex).val($(this).html());
            var idStr = $(this).attr('data-idStr');
            var idInteger = $(this).attr('data-idInteger');
            $('#select-index-idStr-'+selectIndex).val(idStr);
            $('#select-index-idInteger-'+selectIndex).val(idInteger);
            $(this).parent().html('');
            //点选platform时,为agent下拉框赋值superCode
            if($(this).attr('data-selectType') == 1){
                $('.selectType2').attr('data-superCode',idStr)
                removeRedBorderClass($('.selectType2'));
            }
            //点选agent时,为group下拉框赋值superCode
            if($(this).attr('data-selectType') == 2){
                $('.selectType3').attr('data-superCode',idStr);
                removeRedBorderClass($('.selectType3'));
            }
            //点选group时,为salesman下拉框赋值superCode
            if($(this).attr('data-selectType') == 3){
                $('.selectType4').attr('data-superCode',idStr);
                removeRedBorderClass($('.selectType4'));
            }
            $('.select-item-div').hide();
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
/*渲染日期控件(弹层列表)*/
function renderDateForFrame() {
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#startTimeForFrame',format: 'yyyy-MM-dd'
        });
        laydate.render({
            elem: '#endTimeForFrame',format: 'yyyy-MM-dd'
        });
    });
}
/*绑定搜索按钮*/
function bindSearchBtnClick() {
    $('#searchBtn').off().on('click',function () {
        renderTable();
    })
}
/*绑定搜索按钮(弹层列表)*/
function bindSearchBtnClickForFrame() {
    $('#searchBtnForFrame').off().on('click',function () {
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
/*绑定清空按钮(弹层列表)*/
function bindEmptyBtnClickForFrame() {
    $('#emptyBtnForFrame').off().on('click',function () {
        $('.search-condition-frame').val('');
        $('.search-condition-select-frame').val('');
    })
}
/*渲染页面级别按钮*/
function renderPageLevelButton() {
    var currentTabModuleId = parent.$(".layui-this").attr('lay-id');
    var pageBtnText = parent.$('#pageBtn-'+currentTabModuleId).val();
    if(pageBtnText == null || pageBtnText == '' || pageBtnText == undefined ){
        return;
    }
    var pageBtns =  JSON.parse(pageBtnText);
    var html = '';
    for(var i = 0;i < pageBtns.length;i++){
        html = html + '<span  class="layui-btn empty-btn layui-btn-primary  buukle-table-btn" data-responseDomId="'+pageBtns[i].responseDomId+'" data-responseType="'+pageBtns[i].responseType+'" data-operationType="'+pageBtns[i].operationType+'" data-url="'+pageBtns[i].url+'">'+pageBtns[i].buttonName+'</span>';
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
function formatUserHandle(inputState,id,name) {
    var currentTabModuleId = parent.$(".layui-this").attr('lay-id');
    var tableBtnText = parent.$('#tableBtn-'+currentTabModuleId).val();
    var buttons =  JSON.parse(tableBtnText);
    var html = '';
    name = (name == undefined || name == '') ? '' : name;
    for (var i = 0; i < buttons.length; i++) {
        // 1. 处理常规按钮渲染展示
        if(buttons[i].operationType != 4 && buttons[i].operationType != 5 && buttons[i].operationType != 6){
            //详情
            if(buttons[i].operationType == 3){
                html += '<a class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-name="'+name+'" data-responseDomId="'+buttons[i].responseDomId+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].buttonName+'</a>'
            }
            //修改
            else if(buttons[i].operationType == 2 && inputState != 4){
                html += '<a class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-name="'+name+'" data-responseDomId="'+buttons[i].responseDomId+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].buttonName+'</a>'
            }
            //删除
            else if(buttons[i].operationType == 1){
                html += '<a  class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-name="'+name+'" data-responseDomId="'+buttons[i].responseDomId+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].buttonName+'</a>'
            }
            //其他
            else if(inputState != 4){
                html += '<a class="layui-btn layui-btn-mini theme-btn buukle-table-btn" data-name="'+name+'" data-responseDomId="'+buttons[i].responseDomId+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].buttonName+'</a>'
            }
        }
        //2. 处理申请( [启用/解禁]...等)变更状态按钮动态展示
        else if( buttons[i].operationType == 4 && (inputState == 0 || inputState == 5) ){
            if(inputState == 0){
                html += '<a style="background-color: #5f6b70;" class="layui-btn layui-btn-mini buukle-table-btn" data-name="'+name+'" data-responseDomId="'+buttons[i].responseDomId+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].buttonName+'</a>'
            }
            if(inputState == 5){
                html += '<a style="background-color: #5f6b70;" class="layui-btn layui-btn-mini buukle-table-btn" data-name="'+name+'" data-responseDomId="'+buttons[i].responseDomId+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">重新申请</a>'
            }
        }
        //3. 处理( [审核] ...等)变更状态按钮动态展示
        else if(buttons[i].operationType == 5 && (inputState == 3 ||inputState == 4)){
            html += '<a style="background-color: #5f6b70;" class="layui-btn layui-btn-mini buukle-table-btn" data-name="'+name+'" data-responseDomId="'+buttons[i].responseDomId+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">'+buttons[i].buttonName+'</a>'
        }
        //4. 处理 [启/停用] 按钮动态展示
        else if(buttons[i].operationType == 6){
            if( (inputState == 3)){
                html += ''
            }else if(inputState == 0 || inputState == 5){
                html += '<a class="layui-btn layui-btn-mini buukle-table-btn theme-btn" data-name="'+name+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">解禁</a>'
            }else if(inputState == 1){
                html += '<a class="layui-btn layui-btn-mini buukle-table-btn theme-btn" data-name="'+name+'" data-responseType="'+buttons[i].responseType+'" data-operationType="'+buttons[i].operationType+'" data-state="'+inputState+'" data-id="'+id+'" data-url="'+buttons[i].url+'">封禁</a>'
            }
        }
    }
    return html;
}
/*绑定按钮点击事件*/
function bindTableBtnsClick() {
    //初始化参数
    var btnsTypesText;
    var btnsTypes;
    var dataResponseType;
    var dataOperationType;
    var responseDomId;
    var url ;
    var btnName;
    var status;
    var id ;
    var moduleName ;
    var name;

    $('.buukle-table-btn').off().on('click',function () {
        $('.layui-layer-content').html('');
        $('.bukkle-detail').html('');
        $('.add-input').val("");
        $('.buukle-add-textarea').val("");

        btnsTypesText = parent.$('#globalBtnType').val();
        //全局按钮操作类型
        btnsTypes =  JSON.parse(JSON.parse(btnsTypesText));
        //按钮响应类型        (按钮响应类型 ==> 0:confirm(确认框) 1:frame(弹层))
        dataResponseType = $(this).attr('data-responseType');
        //当前按钮操作类型    (按钮操作类型 ==> 0:添加 1删除 2:修改 3:详情 4: 申请启用 5:审核 6;启/停用 7:分配角色 8:分配菜单)
        dataOperationType = $(this).attr('data-operationType');
        //当前按钮页面响应元素ID
        responseDomId = $(this).attr('data-responseDomId');
        //按钮执行的url
        url = $(this).attr('data-url');
        //当前按钮的名称 用于弹框提示
        btnName = "<span style='color: red'>"+$(this).html()+"</span>";
        //当前按钮所在行对应记录的状态
        status = $(this).attr('data-state');
        //当前按钮所在行对应记录的ID
        id =  $(this).attr('data-id');
        //当前按钮名称
        moduleName = $(this).html();
        //当前记录名称
        name = $(this).attr('data-name');
        //缓存当前操作的id到隐藏域
        if(id != undefined && id != ''){
            $('#currentRecordId').val(id);
        }
        if(name != undefined && name != ''){
            $('#currentRecordName').val(name);
        }
        //conform  确认框
        if(dataResponseType == 0 ){
            var layer = layui.layer;
            var data = {"id": id,"status":status};
            if(parseFloat(id).toString() == "NaN"){
                data = {"userId": id,"status":status};
            }
            layui.use("layer",function () {
                confirmBtnBox = layer.confirm('您确认执行[ '+btnName+' ]操作吗?', {
                    btn: ['确认','取消'],
                    title: '请确认'
                }, function(){
                    disableThis($('.layui-layer-btn0'));
                    $('.layui-layer-btn0').parent().prepend("<a class='layui-layer-btn0' style='display:none'>确认</a>");
                    $('.layui-layer-btn0').html("执行中 ... ");
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
            return;
        }
        //frame 弹层(取数据 & 不取数据)
        if(dataResponseType == 1 || dataResponseType == 2 ){
            //清除弹框中上次操作的遗留数据
            $(".containsClearAbleBuukle").html("");
            $(".clearAbleBuukle").css("display","none");
            var data = {"id": id};
            if(parseFloat(id).toString() == "NaN"){
                data = {"userId": id};
            }
            if(url != ''){
                //取出按钮url数据,并判断按钮类型回显数据
                $.ajax({
                    url: url+"?v="+Math.random(),
                    dataType: 'json',
                    data:data,
                    cache:false,
                    type: 'post',
                    success: function (data) {
                        doCallback(eval(responseDomId),[data]);
                    }
                });
            }
            //弹出相应的弹层框
            var width = '970px';
            var height = '550px';
            //添加时放大弹框
            /*if(btnsTypes[i].typeValue == 0){
             width = '1110px';
             height = '700px';
             }*/
            layui.use("layer",function () {
                var layer = layui.layer;
                dataBtnBox = layer.open({
                    title:moduleName,
                    type:1,
                    content: $('#'+responseDomId),
                    area: [width, height]
                });
            });
            //初始化弹层内富文本编辑器
            if($('#layEditFlag').val() == 1){
                initTheLayEdit();
            }
            return;
        }
        //frame 弹层(加载其他列表页面)
        if(dataResponseType == 3 ){
            //清除弹框中上次操作的遗留数据
            $('#currentRecordName').val(name);
            $('#'+ responseDomId  + 'Load').load(url);
            //弹出相应的弹层框
            var  width = '1200px';
            var   height = '800px';
            layui.use("layer",function () {
                var layer = layui.layer;
                dataBtnBox = layer.open({
                    title:moduleName,
                    type:1,
                    content: $('#'+responseDomId),
                    area: [width, height]
                });
            });
            return;
        }
    })
}
/*动态回调*/
function doCallback(fn,args){
    fn.apply(this, args);
}
/*zTree动态回调*/
function doCallbackForZtree(callback,args){
    if(callback != undefined && callback != ''){
        callback.apply(this, args);
    }
}

/*---------------------------------元素级别工具---------------------------------------*/
/*格式化时间戳*/
function formatDateTime(inputTime) {
    if(inputTime == '' || inputTime == undefined){
        return '无';
    }
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
    return  inputState == 0 ? "<span style='color: red;'>停用</span>" : "<span style='color: forestgreen'>启用</span>";
}
/*格式化状态值*/
function formatInputStatus(inputState) {
    return  inputState == 0 ? " 停用" : "启用";
}
/*格式化页面级别值*/
function formatInputLayoutLevel(inputLevel) {
    return inputLevel == 0 ? "页面级别" : "列表级别";
}
/*格式化操作类型*/
function formatInputOperationType(inputOperationType) {
    //0:添加 1:删除 2:修改 3:详情 4: 申请启用 5:审核 6;启/停用 7:分配角色 8:分配菜单)
    var type ;
    if(inputOperationType == 0){
        type = " 添加 ";
    }else if(inputOperationType == 1){
        type = " 删除 ";
    }else if(inputOperationType == 3){
        type = " 修改 ";
    }else if(inputOperationType == 4){
        type = " 详情 ";
    }else if(inputOperationType == 5){
        type = " 申请启用 ";
    }else if(inputOperationType == 6){
        type = " 启/停用 ";
    }else if(inputOperationType == 7){
        type = " 多表设置 ";
    }
    return  type;
}
/*格式化响应类型*/
function formatInputResponseType(inputResponseType) {
    if(inputResponseType == 0){
        return "提示确认框";
    }else if(inputResponseType == 1){
        return "弹层页面取接口数据";
    }else if(inputResponseType == 2){
        return "弹层页不取接口数据";
    }else if(inputResponseType == 3){
        return "弹层页加载其他列表";
    }
}
/*格式化复选框*/
function formatCheckboxWithStatus(inputId,isBelong) {
    if(isBelong == '1'){
        return '<input type="checkbox" class="buukle-checkbox" data-checked="1" checked="" data-id="'+inputId+'" lay-skin="primary">';
    }
    return '<input type="checkbox" class="buukle-checkbox" data-checked="0" data-id="'+inputId+'" lay-skin="primary">';
}
/*格式化复选框*/
function formatCheckbox(inputId,inputUsername) {
    return '<input type="checkbox" class="buukle-checkbox" data-checked="0" data-id="'+inputId+'" data-username="'+inputUsername+'" lay-skin="primary">';
}
/*格式化单选按钮*/
function formatIsAdmin(inputId,isAdmin,inputUsername) {
    var isChecked = "checked";
    var redio = "_isAdmin";
    if(isAdmin != '1'){
        return ' 是 <input type="radio" name="'+inputId+redio+'" data-username="'+inputUsername+'" data-userId="'+inputId+'" class="buukle-isAdmin" value="'+inputId+'" lay-skin="primary" style="display: initial;"> 否 <input name="'+inputId+redio+'" type="radio" lay-skin="primary" checked style="display: initial;" value="-1"> ';
    }else{
        return ' 是 <input type="radio" name="'+inputId+redio+'" data-username="'+inputUsername+'" data-userId="'+inputId+'" class="buukle-isAdmin" value="'+inputId+'" checked lay-skin="primary" style="display: initial;"> 否 <input name="'+inputId+redio+'" type="radio" lay-skin="primary" style="display: initial;" value="-1"> ';
    }
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
function Trim(str){
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
/*防止多次点击--禁用按钮*/
function disableThis(param) {
    param.attr('disabled',true);
    param.html('加载中...');
}/*防止多次点击--释放按钮*/
function releaseThis(param) {
    param.attr('disabled',false);
    param.html('保存');
}
/*回显下拉框值*/
function selectValue(key,value,random) {
    var allSelect= $("#"+key+"Edit > option");
    for(var i=0;i<allSelect.length;i++){
        $("#"+key+"Edit > option[value='"+allSelect[i].value+"']").removeAttr("selected");
        if(value==allSelect[i].value){
            $("#"+key+"Edit > option[value='"+value+"']").prop("selected","selected");
        }
    }
}
/**
 * 渲染简单的复选框树
 * @param zTreeObj   接收树初始化前对象
 * @param data       节点数据
 * @param treeId     渲染树的载体id
 * @returns zTreeObj 返回树初始化后对象
 */
function renderSimpleCheckboxZTree(zTreeObj , data, treeId) {
    var setting = {
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
    setting.check.enable = true;
    setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
    var zNodes = data;
    var t = $("#"+ treeId);
    zTreeObj = $.fn.zTree.init(t, setting, zNodes);
    return zTreeObj;
}

/*获取zTree选中id值*/
function getZTreeSelected(setModuleZTreeObj) {
    var ids ='';
    var nodes = setModuleZTreeObj.getCheckedNodes(true);
    for(var i=0;i<nodes.length;i++){
        ids = ids + nodes[i].id + ',';
    }
    return ids;
}

/*绑定复选框点击事件*/
function bindCheckboxClick() {
    //全选复选框点击事件
    $('#checkAll').next().off().on('click',function () {
        if($(this).attr('data-checked') == '1'){
            $('.buukle-checkbox').attr('data-checked',"0");
            $('.buukle-checkbox').next().removeClass('layui-form-checked');
            var boxList = $('.buukle-checkbox');
            for(var i=0;i<boxList.length;i++){
                $(boxList[i]).next().removeClass('layui-form-checked');
            }
            $(this).attr('data-checked','0');
            $(this).removeClass('layui-form-checked');
        }else{
            $('.buukle-checkbox').attr('data-checked',"1");
            $('.buukle-checkbox').addClass('layui-form-checked');
            var boxList = $('.buukle-checkbox');
            for(var i=0;i<boxList.length;i++){
                $(boxList[i]).next().addClass('layui-form-checked');
            }
            $(this).attr('data-checked','1');
            $(this).addClass('layui-form-checked');

        }

    });

    //复选框点击事件
    $('.buukle-checkbox').next().off().on('click',function () {
        if($(this).prev().attr('data-checked') == 1){
            $(this).prev().attr('data-checked','0');
            $(this).removeClass('layui-form-checked');
            //控制全选按钮
            $('#checkAll').attr('data-checked','0');
            $('#checkAll').next().removeClass('layui-form-checked');

        }else{
            $(this).prev().attr('data-checked','1');
            $(this).addClass('layui-form-checked');
            //控制全选按钮
            var boxList = $('.buukle-checkbox');
            var isAllChecked = true;
            for(var i=0;i<boxList.length;i++){
                if($(boxList[i]).attr('data-checked') == 0){
                    isAllChecked = false;
                }
            }
            if(isAllChecked){
                $('#checkAll').attr('data-checked','1');
                $('#checkAll').next().addClass('layui-form-checked');
            }
        }
    })
}

/*获取选中的复选框的id值*/
function getCheckedIds() {
    var boxList = $('.buukle-checkbox');
    var idsArr = new Array;
    for(var i=0 ;i<boxList.length;i++){
        if($(boxList[i]).attr('data-checked') == '1'){
            idsArr.push($(boxList[i]).attr('data-id'));
        }
    }
    return idsArr;
}
/*获取管理员*/
function getIsAdminIds() {
    var listArr = $('.buukle-isAdmin');
    var nameArr = new Array;
    for(var i=0;i<listArr.length;i++){
        nameArr.push($(listArr[i]).attr('data-userId')+"_isAdmin");
    }
    var isAdminIds = new Array;
    for(var j = 0;j<nameArr.length;j++){
        if($("input[name="+nameArr[j]+"]:checked").val() != '-1'){
            isAdminIds.push($("input[name="+nameArr[j]+"]:checked").val());
        }
    }
    return isAdminIds;
}