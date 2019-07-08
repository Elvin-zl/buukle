/**
 * Created by elvin
 */
$(function(){
    // 绑定搜索框响应式
    bindSearchCss();
    // 绑定滚屏
    bindScroll();
    // 初始化触底加载参数
    initScrollParam();
    // 初始化弹层
    initPopLayer();
    // 加载首页广场数据
    loadTimelineContainer(1,null);
    // 处理排序
    handleOrderFlag();
    // 绑定写文章按钮
    bindWriteClick();
    // 处理跳转操作
    handleOperation();
});

/* 处理跳转操作*/
function handleOperation() {
    if($('#operation').val() != "" && $('#operation').val() != undefined ){
        setTimeout(function(){
        doCallback(eval("operation_" + $('#operation').val()),null);
        },600);
    }
}
/*动态回调*/
function doCallback(fn,args){
    fn.apply(this, args);
}

/*绑定写文章按钮*/
function bindWriteClick() {
    // 绑定新增文章
    $('#writeArticle').off().on('click',function () {
        window.open('http://www.buukle.top/articleInfo/toAddArticle','_blank');
    });
}

/*新增想法 -- 在回调时候用到了*/
function operation_add() {
    $('#writeTimeline').click();
}
/*绑定搜索框响应式*/
function bindSearchCss() {
    var width =  $(window).width();
    if(width <=420){
        $('#searchBox').addClass('search-box-phone');
        $('#searchInput').addClass('search-phone');
    }
}
/*处理排序*/
function handleOrderFlag() {
    $('.order-item').off().on('click',function () {
        $('#orderFlag').val($(this).attr('data-type'));
        $('.order-item').removeClass('order-active');
        $(this).addClass('order-active');
        $('#currentTopicOrder').html($(this).attr('data-txt'));
        $('#timelineContainer').html("");
        // 重新初始化触底加载参数
        initScrollParam();
        // 执行触底加载
        loadTimelineContainer(1);
    });
}

/*声明触底加载变量*/
var pageNumber ;
var continueLoad ;
var loadLock ;

/*初始化触底加载变量*/
function initScrollParam(){
    pageNumber = 1;
    continueLoad = true;
    loadLock = true;
    $('#timelineContainer').html("");
}
/*加载分类下的广场数据*/
function loadTimelineContainer(page) {
    loadLock = false;
    $.ajax({
        url : '/timelineInfo/getTimelineInfoList',
        data : {"topic" : $('#searchInput').val(),"page" : page,"limit" : 10,"orderFlag" :$('#orderFlag').val()},
        dataType : 'json',
        method : 'post',
        success : function (data) {
            var html = "";
            if($('#searchInput').val() == '' || $('#searchInput').val() == null){
                html = html + "所有";
            }else{
                html = html + $('#searchInput').val();
            }
            $('#currentTopic').html(html);
            if(data.data.length > 0){
                // 渲染想法列表
                renderTimelineContainer(data.data);
                // 页码加一
                pageNumber = pageNumber +1;
            }else if (pageNumber == 1 &&  !data.data.length > 0){
                // 加载提示图片
                $('#timelineContainer').html('<br/><br/><br/><br/><br/><br/><br/><image src="/static/images/no-record.png" style="margin-left: 33%;width: 33%;"></image>');
            }
        }
    })
}
var base = new Base64();
/*渲染想法列表*/
function renderTimelineContainer(data) {
    if(data.length > 0){
        if(data.length < 10){
            continueLoad = false;
        }
        $('#lastId-flag-true').attr('id','lastId-flag-true-temp');
        var artElement = '';
        for(var i = 0; i < data.length; i++){
            var lastIdFlag = i == (data.length-1);
            artElement +=  "<div id='lastId-flag-"+lastIdFlag+"' class='col-lg-4 col-md-3 col-sm-4'>" +
                "<a data-id='"+data[i].id+"' class='article-detail' href='/timelineInfo/detail/"+base.encode(data[i].id)+"' target='_blank'><img src="+ ((data[i].images == '' || data[i].images == undefined) ? "/static/images/1.png" : data[i].images) +" title='' alt=''></a>" +
                "<div class='art-info'>"+
                "<h4><a data-id='"+data[i].id+"' class='article-detail' href='/timelineInfo/detail/"+base.encode(data[i].id)+"'>"+data[i].topic+"</a></h4>" +
                "<small>"+data[i].topic+"</small>" +
                "</div>" +
                "<div class='art-fields'>" +
                "<i class='fa fa-list-ul'></i>&nbsp;<span>"+data[i].topic+"</span>" +
                "</div>" +
                "<div class='art-stars'>" +
                "<i class='fa fa-eye'></i> <span class='eye'>&nbsp;"+(data[i].scanNumber == null ? 0 : data[i].scanNumber)+"</span>" +
                "<i class='fa fa-heart'></i> <span class='star'>&nbsp;"+(data[i].likeNumber == null ? 0 : data[i].likeNumber)+"</span> " +
                "<div class='art-author'>" +
                "<a data-id='"+data[i].userId+"' class='article-author' href='javascript:void(0)' data-toggle='tooltip' data-placement='top' data-original-title= "+data[i].author +" data-container='#article'><i class='fa fa-user-secret'></i> </a>" +
                "</div>" +
                "</div>" +
                "</div>";
        }
        if(pageNumber == 1){
            $('#timelineContainer').append(artElement);
        }else{
            $('#lastId-flag-true-temp').after(artElement);
        }
        loadLock = true;
    }
}

