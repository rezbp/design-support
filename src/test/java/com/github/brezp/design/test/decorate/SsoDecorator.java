package com.github.brezp.design.test.decorate;

public abstract class SsoDecorator implements HandlerComponent {

    private HandlerComponent handlerComponent;

    private SsoDecorator(){}

    public SsoDecorator(HandlerComponent handlerComponent) {
        this.handlerComponent = handlerComponent;
    }

    public boolean preHandle(String request, String response, Object handler) {
        return handlerComponent.preHandle(request, response, handler);
    }

}
