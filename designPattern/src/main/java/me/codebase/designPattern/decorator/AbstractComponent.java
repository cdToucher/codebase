package me.codebase.designPattern.decorator;

/**
 * Created by chendong on 2017/2/20.
 */
public abstract class AbstractComponent implements Component {

    protected Component instance;

    public AbstractComponent(Component instance){
        this.instance = instance;
    }

}
