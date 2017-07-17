package me.codebase.designPattern.observer;

import java.util.Observable;

/**
 * Created by chendong on 2017/1/24.
 * <p>
 * test observer
 * <p>
 * jdk 自带观察者模式 即可比较好解释观察者模式，阅读源码即可
 * <p>
 * java.util.Observable
 * java.util.Observer
 */
public class ObserverTest extends Observable {

    public static void main(String[] args) {
        ObserverTest observable = new ObserverTest();
        observable.addObserver(new ObserverImpl());
        observable.setChanged();
        observable.notifyObservers("notifyObservers");

        System.out.println(observable.countObservers());
    }
}
