package cn.itcast.order;

import cn.itcast.feign.client.UserClient;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
/*
//UserClient现在在cn.itcast.feign.clients包下，
而order-service的@EnableFeignClients注解是在cn.itcast.order包下，
不在同一个包，无法扫描到UserClient。
指定需要加载的Client接口：
 */
@EnableFeignClients(clients = UserClient.class)
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 全局配置LB负载均衡（轮训）规则，不论orderService请求哪个服务，都采用该负载均衡规则
     * @return Irule实现
     */
//    @Bean
//    public IRule iRule(){
//        return new RandomRule();
//    }

}