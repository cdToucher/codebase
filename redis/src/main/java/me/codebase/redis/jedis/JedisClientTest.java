package me.codebase.redis.jedis;

import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

import java.util.List;

/**
 * Created by chendong on 2017/7/17.
 */
public class JedisClientTest {

    static final String host = "dev.config.duibar.com";
    static final String pwsd = "duiba123";
    static final int defaultPort = 6379;

    public static void main(String[] args) throws InterruptedException {
        JedisClientTest1();
    }

    private static void SharedJedisTest() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo(host, defaultPort);
        List<JedisShardInfo> shards = Lists.newArrayList(jedisShardInfo);
        ShardedJedis shardedJedis = new ShardedJedis(shards);
        System.out.println(shardedJedis.get("test"));
        shardedJedis.close();
    }

    private static void JedisClientTest1() throws InterruptedException {
        JedisShardInfo shardInfo = new JedisShardInfo(host,defaultPort);
        shardInfo.setPassword(pwsd);
        try(Jedis jedis = new Jedis(shardInfo)) {
            String value = jedis.set("test", "1", "nx", "ex", 5);
            System.out.println(value);
            Thread.sleep(4000);
            jedis.close();
            System.out.println(jedis.get("test"));
        }

    }

    private static void JedisClientTest() {
        Jedis jedis = new Jedis(host, defaultPort);
        if (jedis.setnx("test", "1") == 1) {
            jedis.set("test", "this is a test");
            System.out.println(jedis.get("test"));
            jedis.del("test");
        } else {
            System.out.println("1");
        }
        jedis.close();
    }

}
