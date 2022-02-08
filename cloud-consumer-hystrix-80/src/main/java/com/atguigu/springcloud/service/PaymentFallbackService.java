package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    public String payment_OK(Integer id) {
        return "接口实现类的降级方法ok的80";
    }

    public String payment_TimeOut() {
        return "接口实现类的降级方法timeout的80";
    }

}
