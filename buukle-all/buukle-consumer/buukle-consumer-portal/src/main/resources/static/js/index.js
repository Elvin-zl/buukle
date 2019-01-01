/**
 * Created by elvin
 */
$(function(){
    // 加载首页最新文章
    loadArticleContainer(1,null);
    // 处理排序
    handleOrderFlag();
})

/*处理排序*/
function handleOrderFlag() {
    $('.order-item').off().on('click',function () {
        $('#orderFlag').val($(this).attr('data-type'));
        $('.order-item').removeClass('order-active');
        $(this).addClass('order-active');
        $('#currentArticleOrder').html($(this).attr('data-txt'));
        loadArticleContainer(1,$('#articleCat').val());
    });
}