/*绑定滚屏*/
function bindScroll() {
    var scrollTop = 0;
    $(window).scroll(function () {
        var nowScrollTop = $(document).scrollTop();
        if (nowScrollTop > scrollTop) {
            $('.wrap').addClass('hide-wrap');
        } else {
            $('.wrap').removeClass('hide-wrap');
        }
    });
    $(window).scroll(function () {
        // 当前滚动条top值
        var wScrollY = window.scrollY;
        // 设备窗口的高度
        var wInnerH = window.innerHeight;
        // body总高度
        var bScrollH = document.body.scrollHeight;
        if (wScrollY + wInnerH >= bScrollH && continueLoad && loadLock) {
            loadTimelineContainer(pageNumber);
        }
        if(!continueLoad){
            // alert('暂无更多文章!');
        }
    });
}
/* 初始化碳层并绑定元素*/
function initPopLayer() {
    layui.use('layer', function(){
        var $ = layui.jquery, layer = layui.layer;
        //触发事件
        var active = {
            setTop: function(){
                var that = this;
                layer.open({
                    type: 1 // 2 是加载  iframe举例
                    ,title: '写想法'
                    ,area: ['400px', '500px']
                    ,shade: 0.1
                    ,maxmin: true
                    // ,offset: [ //为了演示，随机坐标
                    //     Math.random()*($(window).height()-300)
                    //     ,Math.random()*($(window).width()-390)
                    // ]
                    ,offset: [
                        ($(window).height()>800 ? $(window).height()/3 : ($(window).height()> 400? 140: 40))
                        ,($(window).width()>800 ? $(window).width()/3 : 30)
                    ]
                    ,content:
                        '<form>' +
                        '    <div style="margin-left: 15px;">\n' +
                        '       <table class="user-center-tab">\n' +
                        '           <tr>\n' +
                        '               <td>\n' +
                        '                   话题 : \n' +
                        '               </td>\n' +
                        '               <td>\n' +
                        '                   <input type="text" maxlength="63" name="topic" autocomplete="off" class="write-timeline-topic" placeholder="#话题" id="topic" />\n' +
                        '               </td>\n' +
                        '           </tr>\n' +
                        '           <tr>\n' +
                        '               <td>\n' +
                        '                   内容 :'+
                        '               </td>\n' +
                        '               <td>\n' +
                        '                   <textarea type="text" maxlength="180" name="content" autocomplete="off" class="write-timeline-content" placeholder="请输入内容" id="content"></textarea>\n' +
                        '               </td>\n' +
                        '           </tr>\n' +
                        '       </table>\n' +
                        '    </div>' +
                        '    <div class="layui-upload">\n' +
                        '        <button type="button" class="layui-btn layui-btn-small" style="margin-left: 14px;" id="uploadImages">多图上传</button><span style="color: red">最多9张,已上传 : </span><span id="upCount"> 0</span> <span style="color: red">张</span>\n' +
                        '            <blockquote class="layui-elem-quote layui-quote-nm buukle-upload-review" style="margin-top: 10px;font-size: 14px;float: left;">\n' +
                        '            预览图：\n' +
                        '            <div class="" id="demo2"></div>\n' +
                        '        </blockquote>\n' +
                        '    </div>'+
                        '    <script> ' +
                        '        initUpload() ' +
                        '    </script>'+
                        '</form>'
                    ,btn: ['发表', '取消']
                    ,btn1: function(){
                        alert("publish");
                    }
                    ,btn2: function(){
                        // exit default
                    }
                    ,zIndex: 9
                });
            }
            ,offset: function(othis){
                var type = othis.data('type')
                    ,text = othis.text();

                layer.open({
                    type: 1
                    ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    ,id: 'layerDemo'+type //防止重复弹出
                    ,content: '<div style="padding: 20px 100px;">'+ text +'</div>'
                    ,btn: '关闭全部'
                    ,btnAlign: 'c' //按钮居中
                    ,shade: 0 //不显示遮罩
                    ,yes: function(){
                        layer.closeAll();
                    }
                });
            }
        };
        $('#writeTimeline').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });
}
var uploadCount = 0;
/*初始化上传*/
function initUpload() {
    function reInitParams() {
        uploadCount = 0;
        releaseThis($('#uploadImages'),'多图上传');
        $('#upCount').html(uploadCount);
    }
    reInitParams();
    layui.use('upload', function(){
        var $ = layui.jquery,upload = layui.upload;
        //多图片上传
        upload.render({
            elem: '#uploadImages'
            ,url: '/upload/uploadImage'
            ,multiple: true
            ,before: function(obj){
                if(uploadCount <= 8){
                    banThis($('#uploadImages'),'上传中..');
                    banThis($('.layui-layer-btn0'),'上传中..');
                }else{
                    alert("最多上传" + uploadCount + "张图片!")
                    return;
                }
            }
            ,done: function(res){
                //x上限，y下限
                var id = parseInt(Math.random() * (1000000 + 1) +'');
                $('#demo2').append(
                    '<div id="imagePreviewID-'+id+'" class="buukle-timeline-image-preview">' +
                    '    <img class="buukle-timeline-image" src="'+ res.msg +'" class="layui-upload-img">' +
                    '    <div class="layui-progress" style="margin-top: 117px;">\n' +
                    '      <div class="layui-progress-bar layui-bg-green" id="processBar-'+id+'"></div>\n' +
                    '      <span id="imageDeleteID-'+id+'" data-index='+id+' class="buukle-timeline-upDelete"> <a href="javascript:void(0)"> 删除</a> </span>' +
                    '      <input type="hidden" id="imageUrlID-'+id+'" name="images" />\n' +
                    '    </div>' +
                    '</div>')
                // 绑定删除
                bindDeleteCall();
                uploadCount ++;
                $('#processBar-' + (id)).css('width',"100%");
                $('#imageUrlID-' + (id)).val(res.msg);
                releaseThis($('#uploadImages'),'继续上传');
                releaseThis($('.layui-layer-btn0'),'发表');
                $('#upCount').html(uploadCount);
                if(uploadCount == 9){
                    banThis($('#uploadImages'),'最多9张');
                }
            }
        });
    });
}
/*绑定删除*/
function bindDeleteCall() {
    $('.buukle-timeline-upDelete').off().on('click',function () {
        banThis($('#uploadImages'),'删除中..');
        $('#imagePreviewID-' +$(this).attr('data-index')).remove();
        uploadCount --;
        $('#upCount').html(uploadCount);
        releaseThis($('#uploadImages'),'继续上传');
    })
}

