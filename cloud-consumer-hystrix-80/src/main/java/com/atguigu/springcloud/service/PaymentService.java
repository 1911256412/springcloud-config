package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "CLOUD-HYSTRIX-PROVIDER", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout")
    public String payment_TimeOut();
}
