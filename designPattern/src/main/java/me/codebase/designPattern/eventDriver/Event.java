package me.codebase.designPattern.eventDriver;

/**
 * Created by chendong on 2017/5/10.
 */
public interface Event {

    default Class<? extends Event> getType() {
        return getClass();
    }

//    Class<? extends Event> getType();
}
