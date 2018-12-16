/**
 * @name    Public
 * @author  SuChiZhu
 * @version 1.0.0
*/

layui.define(['layer'],function(exports){
    var layer  = layui.layer,
        $      = layui.jquery,
        Public = function(){
            this.v = '1.0.0';
        };
    
    // ajax 封装
    Public.prototype.ajax = function(url, data){
        $.ajax({
            url: url,
            data: data,
            type: 'post',
            dataType: 'json',
            success: function(res){
                if(res.code == 1){
                    layer.msg(res.msg,{icon: 6});
                }else{
                    layer.msg(res.msg,{icon: 5});
                }
            },
            error: function(err){
                layer.msg('请求异常',{icon: 5});
            }
        });
    };

    var public = new Public();

    exports('public',public);
});