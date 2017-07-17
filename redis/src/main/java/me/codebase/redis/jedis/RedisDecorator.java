package me.codebase.redis.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * Created by chendong on 2016/7/7
 * redis代理类，节省开关resource的操作
 */
public class RedisDecorator {

    private static final Logger log = LoggerFactory.getLogger(RedisDecorator.class);

    public static Jedis getResource() {
        return RedisPool.getPool().getResource();
    }

    public interface _Function<T> {
        T execute(Jedis jedis);
    }

    public static <T> T execute(_Function<T> function) {
        T result;
        try (Jedis jedis = getResource()) {
            result = function.execute(jedis);
        } catch (JedisConnectionException e) {
            log.error("连接redis失败");
            throw e;
        } catch (Exception e) {
            log.error("执行redis指令失败:{}", e);
            throw e;
        }
        return result;
    }

    public interface __Function {
        void execute(Jedis jedis);
    }

    public static void executeWithoutResponse(__Function function) {
        try (Jedis jedis = getResource()) {
            function.execute(jedis);
        } catch (JedisConnectionException e) {
            log.error("连接redis失败");
            throw e;
        } catch (Exception e) {
            log.error("执行redis指令失败:{}", e);
            throw e;
        }
    }

    public interface ___Function {
        void execute(Pipeline pipeline);
    }

    public static void executePipeline(___Function function) {
        Pipeline pipeline;
        try (Jedis jedis = getResource()) {
            pipeline = jedis.pipelined();
            function.execute(pipeline);
            pipeline.sync();
        } catch (JedisConnectionException e) {
            log.error("连接redis失败");
            throw e;
        } catch (Exception e) {
            log.error("执行redis指令失败:{}", e);
            throw e;
        }
    }
}
