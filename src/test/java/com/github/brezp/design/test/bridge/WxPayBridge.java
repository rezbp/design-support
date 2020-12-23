package com.github.brezp.design.test.bridge;

import java.math.BigDecimal;


public class WxPayBridge extends PayBridge {

    public WxPayBridge(IPayMode payMode) {
        super(payMode);
    }

    public String pay(String uId, String tradeId, BigDecimal amount) {
        return "WX";
    }

}
