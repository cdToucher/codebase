package me.codebase.designPattern.eventDriver;

/**
 * Created by chendong on 2017/5/10.
 */
public interface Handler<E extends Event> {


    void onEvent(E event);


}
