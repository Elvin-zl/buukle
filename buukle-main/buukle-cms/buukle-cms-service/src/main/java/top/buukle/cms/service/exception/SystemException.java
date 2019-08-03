package top.buukle.cms.service.exception;

import top.buukle.cms.service.constants.SystemReturnEnum;
import top.buukle.common.exception.CommonException;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 4:21
 */
public class SystemException extends CommonException{

    public SystemException(String status, String code, String msg) {
        super(status, code, msg);
    }

    public SystemException(SystemReturnEnum cmsReturnEnum) {
        super(cmsReturnEnum.getStatus(), cmsReturnEnum.getCode(), cmsReturnEnum.getMsg());
    }
}
