package top.buukle.provider.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.provider.security.constants.SecurityConstants;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.business.UserBusiness;
import top.buukle.provider.security.service.UserService;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
@RestController
@RequestMapping(value = "/api/security/user",produces = SecurityConstants.PRODUCES_CONTENT_TYPE_JSON_UTF_8)
public class APISecurityUserController {

    @Autowired
    private UserBusiness userBusiness;
    @Autowired
    private UserService userService;

    /**
     * 测试 getUserById
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id) throws Exception {
        return userService.getUserById(id);
    }
    /**
     * 登陆接口
     * @param baseRequest
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/doLogin")
    public BaseResponse doLogin(@RequestBody BaseRequest baseRequest) throws Exception {
        return userBusiness.doLogin(baseRequest);
    }

    /**
     * 认证接口
     * @param request
     * @return
     */
    @PostMapping(value = "/authentication")
    public BaseResponse authentication(@RequestBody BaseRequest request){
        return userService.authentication(request);
    }

    /**
     * 授权接口
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/setPermission")
    public BaseResponse setPermission(@RequestBody BaseRequest request) throws Exception{
        return userService.setPermission(request);
    }
}
