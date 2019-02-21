package top.buukle.common.exception;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : springboot 应用全局异常解决方案
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /** 系统异常计数器*/
    public static AtomicLong ERROR_COUNT = new AtomicLong(0L);

    /**
     * 自定义异常处理(返回json)
     * @param baseException
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse baseExceptionHandler(BaseException baseException) {
        baseException.printStackTrace();
        return new BaseResponse.Builder().buildFailedInner(baseException);
    }
    /**
     * 自定义异常处理(返回视图)
     * @return
     * @param viewException
     */
    @ExceptionHandler(ViewException.class)
    private ModelAndView viewExceptionHandle0(ViewException viewException) {
        return new ModelAndView(viewException.getViewPath(),"viewException",viewException);
    }
    /**
     * 404 异常处理(返回视图)
     * @return
     * @param noHandlerFoundException
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    private ModelAndView viewExceptionHandle1(NoHandlerFoundException noHandlerFoundException) {
        return new ModelAndView(ViewException.PATH,"viewException",new ViewException(BaseResponseCode.NOT_FOUND));
    }

    /**
     * 系统异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse systemExceptionHandler(Exception exception) {
        exception.printStackTrace();
        return new BaseResponse.Builder().buildFailedInner(ERROR_COUNT);
    }
}
