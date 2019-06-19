package com.wzh.wx_pay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Deviler
 * @date 2019/6/19 -14:29
 */
@RestController
public class TestController {
    @GetMapping("hello")
    public String hello(){
        return "hello spring boot";
    }
}
