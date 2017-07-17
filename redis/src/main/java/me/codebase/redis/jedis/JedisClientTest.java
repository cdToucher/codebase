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

    static final String host = "localhost";
    static final int defaultPort = 6379;

    public static void main(String[] args) {
    }

    private static void SharedJedisTest() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo(host, defaultPort);
        List<JedisShardInfo> shards = Lists.newArrayList(jedisShardInfo);
        ShardedJedis shardedJedis = new ShardedJedis(shards);
        System.out.println(shardedJedis.get("test"));
        shardedJedis.close();
    }

    private static void JedisClientTest() {

        Jedis jedis = new Jedis(host, defaultPort);
        System.out.println(jedis.get("test"));
        jedis.close();
    }

}
