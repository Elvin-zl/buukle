package top.buukle.util.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.retry.ExponentialBackoffRetry;
import top.buukle.util.SpringContextUtil;
import top.buukle.util.StringUtil;

/**
 * @description
 * @Author zhanglei1102
 * @Date 2019/8/23
 */
public class CuratorFrameworkFactory {
    /**
     * 客户端
     */
    private CuratorFramework client;

    /**
     * 构造方法
     *
     * @param host zk主机
     */
    private CuratorFrameworkFactory(String host, int baseSleepTimeMs, int maxRetries) {
        client = org.apache.curator.framework.CuratorFrameworkFactory.newClient(host, new ExponentialBackoffRetry(baseSleepTimeMs, maxRetries));
        client.start();
    }

    private static CuratorFrameworkFactory instance;

    public static CuratorFramework getInstance(SpringContextUtil springContextUtil) throws Exception {
        CuratorFrameworkConfigureProperties zkConfigure = springContextUtil.getBean(CuratorFrameworkConfigureProperties.class);
        if(null == zkConfigure || StringUtil.isEmpty(zkConfigure.getHost())){
            throw new Exception("zk configure wrong ! please check your application's basePackageScan contains 'top.buukle.util.zk.ZKConfigure'");
        }
        if(null == instance){
            instance = new CuratorFrameworkFactory(zkConfigure.getHost(),zkConfigure.getBaseSleepTimeMs(),zkConfigure.getZkMaxRetries());
        }
        return instance.client;
    }
}