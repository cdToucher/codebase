package me.codebase.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by chendong on 2017/1/24.
 * <p>
 * jdk 自带Observer 模式
 */
public class ObserverImpl implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg + "1");
    }
}
