$(function () {
    // 加载用户登录信息
    loadUserInfo();
    // 绑定切换验证码
    bindVarifySwitch();
    // 绑定登录按钮
    bindDoLogin();
    // 绑定input点击事件
    bindInputClick();
    // 绑定回车事件
    bindEnterClick();
    // 绑定点击事件
    bindSwitch();
    // 绑定注册按钮
    bindDoRegister();
});

/** 绑定注册按钮 */
function bindDoRegister() {
    $('#doRegister').off().on('click',function () {
        $('#passwordRegister').val(hex_md5($('#passwordRegister').val()));
        $('#passwordRegisterConfirm').val(hex_md5($('#passwordRegisterConfirm').val()));
        banThis($(this),'注册中 ...');
        $.ajax({
            url : '/doRegister',
            method : 'post',
            data : $('#registerForm').serialize(),
            dataType : 'json',
            success : function (data) {
                if(data.status == 'S'){
                    banThis($('#doLogin'),'注册成功!正在跳转登录页面...');
                    location.href='login.html';
                }else{
                    $('#passwordRegister').val('');
                    $('#passwordRegisterConfirm').val('');
                    $('#invitationCode').val('');
                    $('#verificationCodeRegister').val('');
                    $('#verifyImgRegister').attr('src',"/getVerificationImg?t="+Math.random());
                    $('#registerError').html(data.msg);
                    releaseThis($('#doRegister'),'注册');
                }
            }
        })
    });
}
/** 绑定点击切换注册事件 */
function bindSwitch() {
    $('#register-switch').off().on('click',function () {
        //  关闭回车监听登录
        isActive = false;
        $('#registerI').css('display','block');
        $('#login').css('display','none');
        $('#verifyImg').attr('src',"/getVerificationImg?v="+ Math.random());
    });
    $('#login-switch').off().on('click',function () {
        // 开启回车监听登录
        isActive = true;
        $('#registerI').css('display','none');
        $('#login').css('display','block');
        $('#verifyImgRegister').attr('src',"/getVerificationImg?v="+ Math.random());
    });
}
/** 加载用户登录信息 */
function loadUserInfo() {
    $.ajax({
        url : '/security/getUserInfo',
        method : 'post',
        dataType : 'json',
        success : function(data){
            if(data.username != undefined && data.username != '' ){
                location.href="/index.html";
            }
        }
    })
}

var isActive = true;
/** 绑定回车事件*/
function bindEnterClick() {
    $("body").keydown(function() {
        if ( isActive && event.keyCode == "13") {// keyCode=13是回车键
            $('#doLogin').click();
        }
    });
}

/** 绑定切换验证码*/
function bindVarifySwitch() {
    $('#verifyImg,#verifyImgRegister').off().on('click',function () {
        $(this).attr('src',"/getVerificationImg?t="+Math.random());
    })
}

/** 绑定登录按钮*/
function bindDoLogin() {
    $('#doLogin').off().on('click',function () {
        $('#password').val(hex_md5($('#password').val()));
        banThis($(this),'登录中 ...');
        $.ajax({
            url : '/doLogin',
            method : 'post',
            data : $('#loginForm').serialize(),
            dataType : 'json',
            success : function (data) {
                if(data.status == 'S'){
                    banThis($('#doLogin'),'登录成功!正在跳转...');
                    location.href='index.html';
                }else{
                    $('#password').val('');
                    $('#verificationCode').val('');
                    $('#verifyImg').attr('src',"/getVerificationImg?t="+Math.random());
                    $('#loginError').html(data.msg);
                    releaseThis($('#doLogin'),'登录');
                }
            }
        })
    })
}

/** 绑定input点击事件*/
function bindInputClick() {
    $('.clearable').off().on('click',function(){
        $('#loginError').html('');
        $('#registerError').html('');
    })
}