package cn.itcast.order.service;

import cn.itcast.order.client.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        User user = userClient.queryById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }

   /* public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //根据restTemplate远程调用，发起http请求实现远程调用
        *//*服务消费者不能把服务提供者的ip+port硬编码到代码中  *//*
//        String url = "http://localhost:8081/user/" + order.getUserId();

        //修改访问的url路径，用服务名userService代替ip、端口：
        String url = "http://userService/user/" + order.getUserId();
//        ResponseEntity<User> forEntity = restTemplate.getForEntity(url, User.class);
//        User body = forEntity.getBody();
        User userForObj = restTemplate.getForObject(url, User.class);

        order.setUser(userForObj);
        // 4.返回
        return order;
    }*/
}
