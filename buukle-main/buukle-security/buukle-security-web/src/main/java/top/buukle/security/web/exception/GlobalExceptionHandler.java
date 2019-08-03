package top.buukle.security.web.exception;

import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.exception.CommonException;
import top.buukle.common.exception.ViewException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.security.plugin.exception.SecurityPluginException;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : springboot 应用全局异常解决方案
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 自定义异常处理(返回json)
     * @param commonException
     * @return
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public CommonResponse commonExceptionHandler(CommonException commonException) {
        commonException.printStackTrace();
        return new CommonResponse.Builder().buildFailedInner(commonException);
    }
    /**
     *  security异常处理(返回json)
     * @param securityPluginException
     * @return
     */
    @ExceptionHandler(SecurityPluginException.class)
    @ResponseBody
    public CommonResponse securityExceptionHandler(SecurityPluginException securityPluginException) {
        securityPluginException.printStackTrace();
        return new CommonResponse.Builder().buildFailedInner(securityPluginException);
    }

    /**
     * 自定义异常处理(返回视图)
     * @return
     * @param viewException
     */
    @ExceptionHandler(ViewException.class)
    private ModelAndView viewExceptionHandle(ViewException viewException) {
        return new ModelAndView(viewException.getViewPath(),"exception",viewException);
    }

    /**
     * 系统异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse exceptionHandler(Exception exception) {
        exception.printStackTrace();
        return new CommonResponse.Builder().buildFailed(exception);
    }
}
