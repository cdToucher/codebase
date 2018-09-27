package me.codebase.common.test;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import me.codebase.common.utils.ClassIntroSpector;
import me.codebase.common.utils.ObjectInfo;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CacheTest {


    public void cacheTest() {

    }

    Cache<String, Integer> cache = CacheBuilder.newBuilder()
            .initialCapacity(120000)
            .maximumSize(10000000)
            .concurrencyLevel(100)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build();

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


    private static final Cache<String, Blacklist> BLACKLIST_CACHE = CacheBuilder.newBuilder()
            .initialCapacity(20000)
            .build();


    public static void main(String[] args) throws IllegalAccessException {
        Blacklist blacklist = new Blacklist();
        blacklist.setCreator("TEST");
        blacklist.setDimension(1);
        blacklist.setId(1212122L);
        blacklist.setMemo("setsete");
        blacklist.setRiskRank(1);
        blacklist.setSrc("serwerw");
        blacklist.setVal("sdsfdfd");
        IntStream.range(0, 100000).forEach(i -> BLACKLIST_CACHE.put(UUID.randomUUID().toString(), blacklist));
        final ClassIntroSpector ci = new ClassIntroSpector();
        ObjectInfo res = ci.introspect(BLACKLIST_CACHE);
        System.out.println(res.getDeepSize()/1024D/1024D);
    }


}
