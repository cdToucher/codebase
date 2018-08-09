package me.codebase.common.test;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import me.codebase.common.utils.ClassIntroSpector;
import me.codebase.common.utils.ObjectInfo;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CacheTest {


    public void cacheTest() {

    }

    Cache<String, Integer> cache = CacheBuilder.newBuilder()
            .initialCapacity(120000)
            .maximumSize(10000000)
            .concurrencyLevel(100)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build();

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(getDeepSize());
    }

    private static long getDeepSize() throws IllegalAccessException {
        CacheTest test = new CacheTest();
        for (int i = 0; i < 100000; i++) {
            test.cache.put(UUID.randomUUID().toString(), 1);
        }
        final ClassIntroSpector ci = new ClassIntroSpector();
        ObjectInfo res = ci.introspect(test);
        test.cache.getIfPresent("wefdfsdfdsfdsfsdf");
        return res.getDeepSize();
    }


}
