//全局变量菜单树
var moduleTree = '';
var userInfo ='';
$(function () {
    /*初始化layUI配置*/
    initLayUIconfig();
    /*获取左侧菜单树*/
    getSideModuleTree();
    /*获取用户信息*/
    getUserInfo();
    /*渲染用户信息菜单*/
    renderTop();
    /*渲染左侧菜单*/
    renderModule();
    /*获取全局按钮类别*/
    getBtnTypes();
});
/*初始化layUI配置*/
function initLayUIconfig() {
    layui.config({
        base: 'js/'
    }).extend({
        'navbar' : 'navbar'
    });
}
/*获取用户信息*/
function getUserInfo() {
    $.ajax({
        async:false,
        url:'/user/getUserInfo',
        type:'post',
        dataType:'json',
        success:function (data) {
            userInfo = data;
            $('#userTheme').val(userInfo.theme);
            //设置主题
            setThemeAppearance(userInfo);
        }
    });
}
/*设置主题*/
function setThemeAppearance(userInfo) {
    if(null == userInfo.theme ){
        $('#themeCss').attr('href','/static/zElog/css/theme/theme-nigntStar.css');
        $('#currentDBTheme').val('/static/zElog/css/theme/theme-nigntStar.css');
        $('#tempTheme').val('/static/zElog/css/theme/theme-nigntStar.css');
    }else{
        $('#themeCss').attr('href',userInfo.theme);
        $('#currentDBTheme').val(userInfo.theme);
        $('#tempTheme').val(userInfo.theme);
    }
}
/*获取左侧菜单树*/
function getSideModuleTree() {
    $.ajax({
        async:false,
        url:'/module/getSideModuleTree',
        type:'post',
        dataType:'json',
        success:function (data) {
            moduleTree = data;
        }
    });
}
/*渲染用户信息*/
function renderTop() {
    layui.use(['element','navbar'],function(){
        var element = layui.element,navbar  = layui.navbar;
        // 顶部导航栏渲染
        navbar.render({
            data: [{
                icon : 'fa-bell-o',
                layId : 'alert',
                badgeTitle: userInfo.fansAndMessages,
                children : [{
                    title : '最新消息('+userInfo.fans+')',
                    layId : 'message',
                    layUrl : '/toMain/userCenter/password?t='+Math.random()
                },{
                    title : '最新粉丝('+userInfo.message+')',
                    layId : 'message',
                    layUrl : '/toMain/userCenter/password?t='+Math.random()
                }]
            },{
                title : userInfo.username,
                children : [{
                    title : '密码修改',
                    layId : 'password',
                    layUrl : '/toMain/userCenter/password?t='+Math.random()
                },{
                    title : '退出',
                    layId : 'logout',
                    layUrl : '/logout?t='+Math.random()
                }]
            }],
            filter : 'navbar'
        });
        navbar.init();
    });
}
/*渲染左侧菜单*/
function renderModule() {
    layui.use(['element','navbar'],function(){
        var element = layui.element,navbar  = layui.navbar;
        // 侧边导航栏渲染
        navbar.render({
            filter : 'side',
            data : moduleTree
        });
        navbar.init();
    });
}
/*获取全局按钮类别*/
function getBtnTypes() {
    $.ajax({
        url:'/module/getBtnTypes',
        dataType:'text',
        type:'post',
        success:function (data) {
            //字符串化按钮类别并缓存到隐藏域
            if($('#globalBtnType').length > 0){
                $('#globalBtnType').remove();
            }
            $('#hiddenResource').append('<input type="hidden" id="globalBtnType" value=\''+JSON.stringify(data)+'\'/>');
        }
    });
}

