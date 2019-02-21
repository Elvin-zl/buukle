$(function () {
    // 绑定编辑按钮
    bindEditClick();
    // 绑定修改头像按钮
    bingEditHeadImgCilck();

});

/*绑定修改头像按钮*/
function bingEditHeadImgCilck() {
    $('#editImg').off().on('click',function () {
        $('#headImgFile').click();
    });
    // 绑定头像自动上传
    bindHeadImgAutoUpload();
}

/*绑定头像自动上传*/
function bindHeadImgAutoUpload() {
    $('#headImgFile').off().on('change',function () {
        var formData = new FormData();
        var file = $("#headImgFile")[0].files[0];
        formData.append("file", file);
        $.ajax({
            url : '/upload/uploadImage',
            method : 'post',
            data : formData,
            cache: false,
            contentType: false,
            processData:false,
            dataType : 'json',
            success : function (data) {
                if(data.status == 'S'){
                    $('#headImage').attr('src',data.msg);
                    $('#headImgUrl').val(data.msg);
                }else{
                    alert(data.msg);
                }
            }
        })
    })
}

/*绑定编辑按钮*/
var isSave = false;
function bindEditClick() {
    $('#edit').off().on('click',function () {
        if(!isSave){
            $(this).html('保存');
            var inputs = $('.user-center-input');
            inputs.attr('disabled',false);
            inputs.removeClass('none-border');
            $('#editImg').show();
            $('#lookBig').hide();
            isSave = !isSave;
        }else{
            //执行保存
            executeSave();
        }
    })
}

/*执行保存*/
function executeSave() {
    $.ajax({
        url : '/security/updateUserBasicResource',
        method : 'post',
        data : $('#userBasicResource').serialize(),
        dataType : 'json',
        success : function (data) {
            if(data.status == 'S'){
                $('#edit').html('编辑');
                var inputs = $('.user-center-input');
                inputs.attr('disabled',true);
                inputs.addClass('none-border');
                $('#editImg').hide();
                $('#lookBig').show();
                isSave = !isSave;
            }else{
                alert(data.msg);
            }
        }
    })
}