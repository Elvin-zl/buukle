package top.buukle.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/5.
 * @Description :
 */
@Component
public class BuukleFilter implements GlobalFilter,Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        String ip = serverWebExchange.getRequest().getRemoteAddress().getHostString();
//        if(RedisInvoker.isInblackList(ip)){
//            System.out.println("ip" + ip + "正在小黑屋!");
////            return null;
//        }
//        RedisInvoker.addVisitCount(ip);
//        int count =  RedisInvoker.getVisitCount(ip);
////        if(count > 10000){
////            RedisInvoker.addBlackList(ip);
////            return null;
////        }

        return gatewayFilterChain.filter(serverWebExchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
