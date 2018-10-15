package top.buukle.provider.security.invoker;

import com.alibaba.fastjson.JSON;
import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.jedis.RedisString;
import top.buukle.provider.security.constants.SecurityConstants;
import top.buukle.provider.security.entity.ButtonType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description :
 */
public class ButtonInvoker {
    /**
     * 获取全局按钮类型缓存
     * @return
     */
    public static List<ButtonType> getButtonTypes() {
        String buttonTypesStr = RedisString.get(SecurityConstants.GLOBAL_BUTTON_TYPE_KEY);
        return StringUtil.isEmpty(buttonTypesStr) ? new ArrayList<>() : JsonUtil.parseArray(buttonTypesStr,ButtonType.class);
    }

    /**
     * 缓存全局按钮缓存列表
     * @param buttonTypes
     */
    public static void saveButtonTypes(List<ButtonType> buttonTypes) {
        RedisString.setWithExpire(SecurityConstants.GLOBAL_BUTTON_TYPE_KEY, JSON.toJSONString(buttonTypes), NumberUtil.LONG_ONE_DAY_SECOND);
    }
}
