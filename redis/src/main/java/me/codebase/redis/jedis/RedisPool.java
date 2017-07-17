package me.codebase.redis.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.Pool;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by chendong on 2016/5/19
 */
public class RedisPool {

    private static final Logger log = LoggerFactory.getLogger(RedisPool.class);

    private Pool<Jedis> jedisPool;

    private static RedisPool instance;


    private RedisPool() {
        getRightPool();
    }

    public static Pool<Jedis> getPool() {
        return getInstance().jedisPool;
    }

    private static RedisPool getInstance() {
        if (instance == null) {
            synchronized (RedisPool.class) {
                if (instance == null) {
                    instance = new RedisPool();
                }
            }
        }
        return instance;
    }

    private void getRightPool() {
        try {
            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setMaxIdle(10);
            poolConfig.setMinIdle(2);
            poolConfig.setMaxTotal(100);
            String pwd = null;
            boolean isSentinel = false;
            if (pwd == null || "".equals(pwd))
                pwd = null;
            if (!isSentinel)
                this.jedisPool = new JedisPool(poolConfig, "localhost", 6379, 3000, pwd, 0);
            else {
                Set<String> sentinels = Arrays.stream("localhost:26379"
                        .split(",")).collect(Collectors.toSet());
                this.jedisPool = new JedisSentinelPool("Test cluster",
                        sentinels, poolConfig, 3000, pwd, 0);
            }
        } catch (Exception e) {
            log.error("Wrong redis configuration！", e.getMessage());
        }
    }
}
