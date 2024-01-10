package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: PatternProperties
 * PackageName: cn.itcast.user.config
 * Description:
 *
 * @Author: Hanyu
 * @Date: 24/01/10 - 18:08
 * @Version: v1.0
 */
@Component
@Data
@ConfigurationProperties(prefix="pattern") //使用这种方式注入属性，不需要@RefreshScope注解//配置热更新（不重启微服务，按照nacos上配置更新）
public class PatternProperties {
    private String format;
}
