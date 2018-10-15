/**
 * @name    Navbar
 * @author  SuChiZhu
 * @version 1.0.0
*/

layui.define(['element','layer','laytpl'],function(exports){
    var element = layui.element,
        $       = layui.jquery,
        layer   = layui.layer,
        laytpl  = layui.laytpl,
        Navbar  = function(){
            this.v = "1.0.0",
            this.renderConfig = {
                elem : '.layui-nav',
                filter : 'navbar',
                data : []
            },
            this.initConfig = {
                navFilter : 'nav(side)',
                filter : 'content',
                reload : '.layui-reload',
                closeAllTab : '.layui-close-alltab',
                closeOtherTab : '.layui-close-othertab'
            }
        };
    
    // 导航渲染
    Navbar.prototype.render = function(options){
        var that = this;
        $.extend(that.renderConfig, options); 
        var tpl = [
            "{{# layui.each(d.data,function(index,item){ }}",
            "<li class='layui-nav-item {{item.class||''}}' {{item.layId?'lay-id='+item.layId:''}}><a href='javascript:;'>",
            "{{# if(item.icon){ }}",
            "<i class='fa {{item.icon}}'></i>",
            "{{# if(item.title){ }}",
            "<cite>{{item.title||''}}</cite>",
            "{{# } }}",
            "{{# if(item.badgeTitle){ }}",
            "<span class='layui-badge {{item.badge||''}}'>{{item.badgeTitle}}</span>",
            "{{# } }}",
            "{{# }else{ }}",
            "{{item.title||''}}",
            "{{# if(item.badgeTitle){ }}",
            "<span class='layui-badge {{item.badge||''}}'>{{item.badgeTitle}}</span>",
            "{{# } }}",
            "{{# } }}",
            "{{#  }}",
            "</a>",
            "{{# if(item.children){ }}",
            "<dl class='layui-nav-child'>",
            "{{# layui.each(item.children,function(index,item){ }}",
            "<dd {{item.layTheme?'lay-theme='+item.layTheme:''}} {{item.layId?'lay-id='+item.layId:''}} {{item.layUrl?'lay-url='+item.layUrl:''}}><a class='buukle-privateSet-theme' href='javascript:;'>",
            "{{# if(item.icon){ }}",
            "<i class='fa {{item.icon}}'></i>",
            "<cite>{{item.title}}</cite>",
            "{{# }else{ }}",
            "{{item.title}}",
            "{{# } }}",
            "</a></dd>",
            "{{# }); }}",
            "</dl>",
            "{{# } }}",
            "</li>",
            "{{# }) }}"
        ];
        laytpl(tpl.join("")).render(that.renderConfig,function(html){
            $(that.renderConfig.elem+"[lay-filter="+that.renderConfig.filter+"]").html(html);
        });
        element.init();
    };

    // 监听导航点击:选项卡添加并切换
    Navbar.prototype.tabAddChange = function(options){
        element.on(options.navFilter,function(elem){
            //判断主题是否为保存
            if($('#currentDBTheme').val().length > 0 && $('#currentDBTheme').val() != $('#tempTheme').val()){
                swal({
                        title: "你还未保存选定的主题！",
                        text: "点击离开会使用之前的主题,点击取消继续编辑~",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "离开",
                        cancelButtonText: "取消",
                        closeOnConfirm: false,
                        closeOnCancel: false
                    },
                    function(isConfirm){
                        if (isConfirm) {
                            $('#tempTheme').val($('#currentDBTheme').val());
                            swal.close();
                            gotoNavMain(elem);
                        } else {
                            swal.close();
                            return false;
                        }
                    });
            }else{
                gotoNavMain(elem);
            }
        });
        function gotoNavMain(elem) {
            //获取该选项卡菜单按钮组并加载到父页面隐藏域
            getButtons($(elem).attr('lay-id'));
            var config = {
                title : $(elem).text(),
                url   : $(elem).attr('lay-url'),
                id    : $(elem).attr('lay-id')
            };
            var tabCount = navbar.getTabCount(options.filter);
            if(navbar.isExist(options.filter,config.id) == -1 && tabCount < 10){
                element.tabAdd(options.filter,{
                    title: config.title,
                    id: config.id,
                    content: '<iframe src="' + config.url + '"></iframe>'
                });
                element.tabChange(options.filter,config.id);
            }else if(navbar.isExist(options.filter,config.id) == -1 && tabCount >= 10){
                layer.msg('选项卡太多啦,请关闭几个哦!',{icon: 5});
            }else{
                element.tabChange(options.filter,config.id);
                var src = $('.layui-tab-content .layui-show').children('iframe').attr('src');
                $('.layui-tab-content .layui-show').children('iframe').attr('src',src);
            }
            $(".layui-nav dl").removeClass("layui-show");
            $(".layui-nav dl dd").removeClass("layui-this");
            $(elem).addClass('layui-this');
            var tabFilter = 'tab('+options.filter+')';
            navbar.clickActive(tabFilter);
        }
    };

    // 监听选项卡点击:切换侧边栏当前选中项状态
    Navbar.prototype.clickActive = function(tabFilter){
        element.on(tabFilter,function(data){
            var id = $(this).attr('lay-id');
            var src = $('.layui-tab-content .layui-show').children('iframe').attr('src');
            $('.layui-tab-content .layui-show').children('iframe').attr('src',src);
            $(document).find(".layui-nav-tree dd").each(function(index,item){
                $(item).removeClass('layui-this');
                if($(item).attr('lay-id') == id)
                {
                    $(item).addClass('layui-this');
                }
            });
            $(document).find(".layui-nav-tree li").each(function(index,item){
                $(item).removeClass('layui-this').removeClass('layui-nav-itemed');
                layui.each($(item).find('dd'),function(){
                    if($(this).attr('lay-id') == id){
                        $(item).addClass('layui-nav-itemed');
                    }
                });
                if($(item).find("dl").length < 1){
                    if($(item).attr('lay-id') == id)
                    {
                        $(item).addClass('layui-this');
                    }
                }
            });
        });
    };

    // 选项卡是否存在
    Navbar.prototype.isExist = function(filter,id){
        var flag = -1, arr = [];
        $(document).find(".layui-tab[lay-filter="+filter+"] ul li").each(function(index){
            arr[index] = $(this).attr('lay-id');
        });
        flag = $.inArray(id, arr);
        return flag;
    };

    // 获取当前动态选项卡数量
    Navbar.prototype.getTabCount = function(filter){
        return $(document).find(".layui-tab[lay-filter="+filter+"] ul li").length-1;
    };

    // 关闭其他选项卡
    Navbar.prototype.closeOtherTab = function(elem,filter){
        $(elem).on('click',function(){
            var count = navbar.getTabCount(filter);
            var tab = $(document).find(".layui-tab ul[class=layui-tab-title] li"); 
            $(tab).each(function(index,item){
                if(!($(item).attr("lay-id")==undefined || $(item).attr("class")=="layui-this"))
                {
                    element.tabDelete(filter,$(item).attr("lay-id"));
                }
            });
            if(count <= 2){

            }
            $(".page-operat dl").removeClass("layui-show");
        });
    };

    // 关闭所有选项卡
    Navbar.prototype.closeAllTab = function(elem,filter){
        $(elem).on("click",function(){
            var count = navbar.getTabCount(filter);
            var tab = $(document).find(".layui-tab ul[class=layui-tab-title] li"); 
            $(tab).each(function(index,item){
                if($(item).attr("lay-id")!=undefined)
                {
                    element.tabDelete(filter,$(item).attr("lay-id"));
                }
            });
            if(count <= 1){

            }
            $(".page-operat dl").removeClass("layui-show");
        });  
    };

    // 刷新选项卡页面
    Navbar.prototype.reload = function(elem){
        $(elem).on('click',function(){
            var src = $('.layui-tab-content .layui-show').children('iframe').attr('src');
            $('.layui-tab-content .layui-show').children('iframe').attr('src',src);
            $(".page-operat dl").removeClass("layui-show");
        });
    };

    // 导航收缩
    Navbar.prototype.shrink = function(){
        $(".layui-shrink-sidebar").on('click',function(){
            if($(".layui-side").width() == 200){
                $(".layui-side").addClass("layui-side-min");
                $(".layui-tab").addClass("layui-tab-max");
                $(".layui-side").find(".layui-nav").find("a").each(function(){
                    var tipIndex;
                    $(this).mouseenter(function () {
                        tipIndex = layer.tips($(this).find('cite').text(), this, { tips: [2, '#393D49'] });
                    });
                    $(this).mouseleave(function () {
                        layer.close(tipIndex);
                    });
                });
            }else{
                $(".layui-side").removeClass("layui-side-min");
                $(".layui-tab").removeClass("layui-tab-max");
                $('.layui-side').find('.layui-nav').find('a').each(function () {
                    $(this).unbind('mouseenter');
                    $(this).unbind('mouseleave');
                });
            }
        });
    };

    // 侧边导航栏的展开与收缩
    Navbar.prototype.text = function(){
        $(".layui-nav-tree li").on('click',function(){
           $(".layui-nav-tree li").removeClass("layui-nav-itemed");
           $(this).addClass("layui-nav-itemed"); 
        });
    };

    // 导航动态操作初始化
    Navbar.prototype.init = function(options){
        var that = this;
        $.extend(that.initConfig, options); 
        this.shrink();
        this.text();
        this.tabAddChange(that.initConfig);
        this.reload(that.initConfig.reload);
        this.closeAllTab(that.initConfig.closeAllTab,that.initConfig.filter);
        this.closeOtherTab(that.initConfig.closeOtherTab,that.initConfig.filter);
        this.tabAddChange({navFilter: 'nav(navbar)',filter:"content"});
    };
    var navbar = new Navbar();
    exports('navbar',navbar);
    // 获取当前选项卡按钮组并加载到隐藏域
    function getButtons(moduleId) {
        if($('#moduleIdForBtn').val() != ''){
            $.ajax({
                async:false,
                url:'/button/getModuleButtons/'+moduleId,
                dataType:'json',
                type:'post',
                success:function (data) {
                    //区分不同的按钮类型,分别处理
                    divideTheButton(data,moduleId);
                }
            });
        }
    }
    /*区分不同的按钮类型,分别处理*/
    function divideTheButton(data,moduleId) {
        var pageButtonArr = [];
        var tableButtonArr = [];
        for(var i = 0 ; i < data.length ; i++){
            if(data[i].buttonLayoutLevel == 0){
                // 将页面级按钮添加在缓存数组

                pageButtonArr.push(data[i]);
            }else{
                //将列表级按钮添加在缓存数组
                tableButtonArr.push(data[i]);
            }
        }
        // 字符串化页面级别按钮并缓存到隐藏域
        if($('#pageBtn-'+moduleId).length > 0){
            $('#pageBtn-'+moduleId).remove();
        }
        $('#hiddenResource').append('<input type="hidden" id="pageBtn-'+moduleId+'" value=\''+JSON.stringify(pageButtonArr)+'\'/>');
        //字符串化列表级别按钮并缓存到隐藏域
        if($('#tableBtn-'+moduleId).length > 0){
            $('#tableBtn-'+moduleId).remove();
        }
        $('#hiddenResource').append('<input type="hidden" id="tableBtn-'+moduleId+'" value=\''+JSON.stringify(tableButtonArr)+'\'/>');
    }
});