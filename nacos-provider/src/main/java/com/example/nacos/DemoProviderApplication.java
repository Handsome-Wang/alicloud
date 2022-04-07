package com.example.nacos; /**
 * @Description :
 * @Author : wangshuai
 * @Date: 2022-02-10 09:45
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className : com.example.nacos.DemoProviderApplication
 * @description :   
 * @author : wangshuai
 * @date : 2022-02-10 09:45  
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//开启Fegin
public class DemoProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoProviderApplication.class, args);
    }


}
