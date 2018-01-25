package me.codebase.runtime;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * Created by chendong on 2018/1/18.
 */
public class SPITest {

    public static void main(String[] args) {

        ServiceLoader<Consumer> serviceLoader = ServiceLoader.load(java.util.function.Consumer.class);
        Iterator<Consumer> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Consumer consumer = iterator.next();
            consumer.accept(2);
        }
    }

}
