package com.yunhui.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

/**
 * @Date : 2021/2/8 11:06 上午
 * @Author : dushaoyun
 */
public class RedisTest {

    private Jedis jedis;

    private JedisPool jedisPool;

    /**
     * 初始化Redis连接池
     */
    private void initialPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(10);
        jedisPool = new JedisPool(config, "127.0.0.1", 6379, 1000);
    }

    @Before
    public void init() {
        initialPool();
        jedis = jedisPool.getResource();
    }

    @After
    public void destroy() {
        if (jedis != null) {
            jedis.close();
        }
        if (jedisPool != null) {
            jedisPool.close();
        }
    }

    @Test
    public void testPipelined() {
        Pipeline pipelined = jedis.pipelined();
        String key = "hello";
        int start = 10000;
        String value = "helloworld";
        for (int i = 0; i < 100000; i++) {
            pipelined.set(key + start++, value);
        }
        pipelined.sync();
    }

}
