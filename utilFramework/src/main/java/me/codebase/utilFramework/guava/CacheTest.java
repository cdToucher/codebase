package me.codebase.utilFramework.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * Created by chendong on 2017/2/10.
 * <p>
 * cache set
 */
public class CacheTest {


    private static LoadingCache<String, String> loadingCache;

    public static void main(String[] args) throws Exception {

        CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "hello " + key + "!";
            }
        };

        loadingCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(100, TimeUnit.SECONDS)
                .build(cacheLoader);
        loadingCache.put("test1", "1");
        loadingCache.put("test2", "2");
        loadingCache.put("test3", "3");

        cacheLoader.reload("test1", "11");
        cacheLoader.reload("test2", "22");
        cacheLoader.reload("test3", "33");

        System.out.println(loadingCache.get("test1"));
        System.out.println(loadingCache.get("test2"));
        System.out.println(loadingCache.get("test3"));
    }

}
