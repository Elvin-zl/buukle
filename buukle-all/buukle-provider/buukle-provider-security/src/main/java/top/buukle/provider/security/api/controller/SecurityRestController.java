package top.buukle.provider.security.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.plugins.SecurityInterceptor;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;
import top.buukle.provider.security.api.business.SecurityApiBusiness;
import top.buukle.provider.security.constants.SecurityConstants;
import top.buukle.plugin.security.entity.User;
import top.buukle.provider.security.service.UserService;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
@RestController
@RequestMapping(value = SecurityInterceptor.API_URI_PREFIX,produces = SecurityConstants.PRODUCES_CONTENT_TYPE_JSON_UTF_8)
public class SecurityRestController {

    @Autowired
    private SecurityApiBusiness securityApiBusiness;
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
        return securityApiBusiness.doLogin(baseRequest);
    }
    /**
     * 登出接口
     * @param baseRequest
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/logout")
    public BaseResponse logout(@RequestBody BaseRequest baseRequest) throws Exception {
        return securityApiBusiness.logout(baseRequest);
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
    /**
     * 获取用户菜单树接口
     * @param baseRequest
     * @return
     */
    @PostMapping(value = "/getUserModuleTree")
    List<ModuleNavigationVo> getUserModuleTree(@RequestBody BaseRequest baseRequest) throws Exception {
        return securityApiBusiness.getUserModuleTree(baseRequest);
    }

    /**
     * 获取用户信息接口
     * @param baseRequest
     * @return
     */
    @PostMapping(value = "/getUserInfo")
    User getUserInfo(@RequestBody BaseRequest baseRequest){
        return securityApiBusiness.getUserInfo(baseRequest);
    }

    /**
     * 获取按钮类型接口
     * @param baseRequest
     * @return
     */
    @PostMapping(value = "/getButtonTypes")
    List<ButtonType> getButtonTypes(@RequestBody BaseRequest baseRequest){
        return securityApiBusiness.getButtonTypes();
    }

    /**
     * 获取菜单下的按钮信息接口
     * @param baseRequest
     * @return
     */
    @PostMapping(value = "/getModuleButtons")
    List<Button> getModuleButtons(@RequestBody BaseRequest baseRequest){
        return securityApiBusiness.getModuleButtons(baseRequest);
    }

    /**
     * 获取用户下辖列表信息接口
     * @param baseRequest
     * @return
     */
    @PostMapping(value = "/getUserSubordinate")
    List<String> getUserSubordinate(@RequestBody BaseRequest baseRequest){
        return securityApiBusiness.getUserSubordinate(baseRequest);
    }

    /**
     * 获取文章作者信息
     * @param baseRequest
     * @return
     */
    @PostMapping(value = "/getArticleAuthor")
    User getArticleAuthor(@RequestBody BaseRequest baseRequest){
        return securityApiBusiness.getArticleAuthor(baseRequest);
    }
}
