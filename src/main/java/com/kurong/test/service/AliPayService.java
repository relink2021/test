package com.kurong.test.service;

import com.alipay.api.AlipayApiException;
import com.kurong.test.pojo.Order;

public interface AliPayService {
    /**
     * 支付宝支付接口
     * @param order
     * @return
     * @throws AlipayApiException
     */
    String aliPay(Order order) throws AlipayApiException;
}
