/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: Testss
 * Author:   zhanglei1102
 * Date:     2019/8/22 23:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.plugin.configure;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import top.buukle.security.entity.User;
import top.buukle.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;

/**
 * @description 〈〉
 * @author zhanglei1102
 * @create 2019/8/22
 * @since 1.0.0
 */
public class Testss {
    @Test
    public void sfs() throws JsonProcessingException {
        User user = new User();
        user.setUserId("11");
        List<User> sds = new ArrayList<>();
        sds.add(user);
        sds.add(user);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL,true);
//        objectMapper.
//        System.out.println("");
    }
}