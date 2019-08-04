layui.use(['form', 'layedit', 'laydate','jquery'], function() {

    (function ($) {
        $.getUrlParam = function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
    })(jQuery);

    var layer = layui.layer,$ = layui.jquery;
    var SlideVerifyPlug = window.slideVerifyPlug;
    var buukleSlideVerify = new SlideVerifyPlug('#buukle-verify-wrap',{
        wrapWidth:'340',
        initText:'请将滑块滑动到最右侧',
        sucessText:'验证通过',

    });
    var  validateLoin = $("#loginForm").validate({
        rules:{
            username:"required",
            password:"required",
        },
        messages:{
            username:"请输入用户名",
            password:"请输入密码",
        }
    });
    var validateRegister = $("#registerForm").validate({
        rules:{
            username:"required",
            password:"required",
            rPassword:"required",
            buukleCode:"required",
        },
        messages:{
            username:"请输入用户名",
            password:"请输入密码",
            rPassword:"请输入确认密码",
            buukleCode:"请输入邀请码",
        }
    });

    // 获取验证码
	$('#goVisit').off().on('click',function () {
        window.location.href='http://www.buukle.top';
    })
    // 获取验证码
	$('#getBuukleCode').off().on('click',function () {
        layer.open({
            type: 1,
			title:'邀请码',
            // skin: 'layui-layer-rim', //加上边框
            area: ['467px', '228px'], //宽高
            content: '<p style="margin-left: 41px; margin-top: 73px;">微信公众号搜索 "buukle布壳儿" 留言 :"邀请码" 即可获取;</p>'
        });
    })
    // 登录
    $('#login').off().on('click',function () {
        banThis($(this),'登陆中..');
        if(!buukleSlideVerify.slideFinishState){
            layer.msg('滑块验证失败!');
            releaseThis($(this),'登录');
            return;
        }
        if (!validateLoin.form()) {
            buukleSlideVerify.resetVerify();
            releaseThis($(this),'登录');
            return;
        }
        $('#password').val(hex_md5($('#password').val()));
        $.ajax({
            url:'/api/user/innerLogin',
            method:'POST',
            dataType:'json',
            data:$('#loginForm').serialize(),
            success : function (data) {
                buukleSlideVerify.resetVerify();
                if(data.head.status == "S"){
                    window.location.href=$.getUrlParam('returnUrl');
                }else{
                    releaseThis($('#login'),'登录');
                    layer.msg(data.head.msg);
                }
            },
            error:function () {
                buukleSlideVerify.resetVerify();
                releaseThis($('#login'),'登录');
            }
        });
    })
    // 去往注册
    $('#toRegister').off().on('click',function () {
        $('#loginForm').css("display","none");
        $('#registerForm').css("display","block");
    })
    // 注册
    $('#register').off().on('click',function () {
        if (!validateRegister.form()) {
            return;
        }
        $.ajax({
            url:'',
            method:'POST',
            dataType:'json',
            data:$('#registerForm').serialize(),
            success : function (data) {
                buukleSlideVerify.resetVerify();
            },
            error:function () {
                buukleSlideVerify.resetVerify();
            }
        });
    })
    // 去往登陆
    $('#toLogin').off().on('click',function () {
        $('#loginForm').css("display","block");
        $('#registerForm').css("display","none");
    })

    function banThis(obj,msg){
        obj.html(msg);
        obj.attr("disabled",true);
    }
    function releaseThis(obj,msg){
        $('.clearAble').val('');
        obj.html(msg);
        obj.attr("disabled",false);
    }

});