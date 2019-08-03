/**
 * Created by elvin
 */

$('[data-toggle="tooltip"]').tooltip();
// 提示代码

$('body').on('mouseover','.art-author a', function(e){
    if(e.type == 'mouseover'){
        $(this).tooltip();
    }
});


$('.wrap-cont a').hover(function () {
    $(this).addClass('hover');
}, function () {
    $(this).removeClass('hover');
});


//全局ajax方法 传入参数 url 地址; data以对象的方式传入 例如： var data = {id: '14', name: 'hello,world'};
function mainAjax(url,data){
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data: data,
        success: function(data){
            return data;
        },
        error: function(data){
            return data;
        }
    });
}

$('a.pl-callback').click(function(){
    $(this).parent().siblings('.callback-txt').show();
});

$('a.qx').click(function(){
    $(this).parent().hide();
});

function banThis(obj,text){
    obj.attr('disabled',true);
    obj.html(text);
}
function releaseThis(obj,text){
    obj.attr('disabled',false);
    obj.html(text);
}