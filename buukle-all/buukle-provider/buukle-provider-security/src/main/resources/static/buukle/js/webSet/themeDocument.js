$(function () {
    /*初始化页面*/
    initPage();
    /*绑定切换主题*/
    $('#switchTheme').off().on('click',function () {
        if($(this).attr('data-theme-prepare') != ''){
            //切换主页面在用主题
            parent.$('#currentDBTheme').val($(this).attr('data-theme-prepare'));
            parent.$('#userTheme').val($(this).attr('data-theme-prepare'));
            //保存
            $.ajax({
                url:'/user/setUserTheme',
                type:'post',
                data:{'theme':$(this).attr('data-theme-prepare')},
                dataType:'json',
                success:function (data) {
                    layui.use('layer', function(){
                        var layer = layui.layer;
                        layer.msg(data.msg);

                    });
                }
            })
        }
    });
    /*点击事件*/
    var Elements = $(".buukle-panel-table");
    Elements.off().on('click',function () {
        var tableTh = $('.buukle-panel-table-th');
        tableTh.css('background-color','#f2f2f2');
        tableTh.removeClass('active-panel');
        tableTh.removeClass('theme-btn');
        $(this).find('th').css('background-color','#237871');
        $(this).find('th').addClass('active-panel');
        $(this).find('th').addClass('theme-btn');
        parent.$('#themeCss').attr('href',$('.active-panel').attr('data-theme-url'));
        $('#switchTheme').attr('data-theme-prepare',$('.active-panel').attr('data-theme-url'));
        parent.$('#tempTheme').val($('.active-panel').attr('data-theme-url'));
    })
});