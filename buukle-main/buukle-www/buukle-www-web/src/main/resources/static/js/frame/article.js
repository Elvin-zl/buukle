// create by 曾荣 

$('.pl-sub').click(function(){
	var val = $('#pl-text').val();
	$(this).parent().find('.false').fadeIn();
        setTimeout(function () {
            $('.false').fadeOut()
        }, 3500);

	if(val == ''){
		$(this).parent().find('.false span').html('评论内容不能为空哦');
	}
});