package top.buukle.common.exception;

import top.buukle.common.call.code.BaseReturnEnum;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/31.
 * @Description :
 */
public class ViewException extends CommonException {

    public static final String PATH = "errorPage/error";
    /** 视图路径*/
    private String viewPath  = PATH;
    /** 详细信息*/
    private String detail ;

    public ViewException(BaseReturnEnum baseResponseCode) {
        super(baseResponseCode);
    }

    public String getViewPath() {
        return viewPath;
    }

    public ViewException setViewPath(String viewPath) {
        this.viewPath = viewPath;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public ViewException setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
