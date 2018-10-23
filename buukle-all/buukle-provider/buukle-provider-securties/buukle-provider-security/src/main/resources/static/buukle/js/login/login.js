$(function(){
    //处理登出的情况
    logoutHandle();
    //加载登录弹框
    loadLoginBox();
    //验证码点击切换
    bindVerifyFresh();
    $('#switchVerifyImg').click();
    //点击输入框清空错误提示
    clearTheErrorMsg();
});
/*处理登出的情况*/
function logoutHandle() {
    if(undefined != window.parent.$('#isLogout').val() && window.parent.$('#isLogout').val() == 'isLogout'){
        window.parent.location.href= window.parent.location.href.replace('index','login');
    }
}
/*加载登录弹框*/
function loadLoginBox() {
    layui.use('layer', function(){
        var layer = layui.layer;
        var loginBox = $('#loginLayOut');
        layer.open({
            title :'',
            area: ['500px', '310px'],
            type: 1,
            closeBtn: 0,
            scrollbar: false,
            content:loginBox
        });
        loginBox.show();
        layui.use('form', function(){
            var form = layui.form;
            //登录
            form.on('submit(formDemo)', function(){
                $('#usernameHidden').attr('name','');
                var password = $("#password").val();
                var password_m = hex_md5(password);
                $("#password").val(password_m);
                $.ajax({
                    url:'/doLogin',
                    type:'post',
                    dataType:'json',
                    data: $('#form').serialize(),
                    success:function(data){
                        if(data.status == 'F'){
                            $('#username').val('');
                            $('#password').val('');
                            $('#verificationCode').val('');
                            $('#verifyImg').attr('src','/getVerificationImg?t='+Math.random());
                            if(data.code == 60001){
                                var verifyCodeError = $('#verifyError');
                                verifyCodeError.val(data.msg);
                                verifyCodeError.show();
                                return;
                            }
                            if(data.code == 999998){
                                var usernameAndPwdError =  $('#pwdError');
                                usernameAndPwdError.val(data.msg);
                                usernameAndPwdError.show();
                                return;
                            }
                            var usernameAndPwdError =  $('#pwdError');
                            usernameAndPwdError.val(data.msg);
                            usernameAndPwdError.show();
                        }
                        if(data.status == 'S'){
                            window.open('/index','_self')
                        }
                    }
                });
                return false;
            });
        });
    });
}
/*验证码点击切换*/
function bindVerifyFresh() {
    $('#switchVerifyImg').on('click',function () {
        $('#verifyImg').attr('src','/getVerificationImg?t='+Math.random());
    });
}
/*点击输入框清空错误提示*/
function clearTheErrorMsg() {
    $('.layui-input').on('click',function(){
        var error = $('.errorMsg');
        error.val('');
        error.hide();
    });
}
