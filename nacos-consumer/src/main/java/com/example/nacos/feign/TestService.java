package com.example.nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: wangshuai
 * @create: 2022-04-06 10:04
 **/
@FeignClient("demo-provider")//声明调用的提供者的name
public interface TestService {

    //指定调用提供者的哪个方法
//@FeignClient+@GetMapping 就是一个完整的请求路径
    @GetMapping(value = "/echo")
    String echo(@RequestParam("name") String name);
}
