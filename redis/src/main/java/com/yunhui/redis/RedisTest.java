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
        jedisPool = new JedisPool(config, "test.database7300.scsite.net", 7300, 1000);
    }

    @Before
    public void init() {
        initialPool();
        jedis = jedisPool.getResource();
        jedis.auth("lvEfWo2KTEssPg93");
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
        String zkey = "hello";
        for (int i = 0; i < 200; i++) {
            pipelined.zadd(zkey, i, zkey + i);
        }
        pipelined.sync();
    }


}
