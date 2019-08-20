package top.buukle.security.plugin.constants;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/8/30.
 * @Description :
 */
public class SecurityInterceptorConstants {
    /** 系统登录cookie key*/
    public static final String LOGIN_COOKIE_NAME = "BUKKLEUID";
    /** 系统登录cookie domain*/
    public static final String LOGIN_COOKIE_DOMAIN = "buukle.top";
    /** 开启认证*/
    public static final String OPEN_AUTH_TRUE = "1";
    /** 开启授权*/
    public static final String OPEN_PERM_TRUE = "1";
    /** 开启数据隔离*/
    public static final String OPEN_ISOL_TRUE = "1";
    /** 开启接口注册*/
    public static final String OPEN_REGS_TRUE = "1";
    /** 未认证模板*/
    public static final String BUUKLE_NO_AUTH_CONTENT_TEMPLATE = "BUUKLE_NO_PERM_CONTENT_TEMP";
    /** 认证失败提示页*/
    public static final String NO_AUTH_RETURN_HTML_TEMPLATE =
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                    "<head>\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                    "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
                    "<title>buukle-超时</title>\n" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"\">\n" +
                    "</head>\n" +
                    "<style type=\"text/css\">\n" +
                    "html,body{height:100%;overflow:hidden;}\n" +
                    "body,div,h2{margin:0;padding:0;}\n" +
                    "center{padding-top:10px;}\n" +
                    "button{cursor:pointer;margin: auto;}\n" +
                    "#overlay{position:absolute;top:0;left:0;width:100%;height:100%;background:#000;opacity:0.5;filter:alpha(opacity=50);}\n" +
                    "#win{position:absolute;top:50%;left:50%;width:400px;height:200px;background:#fff;solid #f90;margin:-102px 0 0 -202px;}\n" +
                    "h2{font-size:14px;text-align:right;background:rgba(73, 195, 145, 0.77); solid #f90;padding:5px;}\n" +
                    "h2 span{color:#f90;cursor:pointer;background:#fff;border:1px solid #f90;padding:0 2px;}\n" +
                    "</style>\n" +
                    "<body style=\"font-family: '等线'\">\n" +
                    "  <div  id=\"overlay\" >\t\n" +
                    "  </div>\n" +
                    "  <div id=\"win\" >\n" +
                    "  \t<h2>buukle提示</h2>\n" +
                    "\t<div style='font-family : \"等线\"; margin-top: 13%; font-family: \"等线\"; padding: 6px 34px;'>" + BUUKLE_NO_AUTH_CONTENT_TEMPLATE + "\n" +
                    "\t<a id='jumpTo' onclick=\"jumpTo()\" href= 'javascript:;'> 点击跳转登录页面   </a>    <span style='color:red' id='seconds'>5</span>秒后将自动跳转...\n" +
                    "</div>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "<script>  \n" +
                    "var surl = 'security.passport.host';\n" +
                    "countDown(5); \n" +
                    "function jumpTo(){\n" +
                    "top.location.href=surl;\n" +
                    "}\n" +
                    "function countDown(secs){\n" +
                    "var seconds = document.getElementById('seconds');     \n" +
                    "seconds.innerHTML=secs; \n" +
                    "secs--;\n" +
                    "if(secs>=0){ \n" +
                    "setTimeout(\"countDown(\"+secs+\")\",1000);   \n" +
                    "}else{\n" +
                    "jumpTo();\n" +
                    "return;\n" +
                    "} \n" +
                    "}\n" +
                    "</script>\n" +
                    "</html>"
            ;


    /** 授权失败提示页*/
    public static final String NO_PERM_RETURN_HTML_TEMPLATE =
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                    "<head>\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                    "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
                    "<title>buukle-没有权限</title>\n" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"\">\n" +
                    "</head>\n" +
                    "<style type=\"text/css\">\n" +
                    "html,body{height:100%;overflow:hidden;}\n" +
                    "body,div,h2{margin:0;padding:0;}\n" +
                    "center{padding-top:10px;}\n" +
                    "button{cursor:pointer;margin: auto;}\n" +
                    "#overlay{position:absolute;top:0;left:0;width:100%;height:100%;background:#000;opacity:0.5;filter:alpha(opacity=50);}\n" +
                    "#win{position:absolute;top:50%;left:50%;width:400px;height:200px;background:#fff;solid #f90;margin:-102px 0 0 -202px;}\n" +
                    "h2{font-size:14px;text-align:right;background:rgba(73, 195, 145, 0.77); solid #f90;padding:5px;}\n" +
                    "h2 span{color:#f90;cursor:pointer;background:#fff;border:1px solid #f90;padding:0 2px;}\n" +
                    "</style>\n" +
                    "<body style=\"font-family: '等线'\">\n" +
                    "  <div  id=\"overlay\" >\t\n" +
                    "  </div>\n" +
                    "  <div id=\"win\" >\n" +
                    "  \t<h2>buukle提示</h2>\n" +
                    "\t<p style=\"margin-left: 20%; margin-top: 17%;color:red\">noPerm</p>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</html>"
             ;
}
