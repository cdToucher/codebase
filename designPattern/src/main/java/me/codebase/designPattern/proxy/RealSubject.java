package me.codebase.designPattern.proxy;

/**
 * Created by chendong on 2017/2/20.
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("do something!");
    }

    public final void doSomeOther(){
        System.out.println("do someOther!");
    }
}
