package top.buukle.consumer.cms.filter.validatorAndHanler;

import top.buukle.common.dataIsolation.IsolationRelation;
import top.buukle.common.dataIsolation.IsolationRelationThreadLocal;
import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base.BaseRequestValidator;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.util.CookieUtil;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/3.
 * @Description : 数据隔离请求处理校验器
 */
public class DataIsolationRequestValidator extends BaseRequestValidator {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(DataIsolationRequestValidator.class);

    /**
     * 实现验签方法
     * @param requestBody
     * @param httpServletRequest
     */
    @Override
    public void verify(String requestBody, HttpServletRequest httpServletRequest) {
        //本拦截器不实现
    }

    /**
     * 参数校验
     * @param httpServletRequest
     * @param uri
     * @param requestBody
     * @param servletResponse
     * @throws IOException
     */
    @Override
    public void doValidate(HttpServletRequest httpServletRequest, String uri, String requestBody, ServletResponse servletResponse) throws IOException {
        try {
            if(!uri.contains("uploadImageServlet")){
                String method = httpServletRequest.getMethod();
                if("POST".equals(method)){
                    //校验请求参数
                    BaseResponse baseResponse = this.doValidate(httpServletRequest);
                    //校验失败
                    if(baseResponse.isSuccess()){
                        this.afterValidateHandle(httpServletRequest,requestBody);
                    }
                }
            }
        }catch (Exception e){

        }
    }

    /**
     * 重载 doValidate 将用户的数据隔离信息放入本地线程变量
     * @param httpServletRequest
     * @return
     */
    private BaseResponse doValidate(HttpServletRequest httpServletRequest) {
        // 获取用户信息
        SecurityClient securityClient = SpringContextUtil.getBean(SecurityClient.class);
        User user = securityClient.getUserInfo(httpServletRequest);
        IsolationRelation isolationRelation = new IsolationRelation();
        // 设置用户身份
        isolationRelation.setUserLevel(user.getUserLevel());
        // 设置获取用户下级信息
        isolationRelation.setSubCodeList(securityClient.getUserSubordinate(user.getUserId()));
        IsolationRelationThreadLocal.setSchemas(isolationRelation);
        return new BaseResponse.Builder().buildSuccess();
    }
}
