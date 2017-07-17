package me.codebase.designPattern.eventDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chendong on 2017/5/10.
 */
public class EventDispatcher {

    private Map<Class<? extends Event>, Handler<? extends Event>> handlers;

    public EventDispatcher() {
        handlers = new HashMap<>();
    }

    public <E extends Event> void registerHandler(Class<E> eventClass, Handler<E> handler) {

        handlers.put(eventClass, handler);
    }

    /**
     * Dispatches an {@link Event} depending on it's type.
     *
     * @param event The {@link Event} to be dispatched
     */
    @SuppressWarnings("unchecked")
    public <E extends Event> void dispatch(E event) {
        Handler<E> handler = (Handler<E>) handlers.get(event.getClass());
        if (handler != null) {
            handler.onEvent(event);
        }
    }

}
