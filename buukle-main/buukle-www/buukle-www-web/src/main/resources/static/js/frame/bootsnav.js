// ------------------------------------------------------------------------------ //
//
// Template name : Bootsnav - Multi Purpose Header
// Categorie : Bootstrap Menu in CSS
// Author : adamnurdin01
// Version : v.1.2
// Created : 2016-06-02
// Last update : 2016-10-19
//
// ------------------------------------------------------------------------------ //

(function ($) {
	"use strict";
    var bootsnav = {
        initialize: function() {
            this.event();
            this.hoverDropdown();
            this.navbarSticky();
            this.navbarScrollspy();
        },
        event : function(){
            
            // ------------------------------------------------------------------------------ //
            // Variable
            // ------------------------------------------------------------------------------ //
            var getNav = $("nav.navbar.bootsnav");
            
            // ------------------------------------------------------------------------------ //
            // Navbar Sticky 
            // ------------------------------------------------------------------------------ //
            var navSticky = getNav.hasClass("navbar-sticky");
            if( navSticky ){
                // Wraped navigation
                getNav.wrap("<div class='wrap-sticky'></div>");
            }   
            
            // ------------------------------------------------------------------------------ //
            // Navbar Center 
            // ------------------------------------------------------------------------------ //
            if( getNav.hasClass("brand-center")){                
                var postsArr = new Array(),
                    index = $("nav.brand-center"),
                    $postsList = index.find('ul.navbar-nav');
				
				index.prepend("<span class='storage-name' style='display:none;'></span>");
                
                //Create array of all posts in lists
                index.find('ul.navbar-nav > li').each(function(){
					if( $(this).hasClass("active") ){
						var getElement = $("a", this).eq(0).text();
						$(".storage-name").html(getElement);
					}
                    postsArr.push($(this).html());
                });
                
                //Split the array at this point. The original array is altered.
                var firstList = postsArr.splice(0, Math.round(postsArr.length / 2)),
                    secondList = postsArr,
                    ListHTML = '';
                
                var createHTML = function(list){
                    ListHTML = '';
                    for (var i = 0; i < list.length; i++) {
                        ListHTML += '<li>' + list[i] + '</li>'
                    }
                }
                
                //Generate HTML for first list
                createHTML(firstList);
                $postsList.html(ListHTML);
                index.find("ul.nav").first().addClass("navbar-left");
                
                //Generate HTML for second list
                createHTML(secondList);
                //Create new list after original one
                $postsList.after('<ul class="nav navbar-nav"></ul>').next().html(ListHTML);
                index.find("ul.nav").last().addClass("navbar-right");
                
                //Wrap navigation menu
                index.find("ul.nav.navbar-left").wrap("<div class='col-half left'></div>");
                index.find("ul.nav.navbar-right").wrap("<div class='col-half right'></div>");
                
                //Selection Class
                index.find('ul.navbar-nav > li').each(function(){ 
                    var dropDown = $("ul.dropdown-menu", this),
                        megaMenu = $("ul.megamenu-content", this);
                    dropDown.closest("li").addClass("dropdown");
                    megaMenu.closest("li").addClass("megamenu-fw");
                });
				
				var getName = $(".storage-name").html();
				if( !getName == ""  ){
					$( "ul.navbar-nav > li:contains('" + getName + "')" ).addClass("active");
				}		
            } 
            
            
            // ------------------------------------------------------------------------------ //
            // Navbar Sidebar 
            // ------------------------------------------------------------------------------ //
            if( getNav.hasClass("navbar-sidebar")){
                // Add Class to body
                $("body").addClass("wrap-nav-sidebar");
                getNav.wrapInner("<div class='scroller'></div>");
            }else{
                $(".bootsnav").addClass("on");
            }
            
            // ------------------------------------------------------------------------------ //
            // Menu Center 
            // ------------------------------------------------------------------------------ //
            if( getNav.find("ul.nav").hasClass("navbar-center")){
                getNav.addClass("menu-center");
            }
            
            // ------------------------------------------------------------------------------ //
            // Navbar Full
            // ------------------------------------------------------------------------------ //
            if( getNav.hasClass("navbar-full")){
                // Add Class to body
                $("nav.navbar.bootsnav").find("ul.nav").wrap("<div class='wrap-full-menu'></div>");
                $(".wrap-full-menu").wrap("<div class='nav-full'></div>");
                $("ul.nav.navbar-nav").prepend("<li class='close-full-menu'><a href='#'><i class='fa fa-times'></i></a></li>");
            }else if( getNav.hasClass("navbar-mobile")){
                getNav.removeClass("no-full");
            }else{
                getNav.addClass("no-full");
            }
                
            // ------------------------------------------------------------------------------ //
            // Navbar Mobile
            // ------------------------------------------------------------------------------ //
            if( getNav.hasClass("navbar-mobile")){
                // Add Class to body
                $('.navbar-collapse').on('shown.bs.collapse', function() {
                    $("body").addClass("side-right");
                });
                $('.navbar-collapse').on('hide.bs.collapse', function() {
                    $("body").removeClass("side-right");
                });
                
                $(window).on("resize", function(){
                    $("body").removeClass("side-right");
                });
            }
            
            // ------------------------------------------------------------------------------ //
            // Navbar Fixed
            // ------------------------------------------------------------------------------ //
            if( getNav.hasClass("no-background")){
                $(window).on("scroll", function(){
                    var scrollTop = $(window).scrollTop();
                    if(scrollTop >34){
                        $(".navbar-fixed").removeClass("no-background");
                    }else {
                        $(".navbar-fixed").addClass("no-background");
                    }
                });
            }
            
            // ------------------------------------------------------------------------------ //
            // Navbar Fixed
            // ------------------------------------------------------------------------------ //
            if( getNav.hasClass("navbar-transparent")){
                $(window).on("scroll", function(){
                    var scrollTop = $(window).scrollTop();
                    if(scrollTop >34){
                        $(".navbar-fixed").removeClass("navbar-transparent");
                    }else {
                        $(".navbar-fixed").addClass("navbar-transparent");
                    }
                });
            }
            
            // ------------------------------------------------------------------------------ //
            // Button Cart
            // ------------------------------------------------------------------------------ //
            $(".btn-cart").on("click", function(e){
                e.stopPropagation();
            });
            
            // ------------------------------------------------------------------------------ //
            // Toggle Search
            // ------------------------------------------------------------------------------ //
            $("nav.navbar.bootsnav .attr-nav").each(function(){  
                $("li.search > a", this).on("click", function(e){
                    e.preventDefault();
                    $(".top-search").slideToggle();
                });
            });
            $(".input-group-addon.close-search").on("click", function(){
                $(".top-search").slideUp();
            });
            
            // ------------------------------------------------------------------------------ //
            // Toggle Side Menu
            // ------------------------------------------------------------------------------ //
            $("nav.navbar.bootsnav .attr-nav").each(function(){  
                $("li.side-menu > a", this).on("click", function(e){
                    e.preventDefault();
                    $("nav.navbar.bootsnav > .side").toggleClass("on");
                    $("body").toggleClass("on-side");
                });
            });
            $(".side .close-side").on("click", function(e){
                e.preventDefault();
                $("nav.navbar.bootsnav > .side").removeClass("on");
                $("body").removeClass("on-side");
            });  
            
            
            
            // ------------------------------------------------------------------------------ //
            // Wrapper
            // ------------------------------------------------------------------------------ //
            $("body").wrapInner( "<div class='wrapper'></div>");
        }, 
        

        // ------------------------------------------------------------------------------ //
        // Change dropdown to hover on dekstop
        // ------------------------------------------------------------------------------ //
        hoverDropdown : function(){
            var getNav = $("nav.navbar.bootsnav"),
                getWindow = $(window).width(),
                getHeight = $(window).height(),
                getIn = getNav.find("ul.nav").data("in"),
                getOut = getNav.find("ul.nav").data("out");
            
            if( getWindow < 991 ){
                
                // Height of scroll navigation sidebar
                $(".scroller").css("height", "auto");
                
                // Disable mouseenter event
                $("nav.navbar.bootsnav ul.nav").find("li.dropdown").off("mouseenter");
                $("nav.navbar.bootsnav ul.nav").find("li.dropdown").off("mouseleave");
                $("nav.navbar.bootsnav ul.nav").find(".title").off("mouseenter"); 
                $("nav.navbar.bootsnav ul.nav").off("mouseleave");    
                $(".navbar-collapse").removeClass("animated");
                
                // Enable click event
                $("nav.navbar.bootsnav ul.nav").each(function(){
                    $(".dropdown-menu", this).addClass("animated");
                    $(".dropdown-menu", this).removeClass(getOut);
                    
                    // Dropdown Fade Toggle
                    $("a.dropdown-toggle", this).off('click');
                    $("a.dropdown-toggle", this).on('click', function (e) {
                        e.stopPropagation();
                        $(this).closest("li.dropdown").find(".dropdown-menu").first().stop().fadeToggle().toggleClass(getIn);
                        $(this).closest("li.dropdown").first().toggleClass("on");                        
                        return false;
                    });   
                    
                    // Hidden dropdown action
                    $('li.dropdown', this).each(function () {
                        $(this).find(".dropdown-menu").stop().fadeOut();
                        $(this).on('hidden.bs.dropdown', function () {
                            $(this).find(".dropdown-menu").stop().fadeOut();
                        });
                        return false;
                    });

                    // Megamenu style
                    $(".megamenu-fw", this).each(function(){
                        $(".col-menu", this).each(function(){
                            $(".content", this).addClass("animated");
                            $(".content", this).stop().fadeOut();
                            $(".title", this).off("click");
                            $(".title", this).on("click", function(){
                                $(this).closest(".col-menu").find(".content").stop().fadeToggle().addClass(getIn);
                                $(this).closest(".col-menu").toggleClass("on");
                                return false;
                            });

                            $(".content", this).on("click", function(e){
                                e.stopPropagation();
                            });
                        });
                    });  
                }); 
                
                // Hidden dropdown
                var cleanOpen = function(){
                    $('li.dropdown', this).removeClass("on");
                    $(".dropdown-menu", this).stop().fadeOut();
                    $(".dropdown-menu", this).removeClass(getIn);
                    $(".col-menu", this).removeClass("on");
                    $(".col-menu .content", this).stop().fadeOut();
                    $(".col-menu .content", this).removeClass(getIn);
                }
                
                // Hidden om mouse leave
                $("nav.navbar.bootsnav").on("mouseleave", function(){
                    cleanOpen();
                });
                
                // Enable click atribute navigation
                $("nav.navbar.bootsnav .attr-nav").each(function(){  
                    $(".dropdown-menu", this).removeClass("animated");
                    $("li.dropdown", this).off("mouseenter");
                    $("li.dropdown", this).off("mouseleave");                    
                    $("a.dropdown-toggle", this).off('click');
                    $("a.dropdown-toggle", this).on('click', function (e) {
                        e.stopPropagation();
                        $(this).closest("li.dropdown").find(".dropdown-menu").first().stop().fadeToggle();
                        $(".navbar-toggle").each(function(){
                            $(".fa", this).removeClass("fa-times");
                            $(".fa", this).addClass("fa-bars");
                            $(".navbar-collapse").removeClass("in");
                            $(".navbar-collapse").removeClass("on");
                        });
                    });
                    
                    $(this).on("mouseleave", function(){
                        $(".dropdown-menu", this).stop().fadeOut();
                        $("li.dropdown", this).removeClass("on");
                        return false;
                    });
                });
                
                // Toggle Bars
                $(".navbar-toggle").each(function(){
                    $(this).off("click");
                    $(this).on("click", function(){
                        $(".fa", this).toggleClass("fa-bars");
                        $(".fa", this).toggleClass("fa-times");
                        cleanOpen();
                    });
                });

            }else if( getWindow > 991 ){
                // Height of scroll navigation sidebar
                $(".scroller").css("height", getHeight + "px");
                
                // Navbar Sidebar
                if( getNav.hasClass("navbar-sidebar")){
                    // Hover effect Sidebar Menu
                    $("nav.navbar.bootsnav ul.nav").each(function(){  
                        $("a.dropdown-toggle", this).off('click');
                        $("a.dropdown-toggle", this).on('click', function (e) {
                            e.stopPropagation();
                        }); 

                        $(".dropdown-menu", this).addClass("animated");
                        $("li.dropdown", this).on("mouseenter", function(){
                            $(".dropdown-menu", this).eq(0).removeClass(getOut);
                            $(".dropdown-menu", this).eq(0).stop().fadeIn().addClass(getIn);
                            $(this).addClass("on");
                            return false;
                        });
                        
                        $(".col-menu").each(function(){
                            $(".content", this).addClass("animated");
                            $(".title", this).on("mouseenter", function(){
                                $(this).closest(".col-menu").find(".content").stop().fadeIn().addClass(getIn);
                                $(this).closest(".col-menu").addClass("on");
                                return false;
                            });
                        });
                        
                        $(this).on("mouseleave", function(){
                            $(".dropdown-menu", this).stop().removeClass(getIn);
                            $(".dropdown-menu", this).stop().addClass(getOut).fadeOut();
                            $(".col-menu", this).find(".content").stop().fadeOut().removeClass(getIn);
                            $(".col-menu", this).removeClass("on");
                            $("li.dropdown", this).removeClass("on");
                            return false;
                        });
                    }); 
                }else{
                    // Hover effect Default Menu
                    $("nav.navbar.bootsnav ul.nav").each(function(){  
                        $("a.dropdown-toggle", this).off('click');
                        $("a.dropdown-toggle", this).on('click', function (e) {
                            e.stopPropagation();
                        }); 

                        $(".megamenu-fw", this).each(function(){
                            $(".title", this).off("click");
                            $("a.dropdown-toggle", this).off("click");
                            $(".content").removeClass("animated");
                        });

                        $(".dropdown-menu", this).addClass("animated");
                        $("li.dropdown", this).on("mouseenter", function(){
                            $(".dropdown-menu", this).eq(0).removeClass(getOut);
                            $(".dropdown-menu", this).eq(0).stop().fadeIn().addClass(getIn);
                            $(this).addClass("on");
                            return false;
                        });

                        $("li.dropdown", this).on("mouseleave", function(){
                            $(".dropdown-menu", this).eq(0).removeClass(getIn);
                            $(".dropdown-menu", this).eq(0).stop().fadeOut().addClass(getOut);
                            $(this).removeClass("on");
                        });

                        $(this).on("mouseleave", function(){
                            $(".dropdown-menu", this).removeClass(getIn);
                            $(".dropdown-menu", this).eq(0).stop().fadeOut().addClass(getOut);
                            $("li.dropdown", this).removeClass("on");
                            return false;
                        });
                    });
                }
                
                // ------------------------------------------------------------------------------ //
                // Hover effect Atribute Navigation
                // ------------------------------------------------------------------------------ //
                $("nav.navbar.bootsnav .attr-nav").each(function(){                      
                    $("a.dropdown-toggle", this).off('click');
                    $("a.dropdown-toggle", this).on('click', function (e) {
                        e.stopPropagation();
                    }); 
                    
                    $(".dropdown-menu", this).addClass("animated");
                    $("li.dropdown", this).on("mouseenter", function(){
                        $(".dropdown-menu", this).eq(0).removeClass(getOut);
                        $(".dropdown-menu", this).eq(0).stop().fadeIn().addClass(getIn);
                        $(this).addClass("on");
                        return false;
                    });

                    $("li.dropdown", this).on("mouseleave", function(){
                        $(".dropdown-menu", this).eq(0).removeClass(getIn);
                        $(".dropdown-menu", this).eq(0).stop().fadeOut().addClass(getOut);
                        $(this).removeClass("on");
                    });

                    $(this).on("mouseleave", function(){
                        $(".dropdown-menu", this).removeClass(getIn);
                        $(".dropdown-menu", this).eq(0).stop().fadeOut().addClass(getOut);
                        $("li.dropdown", this).removeClass("on");
                        return false;
                    });
                });
            }
            
            // ------------------------------------------------------------------------------ //
            // Menu Fullscreen
            // ------------------------------------------------------------------------------ //
            if( getNav.hasClass("navbar-full")){
                var windowHeight = $(window).height(),
                    windowWidth =  $(window).width();

                $(".nav-full").css("height", windowHeight + "px");
                $(".wrap-full-menu").css("height", windowHeight + "px");
                $(".wrap-full-menu").css("width", windowWidth + "px");
                
                $(".navbar-collapse").addClass("animated");
                $(".navbar-toggle").each(function(){
                    var getId = $(this).data("target");
                    $(this).off("click");
                    $(this).on("click", function(e){
                        e.preventDefault();
                        $(getId).removeClass(getOut);
                        $(getId).addClass("in");
                        $(getId).addClass(getIn);
                        return false;
                    });
                    
                    $("li.close-full-menu").on("click", function(e){
                        e.preventDefault();
                        $(getId).addClass(getOut);
                        setTimeout(function(){
                            $(getId).removeClass("in");
                            $(getId).removeClass(getIn);
                        }, 500);
                        return false;
                    });
                });
            }
        },
        
        // ------------------------------------------------------------------------------ //
        // Navbar Sticky
        // ------------------------------------------------------------------------------ //
        navbarSticky : function(){  
            var getNav = $("nav.navbar.bootsnav"),
                navSticky = getNav.hasClass("navbar-sticky");
            
            if( navSticky ){
                
                // Set Height Navigation
                var getHeight = getNav.height();             
                $(".wrap-sticky").height(getHeight);
                
                // Windown on scroll
                var getOffset = $(".wrap-sticky").offset().top;
                $(window).on("scroll", function(){  
                    var scrollTop = $(window).scrollTop();
                    if(scrollTop > getOffset){
                        getNav.addClass("sticked");
                    }else {
                        getNav.removeClass("sticked");
                    }
                });
            }   
        },
        
        // ------------------------------------------------------------------------------ //
        // Navbar Scrollspy
        // ------------------------------------------------------------------------------ //
        navbarScrollspy : function(){ 
            var navScrollSpy = $(".navbar-scrollspy"),
                $body   = $('body'), 
                getNav = $('nav.navbar.bootsnav'),
                offset  = getNav.outerHeight();
            
            if( navScrollSpy.length ){
                $body.scrollspy({target: '.navbar', offset: offset });
                
                // Animation Scrollspy
                $('.scroll').on('click', function(event) {
                    event.preventDefault();

                    // Active link
                    $('.scroll').removeClass("active");
                    $(this).addClass("active");

                    // Remove navbar collapse
                    $(".navbar-collapse").removeClass("in");

                    // Toggle Bars
                    $(".navbar-toggle").each(function(){
                        $(".fa", this).removeClass("fa-times");
                        $(".fa", this).addClass("fa-bars");
                    });

                    // Scroll
                    var scrollTop = $(window).scrollTop(),
                        $anchor = $(this).find('a'),
                        $section = $($anchor.attr('href')).offset().top,
                        $window = $(window).width(),
                        $minusDesktop = getNav.data("minus-value-desktop"),
                        $minusMobile = getNav.data("minus-value-mobile"),
                        $speed = getNav.data("speed");
                    
                    if( $window > 992 ){
                        var $position = $section - $minusDesktop;
                    }else{
                        var $position = $section - $minusMobile;
                    }             
                        
                    $('html, body').stop().animate({
                        scrollTop: $position
                    }, $speed);
                });
                
                // Activate Navigation
                var fixSpy = function() {
                    var data = $body.data('bs.scrollspy');
                    if (data) {
                        offset = getNav.outerHeight();
                        data.options.offset = offset;
                        $body.data('bs.scrollspy', data);
                        $body.scrollspy('refresh');
                    }
                }
                
                // Activate Navigation on resize
                var resizeTimer;
                $(window).on('resize', function() {
                    clearTimeout(resizeTimer);
                    var resizeTimer = setTimeout(fixSpy, 200);
                });
            }
        }
    };
    // Reset on resize
    $(window).on("resize", function(){
        bootsnav.hoverDropdown();
        setTimeout(function(){
            bootsnav.navbarSticky();
        }, 500);

        // Toggle Bars
        $(".navbar-toggle").each(function(){
            $(".fa", this).removeClass("fa-times");
            $(".fa", this).addClass("fa-bars");
            $(this).removeClass("fixed");
        });
        $(".navbar-collapse").removeClass("in");
        $(".navbar-collapse").removeClass("on");
        $(".navbar-collapse").removeClass("bounceIn");
    });

    //加载分类导航
    $.ajax({
        url : '/articleCat/getArticleCatTree',
        data : '',
        dataType : 'json',
        method : '',
        success : function(data){
            //渲染分类导航
            renderNavigation(data);
            /*渲染分类导航*/
            function renderNavigation(data) {
                //渲染一级导航
                for(var i = 0;i < data.length; i ++){
                    if(data[i].pid == 0 && data[i].children.length > 0){
                        $('#navigation').append(
                            '<li class="dropdown article-nav-li">' +
                            '<a  data-id="'+data[i].id+'" data-name="'+data[i].name+'" href="javascript:void(0)" class="dropdown-toggle article-cat" data-toggle="dropdown">'+data[i].name+'</a>'+
                            '<ul id="ulId'+data[i].id+'" class="dropdown-menu"></ul>' +
                            '</li>');
                        //渲染下级导航
                        renderSubNavigation(data[i].id,data[i].children);
                    }else if(data[i].pid == 0){
                        $('#navigation').append('<li class="article-nav-li"><a data-id="'+data[i].id+'" data-name="'+data[i].name+'" href="javascript:void(0)" class="article-cat">'+data[i].name+'</a></li>');
                    }
                }

                /*渲染下级导航*/
                function renderSubNavigation(id,data) {
                    for(var i = 0;i < data.length; i ++){
                        if(data[i].children != null && data[i].children.length > 0){
                            $('#ulId'+id).append(
                                '<li class="dropdown article-nav-li">' +
                                '<a  data-id="'+data[i].id+'" data-name="'+data[i].name+'" href="javascript:void(0)" class="dropdown-toggle article-cat" data-toggle="dropdown">'+data[i].name+'</a>'+
                                '<ul id="ulId'+data[i].id+'" class="dropdown-menu"></ul>' +
                                '</li>');
                            renderSubNavigation(data[i].id,data[i].children);
                        }else{
                            $('#ulId'+id).append('<li class="article-nav-li"><a data-id="'+data[i].id+'" data-name="'+data[i].name+'" href="javascript:void(0)" class="article-cat">'+data[i].name+'</a></li>');
                        }
                    }
                }
                bootsnav.initialize();
                //绑定文章导航点击事件
                bindArticleCatClick();
            }
        }
    })
    //绑定文章导航点击事件
    function bindArticleCatClick() {
        //绑定文章append 事件
        $('.article-cat').click(function (){
            $('#articleCat').val($(this).attr('data-id'));
            $('.article-nav-li').removeClass('article-nav-li-active');
            function activeArticleNav(obj) {
                obj.parent().addClass('article-nav-li-active');
                var parentCat = obj.parent().parent().prev();
                if(parentCat.attr('data-id') != ''  && parentCat.attr('data-id') != undefined){
                    activeArticleNav(parentCat);
                }
            }

            activeArticleNav($(this));
            var name =  '';
            function findArticleCatChain(obj) {
                name = name +" ‹‹ "+ $(obj).attr('data-name');
                var parentCat = obj.parent().parent().prev();
                if(parentCat.attr('data-id') != ''  && parentCat.attr('data-id') != undefined){
                    findArticleCatChain(parentCat);
                }
            }
            findArticleCatChain($(this));
            $('#articleCatName').val(name);
            // 初始化触底加载参数
            initScrollParam();
            // 加载分类下的文章(初始化为第一页)
            loadArticleContainer(1,$(this).attr('data-id'));
        });
    }

}(jQuery));

