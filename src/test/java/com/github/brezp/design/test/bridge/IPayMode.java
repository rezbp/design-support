package com.github.brezp.design.test.bridge;

import com.github.brezp.design.bridge.IMode;

public interface IPayMode extends IMode {

    boolean security(String uId);

}
