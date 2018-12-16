package top.buukle.provider.security.business.impl;

import org.springframework.stereotype.Component;
import top.buukle.provider.security.business.ButtonBusiness;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.provider.security.invoker.ButtonInvoker;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description :
 */
@Component
public class ButtonBusinessImpl implements ButtonBusiness {


    /**
     * 获取全局按钮类型缓存
     * @return
     */
    @Override
    public List<ButtonType> getButtonTypes() {
        return ButtonInvoker.getButtonTypes();
    }

    /**
     * 缓存全局按钮类型列表
     * @param buttonTypes
     */
    @Override
    public void saveButtonTypes(List<ButtonType> buttonTypes) {
        ButtonInvoker.saveButtonTypes(buttonTypes);
    }
}
