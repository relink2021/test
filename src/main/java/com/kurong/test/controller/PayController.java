package com.kurong.test.controller;

import com.alipay.api.AlipayApiException;
import com.kurong.test.pojo.Order;
import com.kurong.test.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class PayController {
    @Autowired
    private AliPayService aliPayService;
    /**
     * 支付宝支付 api
     *
     * @param outTradeNo
     * @param subject
     * @param totalAmount
     * @param description
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping(value = "/Submit")
    public String alipay(@RequestParam("outTradeNo") String outTradeNo, @RequestParam("subject") String subject,
                         @RequestParam("totalAmount") String totalAmount, @RequestParam("description") String description) throws AlipayApiException {
        Order order = new Order();
        order.setOut_trade_no(outTradeNo);
        order.setSubject(subject);
        order.setTotal_amount(totalAmount);
        order.setDescription(description);
        System.out.println(order);
        return aliPayService.aliPay(order);
    }
}
