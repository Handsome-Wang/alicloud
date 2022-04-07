package com.example.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: nacos-domo
 * @description:
 * @author: wangshuai
 * @create: 2022-04-06 10:20
 **/
@RestController
public class TestController {

    @GetMapping("/echo")
    public String echo(String name) {
        return "provider:" + name;
    }
}
