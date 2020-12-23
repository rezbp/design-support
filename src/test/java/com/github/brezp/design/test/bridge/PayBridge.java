package com.github.brezp.design.test.bridge;



import com.github.brezp.design.bridge.IBridge;

import java.math.BigDecimal;

public abstract class PayBridge implements IBridge {

    protected IPayMode payMode;

    public PayBridge(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String pay(String uId, String tradeId, BigDecimal amount);

}
