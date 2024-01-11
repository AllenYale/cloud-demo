package cn.itcast.order.client;

import cn.itcast.order.config.DefaultLogConfiguration;
import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: UserClient
 * PackageName: cn.itcast.order.client
 * Description:
 *  userClient 声明所有对userService发起的远程调用
 *
 * @Author: Hanyu
 * @Date: 24/01/11 - 07:45
 * @Version: v1.0
 */
@FeignClient(value = "userService", configuration = DefaultLogConfiguration.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    public User queryById(@PathVariable("id") Long id);
}
