package me.codebase.java8.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;


/**
 * this is an important concurrent base class
 *
 * leave some time to it
 */
public class AQSTest {

    // TODO: 2018/8/17  Make a demo
    private static final class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
    }

    private final Sync sync = new Sync();


}
