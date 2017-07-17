package me.codebase.designPattern.decorator;

/**
 * Created by chendong on 2017/2/20.
 */
public class CreatedComponent extends AbstractComponent {

    public CreatedComponent(Component instance) {
        super(instance);
    }

    @Override
    public void doSomething() {
        this.instance.doSomething();
        System.out.println("2");
    }
}
