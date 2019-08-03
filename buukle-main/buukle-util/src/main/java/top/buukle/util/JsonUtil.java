package top.buukle.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/5.
 * @Description :
 */
public class JsonUtil extends JSON{

    public static Object parseFromObject(Object user,Class<?> clazz) {
        return JSON.parseObject(JSON.toJSONString(user), clazz);
    }

    public static List<?> parseArrayFromObject(List<Object> userList, Class<?> clazz) {
        return JSON.parseArray(JSON.toJSONString(userList), clazz);
    }
}
