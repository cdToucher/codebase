package me.codebase.designPattern.eventDriver;

/**
 * Created by chendong on 2017/5/10.
 */
public abstract class AbstractEvent implements Event {

    @Override
    public Class<? extends Event> getType() {
        return getClass();
    }

}