/*声明触底加载变量*/
var articleCatId;
var pageNumber ;
var continueLoad ;
var loadLock ;

/*初始化触底加载变量*/
function initScrollParam(){
    pageNumber = 1;
    continueLoad = true;
    loadLock = true;
    $('#articleContainer').html("");
}
/*加载分类下的文章*/
function loadArticleContainer(page,tempId) {
    articleCatId = tempId;
    loadLock = false;
    $.ajax({
        url : '/articleInfo/getArticleInfoList',
        data : {"articleCatId" : tempId,"page" : page,"limit" : 12,"orderFlag" :$('#orderFlag').val()},
        dataType : 'json',
        method : 'post',
        success : function (data) {
            var html = "";
            if($('#articleCatName').val() == '' || $('#articleCatName').val() == null){
                html = html + "所有";
            }else{
                html = html + $('#articleCatName').val();
            }
            $('#currentArticleCat').html(html);
            if(data.data.length > 0){
                // 渲染文章列表
                renderArticleContainer(data.data);
                // 页码加一
                pageNumber = pageNumber +1;
            }else if (pageNumber == 1 &&  !data.data.length > 0){
                // 加载提示图片
                $('#articleContainer').html('<br/><br/><br/><br/><br/><br/><br/><image src="/static/images/no-record.png" style="margin-left: 33%;width: 33%;"></image>');
            }
        }
    })
}
var base = new Base64();
/*渲染文章列表*/
function renderArticleContainer(data) {
    if(data.length > 0){
        if(data.length < 12){
            continueLoad = false;
        }
        $('#lastId-flag-true').attr('id','lastId-flag-true-temp');
        var artElement = '';
        for(var i = 0; i < data.length; i++){
            var lastIdFlag = i == (data.length-1);
            artElement +=  "<div id='lastId-flag-"+lastIdFlag+"' class='col-lg-4 col-md-3 col-sm-4'>" +
                "<a data-id='"+data[i].articleInfo.id+"' class='article-detail' href='articleInfo/detail/"+base.encode(data[i].articleInfo.id)+"' target='_blank'><img src="+ ((data[i].articleInfo.images == '' || data[i].articleInfo.images == undefined) ? "/static/images/1.png" : data[i].articleInfo.images) +" title='' alt=''></a>" +
                "<div class='art-info'>"+
                "<h4><a data-id='"+data[i].articleInfo.id+"' class='article-detail' href='articleInfo/detail/"+base.encode(data[i].articleInfo.id)+"' "+data[i].articleInfo.id+">"+data[i].articleInfo.title+"</a></h4>" +
                "<small>"+data[i].articleDesc+"</small>" +
                "</div>" +
                "<div class='art-fields'>" +
                "<i class='fa fa-list-ul'></i>&nbsp;<span>"+data[i].articleCat.articleCat+"</span>" +
                "</div>" +
                "<div class='art-stars'>" +
                "<i class='fa fa-eye'></i> <span class='eye'>&nbsp;"+(data[i].articleInfo.bak01 == null ? 0 : data[i].articleInfo.bak01)+"</span>" +
                "<i class='fa fa-heart'></i> <span class='star'>&nbsp;"+(data[i].articleInfo.likeNumber == null ? 0 : data[i].articleInfo.likeNumber)+"</span> " +
                "<div class='art-author'>" +
                "<a data-id='"+data[i].articleInfo.userId+"' class='article-author' href='javascript:void(0)' data-toggle='tooltip' data-placement='top' data-original-title= "+data[i].articleInfo.articleAuthor +" data-container='#article'><i class='fa fa-user-secret'></i> </a>" +
                "</div>" +
                "</div>" +
                "</div>";
        }
        if(pageNumber == 1){
            $('#articleContainer').append(artElement);
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
            loadArticleContainer(pageNumber,articleCatId);
        }
        if(!continueLoad){
            // alert('暂无更多文章!');
        }
    });
}
