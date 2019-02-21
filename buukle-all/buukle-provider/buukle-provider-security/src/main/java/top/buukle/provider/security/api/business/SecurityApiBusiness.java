package top.buukle.provider.security.api.business;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.request.out.OutRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/5.
 * @Description :
 */
public interface SecurityApiBusiness {

    /**
     * 登录
     * @param baseRequest
     * @return
     * @throws Exception
     */
    BaseResponse doLogin(BaseRequest baseRequest) throws Exception;

    /**
     * 获取用户菜单树
     * @param baseRequest
     * @return
     */
    List<ModuleNavigationVo> getUserModuleTree(BaseRequest baseRequest) throws Exception;

    /**
     * 获取用户信息(外部项目用)
     * @param baseRequest
     * @return
     */
    User getUserInfo(BaseRequest baseRequest);


    /**
     * 获取全局按钮类型
     * @return
     */
    List<ButtonType> getButtonTypes();

    /**
     * 获取菜单下按钮信息
     * @param baseRequest
     * @return
     */
    List<Button> getModuleButtons(BaseRequest baseRequest);

    /**
     * 获取用户下辖列表信息
     * @param baseRequest
     * @return
     */
    List<String> getUserSubordinate(BaseRequest baseRequest);

    /**
     * 登出
     * @param baseRequest
     * @return
     */
    BaseResponse logout(BaseRequest baseRequest);

    /**
     * 查询作者信息
     * @param baseRequest
     * @return
     */
    User getArticleAuthor(BaseRequest baseRequest);

    /**
     * 添加黑名单
     * @param baseRequest
     * @return
     */
    BaseResponse addIpBlackList(OutRequest baseRequest);

    /**
     * 查询黑名单
     * @param baseRequest
     * @return
     */
    PageResponse getIpBlackList(OutRequest baseRequest);

    /**
     * 更新用户基本信息
     * @param baseRequest
     * @return
     */
    BaseResponse updateUserBasicResource(BaseRequest baseRequest) throws Exception;
}
