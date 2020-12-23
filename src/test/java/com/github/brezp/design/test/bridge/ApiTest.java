package com.github.brezp.design.test.bridge;

import org.junit.Test;

import java.math.BigDecimal;

public class ApiTest {

    @Test
    public void test_pay() {

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        PayBridge wxPay = new WxPayBridge(new PayFaceMode());
        wxPay.pay("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        PayBridge zfbPay = new ZfbPayBridge(new PayFingerprintMode());
        zfbPay.pay("jlu19dlxo111", "100000109894", new BigDecimal(100));

    }

}
