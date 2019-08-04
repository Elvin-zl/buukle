package top.buukle.security.api;


import top.buukle.common.call.AppResourceResponse;
import top.buukle.common.call.CommonRequest;

/**
* @author elvin
* @description ApiAppService 接口类
*/
public interface ApiAppService {



    /**
     * @description 查询app资源目录
     * @param request
     * @return top.buukle.common.call.AppResourceResponse
     * @Author elvin
     * @Date 2019/8/2
     */
    AppResourceResponse getAppResource(CommonRequest request);
}