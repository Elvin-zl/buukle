//@ sourceURL=myArticleList.js
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
            url: '/articleInfo/getUserArticleInfoList',
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
                ,{field: '',align:'center', title: '浏览量', width:80}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtModified)}}</a></div>'}
                ,{title: '状态', width: 100,templet: '<div>{{formatArticleStatus(d.status)}} </div>'}
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
function edit(data) {
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
/*富文本编辑器回调*/
function initTheLayEdit() {
    /*加载富文本编辑器*/
    layui.use('layedit', function(){
        layedit = layui.layedit;
        articleContent = layedit.build('add-articleContent',
            {
                height: 396,
                tool: [
                    'strong'                       //加粗
                    ,'italic'                      //斜体
                    ,'underline'                   //下划线
                    ,'del'                         //删除线
                    ,'|'                           //分割线
                    ,'left'                        //左对齐
                    ,'center'                      //居中对齐
                    ,'right'                       //右对齐
                    ,'link'                        //超链接
                    ,'unlink'                      //清除链接
                    ,'face'                        //表情
                    ,'image'                       //插入图片
                    ,'help'                        //帮助
                ]
            });
    });
}
/*初始化页面全局变量*/
var layer = layui.layer;                            //layer组件对象
var layedit = layui.layedit;                        //layedit组件对象
var hasSelected = false;                            //是否已经选择父级分类
var hasStartEdit = false;                           //是否已经开始编辑
var hasSaveDraft = false;                           //是否已经存储草稿
var articleCat_frame_index = '';                    //文章分类弹层对象索引
var autoSaveDraftT = '';                            //存储草稿定时任务对象索引
var preSyncArticleFormSerialize = '';               //同步前的文章表单
var afterSyncArticleFormSerialize = '';             //同步后的文章表单
var confirm_index = '';                             //确认框弹层对象索引
var articleContent ='';                             //文章内容容器textarea
var hasPublishFlag =false;                           //文章是否已发布
var articleTitleFlag = false;
var articleTitleFlagMsg = '题目格式错误!请检查题目~';

/*绑定当前页面事件*/
function bindCurrentPageCilck() {
    //绑定新增文章类别点击事件
    bindArticleCatClick();

    /*题目校验*/
    var regTittle = new  RegExp(/^([\w]|[\u4e00-\u9fa5]|[(]|[)]|[（）]|[ ,]|[,]|[-]|[_]|[:]){0,32}$/);
    $('#add-title').off().on('keyup',function () {
        var articleTitle = $(this).val();
        if(!regTittle.test(articleTitle)){
            articleTitleFlag = false;
            $('#titleErrorMsg').html(articleTitleFlagMsg);
        }else{
            //开启自动保存草稿定时任务
            OpenAutoSaveDraftTask();
            //更改草稿存储状态
            hasSaveDraft= false;
            articleTitleFlag = true;
            $('#titleErrorMsg').html('');
        }
    });
    /*摘要校验*/
    var articleDescFlag = false;
    var articleDescFlagMsg = '摘要格式错误!请检查摘要~';
    var regArticleDesc = new  RegExp(/^([\w]|[\u4e00-\u9fa5]){0,88}$/);
    $('#add-articleDesc').off().on('keyup',function () {
        //更改草稿存储状态
        hasSaveDraft= false;
        var articleDesc = $(this).val();
        if(!regArticleDesc.test(articleDesc)){
            $('#catErrorMsg').html(articleDescFlagMsg);
            articleDescFlag = false;
        }else{
            articleDescFlag = true;
            $('#catErrorMsg').html('');
        }
    });

    /*取消*/
    $('#cancelAddArticle').off().on('click',function () {
        //确认已经开始编辑
        if(hasStartEdit){
            //确认未自动保存
            if(!hasSaveDraft){
                confirm_index  = layer.confirm('有未保存的草稿,您确定放弃编辑并退出吗?', {
                    btn: ['存为草稿并退出','放弃'],
                    title: '提示'
                },function(){
                    //存储草稿
                    saveArticleDraft();
                    closeAllFrame();
                },function () {
                    //删除
                    deleteDraft();
                    closeAllFrame();
                });
            }else{
                confirm_index  = layer.confirm('已为您存为草稿,您确定放弃编辑并退出吗?', {
                    btn: ['存为草稿并退出','放弃'],
                    title: '提示'
                },function(){
                    //存储草稿
                    saveArticleDraft();
                    closeAllFrame();
                },function () {
                    //删除
                    deleteDraft();
                    closeAllFrame();
                });
            }
        }else{
            closeAllFrame();
        }
    });
    /*发布*/
    $('#publishArticle').off().on('click',function () {
        //同步文章内容
        syncArticleContent();
        //验证必输项
        //题目
        if($('#add-title').val() == ''){
            layer.msg('题目不能为空!',{icon: 5});
            return false;
        }else if(!articleTitleFlag){
            layer.msg(articleTitleFlagMsg,{icon: 5});
            return false;
        }
        //类别
        if($('#add-property01').val() == ''){
            layer.msg('请点选文章所属类别',{icon: 5});
            return false;
        }
        //
        if($('#add-articleDesc').val() == ''){
            layer.msg('摘要不能为空!',{icon: 5});
            return false;
        }else if(!articleDescFlag){
            layer.msg(articleDescFlagMsg,{icon: 5});
            return false;
        }
        //内容
        if($('#add-articleContent').val() == ''){
            layer.msg('内容不能为空!',{icon: 5});
            return false;
        }else{
            $(this).html('发布中..');
          //提交
            $.ajax({
                url: '/article/publish',
                type: 'post',
                data: $('#addArticleForm').serialize(),
                dataType: 'json',
                success: function (data) {
                    $('#publishArticle').html('发布');
                    var code = data.code;
                    layui.use("layer",function () {
                        if(code == "F"){
                            layer.msg(data.msg, {icon: 2});
                        }else{
                            hasPublishFlag = true;
                            var confirm_index  = layer.confirm('文章发布成功,继续发布?', {
                                btn: ['继续','取消'],
                                title: '成功'
                            },function(){
                                clearTheArticleAddForm();
                                clearInterval(autoSaveDraftT);
                                //重新初始化页面参数
                                resetInitArticleParam();
                                layer.close(confirm_index);
                            },function () {
                                closeAllFrame();
                            });
                        }
                    })
                }
            })
        }

    });
    /*存储草稿*/
    $('#saveArticle').off().on('click',function () {
        //题目
        if($('#add-title').val() == ''){
            layer.msg('题目不能为空!',{icon: 5});
            return false;
        }else if(!articleTitleFlag){
            layer.msg(articleTitleFlagMsg,{icon: 5});
            return false;
        }
        if(hasSaveDraft){
            layer.msg("草稿已存储,请在草稿箱继续编辑~");
            closeAllFrame();
        }else{
            saveArticleDraft();
            closeAllFrame();
        }
    });
}
/*绑定新增文章类别点击事件*/
function bindArticleCatClick() {
    $('#add-property01').off().on('click',function () {
        $(this).attr('disabled',true);
        $.ajax({
            url:'/articleCat/getArticleCatTree',
            dataType:'json',
            type:'post',
            success:function (data) {
                $('#articleCatTree').find('li').remove();
                layui.use('tree', function(){
                    layui.tree({
                        elem: '#articleCatTree' //传入元素选择器
                        ,nodes:  data,
                        click:function (node) {
                            hasSelected = true;
                            $('#add-property01').val(node.name);
                            $('#pid').val(node.id);
                        }
                    });
                });
                layui.use("layer",function () {
                    var layer = layui.layer;
                    articleCat_frame_index  = layer.open({
                        title:"选择文章类别",
                        type:1,
                        closeBtn: 0,
                        content: $('#articleCatTree'),
                        area: ['500px', '320px']
                    });
                });
            }
        });
    });
    /*防止二次点击*/
    $('#yes').off().on('click',function () {
        if(hasSelected){
            $('#add-property01').attr('disabled',false);
            layer.close(articleCat_frame_index);
        }else{
            layer.msg('请选择父级分类~', {icon: 5});
        }
    });
}
/*自动保存草稿定时任务*/
function OpenAutoSaveDraftTask() {
    //确认定时轮询只执行一次
    if(!hasStartEdit){
        autoSaveDraftT = setInterval(function () {
            //第一次编辑
            if(!hasStartEdit){
                preSyncArticleFormSerialize = '';
            }
            //同步文章内容
            syncArticleContent();
            afterSyncArticleFormSerialize = $('#addArticleForm').serialize();
            //值变化后进行自动保存
            if(afterSyncArticleFormSerialize != preSyncArticleFormSerialize){
                saveArticleDraft();
            }
            preSyncArticleFormSerialize = afterSyncArticleFormSerialize ;
            //更改进入编辑状态
            hasStartEdit = true;
        },30000)
    }
}
/*同步文章内容*/
function syncArticleContent() {
    layui.use('layedit', function(){
        layedit.sync(articleContent);
    });
}
/*关闭新增文章的所有弹层*/
function closeAllFrame() {
    resetInitArticleParam();
    layer.close(confirm_index);
    layer.close(dataBtnBox);
    clearInterval(autoSaveDraftT);

}
/*重新初始化页面参数*/
function resetInitArticleParam() {
    hasStartEdit = false;
    hasSaveDraft = false;
    hasPublishFlag = false;
    clearTheArticleAddForm();
    reloadTable();
}
/*清空新增文章表单*/
function clearTheArticleAddForm() {
    $('#draftId').val(-1);
    $('.buukle-article-add').val('');
    $('#LAY_layedit_1').contents().find('body').html('');
}
/*执行存储草稿*/
function saveArticleDraft() {
    //题目
    if($('#add-title').val() == ''){
        return false;
    }else if(!articleTitleFlag){
        return false;
    }
    //同步文章内容
    syncArticleContent();
    if($('#draftId').val() == -1 && !hasPublishFlag){
            //新增 insert
            $.ajax({
                url: '/article/saveArticleDraft',
                type: 'post',
                data: $('#addArticleForm').serialize(),
                dataType: 'json',
                success: function (data) {
                    hasSaveDraft = true;
                    $('#draftId').val(data.data[0]);
                    if(data.code == 'S' && data.data.length > 1){
                        layer.msg("草稿存储成功");
                        hasSaveDraft = true;
                    }else{
                        layer.msg(data.msg);
                    }
                }
            });
    }else if(!hasPublishFlag){
        //更新 update
        $.ajax({
            url: '/article/updateArticleDraft',
            type: 'post',
            data: $('#addArticleForm').serialize(),
            dataType: 'json',
            success: function (data) {
                hasSaveDraft = true;
                if(data.code == 'S'){
                    if(data.msg != '-2'){
                        layer.msg("草稿存储成功");
                    }
                    hasSaveDraft = true;
                }else{
                    layer.msg(data.msg);
                }
            }
        });
    }
}
/*删除草稿*/
function deleteDraft() {
    //删除
    $.ajax({
        url: '/article/deleteArticleDraft',
        type: 'post',
        data: $('#addArticleForm').serialize(),
        dataType: 'json',
        success: function (data) {
            //nothing to do
        }
    });
}