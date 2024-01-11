package cn.itcast.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * ClassName: DefaultLogConfiguration
 * PackageName: cn.itcast.order.config
 * Description:
 *
 * @Author: Hanyu
 * @Date: 24/01/11 - 09:30
 * @Version: v1.0
 */
public class DefaultLogConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
}
