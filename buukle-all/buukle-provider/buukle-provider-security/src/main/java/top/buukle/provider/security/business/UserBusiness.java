package top.buukle.provider.security.business;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/5.
 * @Description :
 */
public interface UserBusiness {


    /**
     * 获取用户信息
     * @param request
     * @return
     */
    User getUserInfo(HttpServletRequest request);


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

}
