package me.codebase.designPattern.decorator;

/**
 * Created by chendong on 2017/2/20.
 */
public class ComponentInstance implements Component {
    @Override
    public void doSomething() {
        System.out.println("1");
    }
}
