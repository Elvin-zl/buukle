package top.buukle.common.exception;

import top.buukle.common.constants.BaseResponseCode;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/31.
 * @Description :
 */
public class ViewException extends BaseException{

    public static final String PATH = "errorPage/error";
    /** 视图路径*/
    private String viewPath  = PATH;
    /** 详细信息*/
    private String info ;

    public ViewException(BaseResponseCode baseResponseCode) {
        super(baseResponseCode);
    }

    public String getViewPath() {
        return viewPath;
    }

    public ViewException setViewPath(String viewPath) {
        this.viewPath = viewPath;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public ViewException setInfo(String info) {
        this.info = info;
        return this;
    }
}
