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
    // 加载首页最新文章
    loadArticleContainer(1,null);
    // 处理排序
    handleOrderFlag();
    // 绑定写文章按钮
    bindWhiteClick();
});

/*绑定写文章按钮*/
function bindWhiteClick() {
    // 绑定新增文章
    $('#writeArticle').off().on('click',function () {
        window.open('http://www.buukle.top/articleInfo/toAddArticle','_blank');
    });
    // 绑定新增想法
    $('#writeTimeline').off().on('click',function () {
        window.open('http://timeline.buukle.top/timelineInfo/square?operation=add','_blank');
    });
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
        $('#currentArticleOrder').html($(this).attr('data-txt'));
        $('#articleContainer').html("");
        // 重新初始化触底加载参数
        initScrollParam();
        // 执行触底加载
        loadArticleContainer(1,$('#articleCat').val());
    });
}