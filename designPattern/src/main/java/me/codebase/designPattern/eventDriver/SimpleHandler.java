package me.codebase.designPattern.eventDriver;

/**
 * Created by chendong on 2017/5/10.
 */
public class SimpleHandler implements Handler<SimpleEvent>{

    @Override
    public void onEvent(SimpleEvent event) {
        System.out.println(event.getUser().getName());
    }
}
