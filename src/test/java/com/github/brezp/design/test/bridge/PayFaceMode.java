package com.github.brezp.design.test.bridge;

public class PayFaceMode implements IPayMode{

    public boolean security(String uId) {
        System.out.println("人脸支付，风控校验脸部识别");
        return true;
    }

}