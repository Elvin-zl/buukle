package top.buukle.common.util.common;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.*;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Properties;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/3.
 * @Description :
 */
@Component
public class SpringEnvironmentUtil implements EnvironmentAware {

    /** 默认命名空间*/
    private static final String SSO_PROPERTIES = "ssoProperties";

    private  static ConfigurableEnvironment configurableEnvironment = null;

    @Override
    public void setEnvironment(Environment environment) {
        configurableEnvironment = (ConfigurableEnvironment) environment;
        System.out.println("top.buukle.common.util.common.SpringEnvironmentUtil : configurableEnvironment spring 环境变量装配成功!");
    }

    /**
     * 向 environment 中添加属性
     * @param key
     * @param value
     */
    public static void setEnvironmentProperty(String key,String value) {
        MutablePropertySources m = configurableEnvironment.getPropertySources();
        PropertySource<?> ssoPropertyPropertySource = m.get(SSO_PROPERTIES);
        if(null == ssoPropertyPropertySource){
            Properties p = new Properties();
            m.addLast(new PropertiesPropertySource(SSO_PROPERTIES, p));
        }
        ssoPropertyPropertySource = m.get(SSO_PROPERTIES);
        Hashtable<String,String> table = (Hashtable<String, String>) ssoPropertyPropertySource.getSource();
        table.put(key, value);
    }
}
