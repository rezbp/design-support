package com.github.brezp.design.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * 一个被观察者对象可以有数个观察者对象，每个观察者对象都是实现Observer接口的对象
 * @author brezp
 */
public interface IObserver extends Observer {

    @Override
    void update(Observable o, Object arg);
}
