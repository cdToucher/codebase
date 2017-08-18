package me.codebase.designPattern.eventDriver;


import me.codebase.designPattern.bean.User;

/**
 * Created by chendong on 2017/5/10.
 */
public class SimpleEvent implements Event {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public SimpleEvent(User user) {
        this.user = user;
    }

    public SimpleEvent() {
    }
}
