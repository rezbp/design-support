package com.github.brezp.design.test.decorate;

public interface HandlerComponent {

    boolean preHandle(String request, String response, Object handler);

}
