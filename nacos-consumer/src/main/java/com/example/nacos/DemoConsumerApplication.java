package com.example.nacos; /**
 * @Description :
 * @Author : wangshuai
 * @Date: 2022-02-10 09:45
 */

import com.example.nacos.feign.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @className : com.example.nacos.DemoProviderApplication
 * @description :   
 * @author : wangshuai
 * @date : 2022-02-10 09:45  
 */
@SpringBootApplication
@EnableFeignClients//开启Fegin
public class DemoConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoConsumerApplication.class, args);
    }

}
