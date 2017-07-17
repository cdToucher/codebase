package me.codebase.designPattern.eventDriver;

import me.codebase.beans.User;

/**
 * Created by chendong on 2017/5/10.
 */
public class App {

    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerHandler(SimpleEvent.class, new SimpleHandler());

        User user = new User();
        user.setName("dsdssd");
        dispatcher.dispatch(new SimpleEvent(user));
    }
}
