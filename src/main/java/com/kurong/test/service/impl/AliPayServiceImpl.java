package com.kurong.test.service.impl;

import com.alipay.api.AlipayApiException;
import com.kurong.test.config.Alipay;
import com.kurong.test.pojo.Order;
import com.kurong.test.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AliPayServiceImpl implements AliPayService {

    @Autowired
    private Alipay alipay;

    @Override
    public String aliPay(Order order) throws AlipayApiException {
        return alipay.pay(order);
    }
}
