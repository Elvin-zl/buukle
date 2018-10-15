package top.buukle.provider.security.business;

import top.buukle.provider.security.entity.ButtonType;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description :
 */
public interface ButtonBusiness {
    /**
     * 获取全局按钮类型缓存
     * @return
     */
    List<ButtonType> getButtonTypes();

    void saveButtonTypes(List<ButtonType> buttonTypes);
}
