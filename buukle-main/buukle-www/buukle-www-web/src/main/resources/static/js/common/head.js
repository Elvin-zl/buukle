//@ sourceURL=head.js
$(function(){
    // 加载用户登录信息
    loadUserInfo();
    // 设置主导航active
    activeMainNavigation();
})
/* 加载用户登录信息*/
function loadUserInfo() {
    $.ajax({
        url : '/security/getUserInfo',
        method : 'post',
        dataType : 'json',
        success : function(data){
            if(data.userId == "-1"){
                $('#offlineInfo').html('注册/登录');
                $('#register').attr('href','/login.html');
                $('#online').hide();
                $('#offline').show();
                // 清空用户隐藏信息
                clearUserInfo();
            }else{
                $('#userInfo').html(data.username);
                // 渲染用户隐藏信息
                renderUserInfo(data);
                // 绑定登出事件
                bindLogoutClick();
                $('#offline').hide();
                $('#online').show();
            }
        }
    })
}
/*渲染用户隐藏信息*/
function renderUserInfo(data) {
    $('#userIdHead').val(data.userId);
    $('#salesmanIdHead').val(data.salesmanId);
    $('#groupIdHead').val(data.groupId);
    $('#agentIdHead').val(data.agentId);
    $('#platformIdHead').val(data.platformId);
    $('#userLevelHead').val(data.userLevel);
    $('#fansNumberhead').val(data.fansNumber);
    $('#slogenHead').val(data.slogen);
    $('#loginStrategyHead').val(data.loginStrategy);
    $('#themeHead').val(data.theme);
    $('#headImageUrlHead').val(data.headImageUrl);
    $('.user-username').html(data.username);
    $('.user-slogen').html((data.slogen == '' || data.slogen == null) ? '暂无签名~' : data.slogen);
    $('.user-headImg').attr('src',(data.headImageUrl == "" || data.headImageUrl == null) ? '/static/images/logo.png' : data.headImageUrl);
}
/*清空用户隐藏信息*/
function clearUserInfo() {
    $('#userIdHead').val('');
    $('#salesmanIdHead').val('');
    $('#groupIdHead').val('');
    $('#agentIdHead').val('');
    $('#platformIdHead').val('');
    $('#userLevelHead').val('');
    $('#fansNumberhead').val('');
    $('#slogenHead').val('');
    $('#loginStrategyHead').val('');
    $('#themeHead').val('');
    $('#headImageUrlHead').val('');
    $('.user-username').html('布壳儿');
    $('.user-slogen').html('热爱技术 · 热爱生活');
    $('.user-headImg').attr('src','/static/images/logo.png');
}
/*绑定登出事件*/
function bindLogoutClick() {
    $('#logout').off().on('click',function () {
        $.ajax({
            url : '/logout',
            method : 'post',
            dataType : 'json',
            success : function (data) {
                if(data.status=="S"){
                    location.href="http://www.buukle.top/login.html";
                }
            }
        })
    })
}

/*设置主导航active*/
function activeMainNavigation () {
    $('#idx'+ $('#mainNavActiveIndex').val()).addClass('main-nav-active');
};
