package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Hander")
public class PaymentController {

    @Resource
    private PaymentService service;

    @GetMapping("/consumer/payment/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        return service.payment_OK(id);
    }

//    @HystrixCommand(fallbackMethod = "payment_TimeoutHander",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//            })
    @HystrixCommand
    @GetMapping("/consumer/payment/timeout")
    public String payment_TimeOut() {

        int n = 10 / 0;
        return service.payment_TimeOut();
    }

    public String payment_TimeoutHander() {
        return "程序运行错误或者异常80，请稍后再试 ";
    }
    public String payment_Hander(){
        return "通用的降级服务";
    }

}
