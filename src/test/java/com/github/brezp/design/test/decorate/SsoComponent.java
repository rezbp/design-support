package com.github.brezp.design.test.decorate;

public class SsoComponent implements HandlerComponent {

    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }

}
