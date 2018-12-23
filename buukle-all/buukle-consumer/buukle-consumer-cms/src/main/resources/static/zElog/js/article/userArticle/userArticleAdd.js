//@ sourceURL=userArticleAdd.js
$(function () {
    //公共初始化
    commonInit();
    //初始化markdown组件
    markdownInit();
    //绑定输入校验
    bindInputValidate();
    //绑定按钮点击事件
    bindButtonClick();

});

/*绑定按钮点击事件*/
function bindButtonClick() {
    //保存
    $('#publish').off().on('click',function () {
        if(paramValidate()){
            $(this).html('发布中..');
            //提交
            $.ajax({
                url: '/articleInfo/publish',
                type: 'post',
                data: {'articleCatId' : $('#pid').val().trim(),'articleDesc' : $('#addAbstract').val().trim(),'title' : $('#addTitle').val().trim(),'articleContent' : editor.mdEditor.editorContainerEl.innerText},
                dataType: 'json',
                success: function (data) {
                    $('#publish').html('发布');
                    var code = data.code;
                    layui.use("layer",function () {
                        layer.msg(data.msg, code == "F" ?  {icon: 2} : {icon: 1});
                    })
                }
            })
        }
    })
    //草稿
    $('#draft').off().on('click',function () {
        if(paramValidate()){
            $(this).html('发布中..');
            //提交
            $.ajax({
                url: '/articleInfo/draft',
                type: 'post',
                data: {'articleCatId' : $('#pid').val().trim(),'articleDesc' : $('#addAbstract').val().trim(),'title' : $('#addTitle').val().trim(),'articleContent' : editor.mdEditor.editorContainerEl.innerText},
                dataType: 'json',
                success: function (data) {
                    $('#publish').html('发布');
                    var code = data.code;
                    layui.use("layer",function () {
                        layer.msg(data.msg, code == "F" ?  {icon: 2} : {icon: 1});
                    })
                }
            })
        }
    })
    //返回
    $('#cancel').off().on('click',function () {

    })
}

/*校验提交参数*/
function paramValidate() {
    if(!articleTitleFlag ){
        $('#titleErrorMsg').html("题目格式错误!");
        return false;
    }else{
        $('#titleErrorMsg').html("");
    }
    if(!articleCatFlag ){
        $('#catErrorMsg').html('请选择选择文章类别!');
        return false;
    }else{
        $('#catErrorMsg').html('');
    }
    if(!articleAbstractFlag){
        $('#abstractErrorMsg').html('文章摘要格式错误!');
        return false;
    }else{
        $('#abstractErrorMsg').html('');
    }
    return true;
}
/*绑定输入校验*/
var articleTitleFlag = false;
var articleAbstractFlag = false;
var articleCatFlag = false;
var articleCat_frame_index = '';
function bindInputValidate() {
    //输入题目
    var regTittle = new  RegExp(/^([\w]|[\u4e00-\u9fa5]|[()]|[（）]|[ ,]|[,]|[-]|[_]|[:]|[<]|[>]|[《]|[》]){0,64}$/);
    $('#addTitle').off().on('change',function () {
        var articleTitle = $(this).val().trim();
        if(articleTitle == ''){
            articleTitleFlag = false;
            $('#titleErrorMsg').html("题目不能为空!");
            return;
        }
        if(!regTittle.test(articleTitle)){
            articleTitleFlag = false;
            $('#titleErrorMsg').html("题目格式错误!");
            return;
        }else{
            articleTitleFlag = true;
            $('#titleErrorMsg').html("");
            return;
        }
    })
    //输入分类
    $('#addCat').off().on('click',function () {
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
                            articleCatFlag = true;
                            $('#addCat').val(node.name);
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
                        area: ['500px', '346px']
                    });
                });
            }
        });
    })
    /*防止二次点击*/
    $('#yes').off().on('click',function () {
        if(articleCatFlag){
            $('#addCat').attr('disabled',false);
            $('#articleCatTree').css('display','none');
            $('#articleCatTree').hide();
            layer.close(articleCat_frame_index);
        }else{
            layer.msg('请选择父级分类~', {icon: 5});
        }
    });
    //输入摘要
    var regArticleAbstract = new  RegExp(/^([\w]|[\u4e00-\u9fa5]|[()]|[（）]|[ ,]|[,]|[-]|[_]|[:]|[<]|[>]|[《]|[》]){0,128}$/);
    $('#addAbstract').off().on('change',function () {
        var articleAbstract = $(this).val().trim();
        if(articleAbstract == ''){
            $('#abstractErrorMsg').html("文章摘要不能为空!");
            articleAbstractFlag = false;
        }else if(!regArticleAbstract.test(articleAbstract)){
            $('#abstractErrorMsg').html("文章摘要格式错误!");
            articleAbstractFlag = false;
        }else{
            articleAbstractFlag = true;
            $('#abstractErrorMsg').html('');
        }
    })
}
/*初始化markdown组件*/
function markdownInit() {
    var content = [
        '# 段落',
        '## 子段落',
        '### 表格',
        '',
        '|@cols=2:合并单元格|',
        '|---|---|',
        '|cell|cell|',
        '',
        '### 柱状图',
        '',
        '```chart',
        ',单次访问,重复访问',
        '周一,700,500',
        '周二,800,600',
        '周三,700,500',
        '周四,800,600',
        '',
        'type:column',
        'title:网站访问量',
        'x.title:time',
        'y.title:count',
        'y.min:1',
        'y.max:1000',
        'y.suffix:人',
        '```',
    ].join('\n');
    //初始化编辑器
    editor = new tui.Editor({
        el: document.querySelector('#editSection'),
        // previewStyle: 'tab',
        previewStyle: 'vertical',
        height: '400px',
        initialEditType: 'markdown',
        // initialEditType: 'wysiwyg',
        useCommandShortcut: true,
        // useCommandShortcut: false,
        initialValue: content,
        exts: ['scrollSync', 'colorSyntax', 'uml', 'chart', 'mark', 'table', 'taskCounter']
    });
    //渲染方法
    // var editorq = tui.Editor.factory({
    //     el: document.querySelector('#viewerSection'),
    //     viewer: true,
    //     height: '500px',
    //     exts: ['table', 'uml', 'chart'],
    //     initialValue: editor.mdEditor.editorContainerEl.innerText
    // });
}