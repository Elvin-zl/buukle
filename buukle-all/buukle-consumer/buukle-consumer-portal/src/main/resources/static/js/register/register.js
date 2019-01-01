$(function () {
    //加载用户登录信息
    loadUserInfo();
    //绑定切换验证码
    bindVarifySwitch();
    //绑定登录按钮
    bindDoLogin();
    //绑定input点击事件
    bindInputClick();
    //绑定回车事件
    bindEnterClick();
})

/*加载用户登录信息*/
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

/*绑定回车事件*/
function bindEnterClick() {
    $("body").keydown(function() {
        if (event.keyCode == "13") {//keyCode=13是回车键
            $('#doLogin').click();
        }
    });
}

/*绑定切换验证码*/
function bindVarifySwitch() {
    $('#verifySwitch').off().on('click',function () {
        $('#verifyImg').attr('src',"/getVerificationImg?t="+Math.random());
    })
}

/*绑定登录按钮*/
function bindDoLogin() {
    $('#doLogin').off().on('click',function () {
        $('#password').val(hex_md5($('#password').val()));
        $.ajax({
            url : 'doLogin',
            method : 'post',
            data : $('#loginForm').serialize(),
            dataType : 'json',
            success : function (data) {
                if(data.status == 'S'){
                    location.href='index.html';
                }else{
                    $('#password').val('');
                    $('#verificationCode').val('');
                    $('#verifyImg').attr('src',"/getVerificationImg?t="+Math.random());
                    $('#loginError').html(data.msg);
                }
            }
        })
    })
}

/*绑定input点击事件*/
function bindInputClick() {
    $('.clearable').off().on('click',function(){
        $('#loginError').html('');
    })
}