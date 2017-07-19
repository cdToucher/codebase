package me.codebase.utilFramework.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * Created by chendong on 2017/2/10.
 * <p>
 * cache set
 */
public class CacheTest {

    public static void main(String[] args) {

        CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "hello " + key + "!";
            }
        };

        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .build(cacheLoader);
        loadingCache.asMap();
    }

}
