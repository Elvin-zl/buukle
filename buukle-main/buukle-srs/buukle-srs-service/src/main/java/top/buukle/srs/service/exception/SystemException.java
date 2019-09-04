package top.buukle.srs.service.exception;

import top.buukle.common.exception.CommonException;
import top.buukle.srs.service.constants.SystemReturnEnum;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 4:21
 */
public class SystemException extends CommonException{

    public SystemException(String status, String code, String msg) {
        super(status, code, msg);
    }

    public SystemException(SystemReturnEnum securityReturnEnum) {
        super(securityReturnEnum.getStatus(), securityReturnEnum.getCode(), securityReturnEnum.getMsg());
    }

    public SystemException(SystemReturnEnum securityReturnEnum, String msg) {
        super(securityReturnEnum.getStatus(), securityReturnEnum.getCode(), securityReturnEnum.getMsg() + msg);
    }

    public static CommonException convert(SystemException s ,CommonException c){
        c.setCode(s.getCode());
        c.setStatus(s.getStatus());
        c.setMsg(s.getMsg());
        return c;
    }
}
