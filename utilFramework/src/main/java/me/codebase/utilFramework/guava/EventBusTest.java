package me.codebase.utilFramework.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by chendong on 2017/2/10.
 * <p>
 * event bus test
 */
public class EventBusTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus("ifEvent");
        System.out.println(eventBus.identifier());
        System.out.println(eventBus.toString());

        eventBus.register(new Listener());
        eventBus.post(new Event(1876715975));
    }

    static class Listener {
        @Subscribe
        public void listen(Event event) {
            System.out.println("daile number " + event.getCallNumber());
        }
    }

    static class Event {

        public Event(int callNumber) {
            this.callNumber = callNumber;
        }

        public int getCallNumber() {
            return callNumber;
        }

        public void setCallNumber(int callNumber) {
            this.callNumber = callNumber;
        }

        private int callNumber;

    }
}
