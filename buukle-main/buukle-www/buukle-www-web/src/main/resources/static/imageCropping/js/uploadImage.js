//弹出框水平垂直居中
(window.onresize = function () {
    var win_height = $(window).height();
    var win_width = $(window).width();
    if (win_width <= 768){
        $(".tailoring-content").css({
            "top": (win_height - $(".tailoring-content").outerHeight())/2,
            "left": 0
        });
    }else{
        $(".tailoring-content").css({
            "top": (win_height - $(".tailoring-content").outerHeight())/2,
            "left": (win_width - $(".tailoring-content").outerWidth())/2
        });
    }
})();

//图像上传
function selectImg(file) {
    if (!file.files || !file.files[0]){
        return;
    }
    var reader = new FileReader();
    reader.onload = function (evt) {
        var replaceSrc = evt.target.result;
        //更换cropper的图片
        $('#tailoringImg').cropper('replace', replaceSrc,false);//默认false，适应高度，不失真
    }
    reader.readAsDataURL(file.files[0]);
}
//cropper图片裁剪
$('#tailoringImg').cropper({
    aspectRatio: 4/3,//默认比例
    preview: '.previewImg',//预览视图
    guides: true,  //裁剪框的虚线(九宫格)
    autoCropArea: 0.5,  //0-1之间的数值，定义自动剪裁区域的大小，默认0.8
    movable: false, //是否允许移动图片
    dragCrop: false,  //是否允许移除当前的剪裁框，并通过拖动来新建一个剪裁框区域
    movable: true,  //是否允许移动剪裁框
    resizable: false,  //是否允许改变裁剪框的大小
    zoomable: true,  //是否允许缩放图片大小
    mouseWheelZoom: true,  //是否允许通过鼠标滚轮来缩放图片
    touchDragZoom: true,  //是否允许通过触摸移动来缩放图片
    rotatable: true,  //是否允许旋转图片
    crop: function(e) {
        // 输出结果数据裁剪图像。
    }
});
//旋转
$(".cropper-rotate-btn").on("click",function () {
    $('#tailoringImg').cropper("rotate", 45);
});
//复位
$(".cropper-reset-btn").on("click",function () {
    $('#tailoringImg').cropper("reset");
});
//换向
var flagX = true;
$(".cropper-scaleX-btn").on("click",function () {
    if(flagX){
        $('#tailoringImg').cropper("scaleX", -1);
        flagX = false;
    }else{
        $('#tailoringImg').cropper("scaleX", 1);
        flagX = true;
    }
    flagX != flagX;
});
// 裁剪后的处理
$("#sureCut").on("click",function () {
    if ($("#tailoringImg").attr("src") == null ){
        return false;
    }else{
        var cas = $('#tailoringImg').cropper('getCroppedCanvas');
        var formData = new FormData();
        // 声明img标签，并通过src伪加载
        var image = $('<img/>');
        image.attr('src', cas.toDataURL('image/jpeg'));
        // img标签的加载事件
        image.on('load', function () {
            // 定义canvas的宽、高
            var compressWidth = 1024;
            var compressHeight = 768;
            var canvas = document.createElement('canvas');
            canvas.width = compressWidth;
            canvas.height = compressHeight;
            var context = canvas.getContext('2d');
            context.clearRect(0, 0, compressWidth, compressHeight);
            context.drawImage(this, 0, 0, compressWidth, compressHeight);
            formData.append("file", dataURLtoFile(canvas.toDataURL('image/jpeg'),"buukle.jpg"));
            $.ajax({
                url : '/upload/uploadImage',
                method : 'post',
                data : formData,
                cache: false,
                contentType: false,
                processData:false,
                dataType : 'json',
                success : function (data) {
                    afterUploadImg(data);
                }
            });
            //关闭裁剪框
            closeTailor();
        });
    }
});

//关闭裁剪框
function closeTailor() {
    $(".tailoring-container").toggle();
}
//将base64转换为文件对象
function dataURLtoFile(dataurl, filename) {
    var arr = dataurl.split(',');
    var mime = arr[0].match(/:(.*?);/)[1];
    var bstr = atob(arr[1]);
    var n = bstr.length;
    var u8arr = new Uint8Array(n);
    while(n--){
        u8arr[n] = bstr.charCodeAt(n);
    }
    //转换成file对象
    return new File([u8arr], filename, {type:mime});


}