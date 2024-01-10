package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        Order order = orderService.queryOrderById(orderId);

        //根据restTemplate远程调用，发起http请求实现远程调用
        /*服务消费者不能把服务提供者的ip+port硬编码到代码中  */
//        String url = "http://localhost:8081/user/" + order.getUserId();

        //修改访问的url路径，用服务名userService代替ip、端口：
        String url = "http://userService/user/" + order.getUserId();
//        ResponseEntity<User> forEntity = restTemplate.getForEntity(url, User.class);
//        User body = forEntity.getBody();
        User userForObj = restTemplate.getForObject(url, User.class);

        order.setUser(userForObj);
        return order;
    }
}
