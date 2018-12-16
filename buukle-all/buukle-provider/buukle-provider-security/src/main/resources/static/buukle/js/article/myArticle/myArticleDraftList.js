//@ sourceURL=myArticleDraftList.js
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
            url: '/article/getArticleDraftList',
            page: true,
            where: {
                title:   $('#fuzzy-index-0').val()
                ,startTime: ($('#startTime').val()==""?"":$('#startTime').val()+" 00:00:00")
                ,endTime:   ($('#endTime').val()==""?"":$('#endTime').val()+" 23:59:59")
                ,state: $('#status').val()
            },
            method: 'post',
            first:  '首页',
            last:   '尾页',
            request: {
                pageName: 'pageNo',
                limitName: 'pageSize'
            }
            ,cols: [[
                {field:'title',title: '题目', width:230}
                ,{title: '创建时间',align:'center', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.creatTime)}}</a></div>'}
                ,{title: '操作',edit:'',align:'center',width: 300,templet: '<div>{{formatUserHandle(d.state,d.articleId)}} </div>'}
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
/*富文本编辑器回调*/
var articleContent ='';
function initTheLayEdit() {
    /*加载富文本编辑器*/
    layui.use('layedit', function(){
        var layedit = layui.layedit;
        articleContent = layedit.build('add-articleContent',
            {
                height: 396,
                tool: [
                    'strong'    //加粗
                    ,'italic'   //斜体
                    ,'underline' //下划线
                    ,'del'      //删除线
                    ,'|'        //分割线
                    ,'left'     //左对齐
                    ,'center'   //居中对齐
                    ,'right'    //右对齐
                    ,'link'     //超链接
                    ,'unlink'   //清除链接
                    ,'face'     //表情
                    ,'image'    //插入图片
                    ,'help'     //帮助
                ]
            });
    });
}
/*初始化页面全局变量*/
var hasSelected = false;                            //是否已经选择父级分类
var articleCat_frame_index = '';                    //文章分类弹层索引
/*绑定当前页面事件*/
function bindCurrentPageCilck() {
    /*绑定新增文章类别点击事件*/
    $('#add-property01').off().on('click',function () {
        $(this).attr('disabled',true);
        $.ajax({
            url:'/category/getArticleCatTree',
            dataType:'json',
            type:'post',
            success:function (data) {
                $('#articleCatTreeContain').html('');
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
        var layer = layui.layer;
        if(hasSelected){
            $('#add-property01').attr('disabled',false);
            layer.close(articleCat_frame_index);
        }else{
            layer.msg('请选择父级分类~', {icon: 5});
        }
    });
    /*题目校验*/
    var articleTitleFlag = false;
    var articleTitleFlagMsg = '题目格式错误!请检查题目~';
    var regTittle = new  RegExp(/^([\w]|[\u4e00-\u9fa5]|[(]|[)]|[（）]|[ ,]|[,]|[-]|[_]|[:]){0,32}$/);
    $('#add-title').off().on('keyup',function () {
        var articleTitle = $(this).val();
        if(!regTittle.test(articleTitle)){
            articleTitleFlag = false;
            $('#titleErrorMsg').html(articleTitleFlagMsg);

        }else{
            articleTitleFlag = true;
            $('#titleErrorMsg').html('');
        }
    });
    /*摘要校验*/
    var articleDescFlag = false;
    var articleDescFlagMsg = '摘要格式错误!请检查摘要~';
        var regArticleDesc = new  RegExp(/^([\w]|[\u4e00-\u9fa5]){0,88}$/);
    $('#add-articleDesc').off().on('keyup',function () {
        var articleDesc = $(this).val();
        if(!regArticleDesc.test(articleDesc)){
            $('#catErrorMsg').html(articleDescFlagMsg);
            articleDescFlag = false;
        }else{
            articleDescFlag = true;
            $('#catErrorMsg').html('');
        }
    });

    /*发布*/
    $('#publishArticle').off().on('click',function () {
        /*同步富文本中的内容*/
        layui.use('layedit', function(){
            var layedit = layui.layedit;
            layedit.sync(articleContent);
        });
        //验证必输项
        var layer = layui.layer;
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
                        var layer = layui.layer;
                        if(code == "F"){
                            layer.msg(data.msg, {icon: 2});
                        }else{
                            var confirm_index  = layer.confirm('文章发布成功,继续发布?', {
                                btn: ['继续','取消'],
                                title: '成功'
                            },function(){
                                clearTheArticleAddForm();
                                layer.close(confirm_index);
                                reloadTable();
                            },function () {
                                clearTheArticleAddForm();
                                layer.close(confirm_index);
                                layer.close(dataBtnBox);
                                reloadTable();
                            });
                        }
                    })
                }
            })
        }
    });
    /*存储草稿*/
    $('#saveArticle').off().on('click',function () {
        $.ajax({
            url: '/article/saveArticleDraft',
            type: 'post',
            data: $('#addArticleForm').serialize(),
            dataType: 'json',
            success: function (data) {
                var layer = layui.layer;
                if(data.code == 'S'){
                    layer.msg("草稿存储成功,请在草稿箱中查看编辑~");
                }else{
                    layer.msg("失败!原因:"+data.msg);
                }
                clearTheArticleAddForm();
                layer.close(dataBtnBox);
                reloadTable();
            }
        })
    })
}
/*清空新增文章表单*/
function clearTheArticleAddForm() {
    $('.buukle-article-add').val('');
    $('#LAY_layedit_1').contents().find('body').html('');
}
