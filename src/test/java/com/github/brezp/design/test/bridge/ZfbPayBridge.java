package com.github.brezp.design.test.bridge;

import java.math.BigDecimal;

public class ZfbPayBridge extends PayBridge {

    public ZfbPayBridge(IPayMode payMode) {
        super(payMode);
    }

    public String pay(String uId, String tradeId, BigDecimal amount) {
        return "ZFB";
    }

}
