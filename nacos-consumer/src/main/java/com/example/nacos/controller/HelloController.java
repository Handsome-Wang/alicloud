package com.example.nacos.controller;

import com.example.nacos.feign.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: nacos-domo
 * @description:
 * @author: wangshuai
 * @create: 2022-04-06 10:21
 **/
@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private TestService testService;

    @GetMapping("/helloFeign")
    public String helloFeign(String name) {
        System.out.println("==============================调用hello");
        String echo = testService.echo(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 返回结果
        return "feign:consumer:" + echo;
    }

    @GetMapping("/message")
    public String message() {
        return "高并发下的问题测试";
    }

    @GetMapping("/hello")
    public String hello(String name) {
        // <1> 获得服务 `demo-provider` 的一个实例
        ServiceInstance instance;
        if (true) {
            // 获取服务 `demo-provider` 对应的实例列表
            List<ServiceInstance> instances = discoveryClient.getInstances("demo-provider");
            // 选择第一个
            instance = instances.size() > 0 ? instances.get(0) : null;
        } else {
            instance = loadBalancerClient.choose("demo-provider");
        }
        // <2> 发起调用
        if (instance == null) {
            throw new IllegalStateException("获取不到实例");
        }
        String targetUrl = instance.getUri() + "/echo?name=" + name;
        String response = restTemplate.getForObject(targetUrl, String.class);
        // 返回结果
        return "consumer:" + response;
    }
}
