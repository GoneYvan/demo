package com.company.redis;

import com.sun.javafx.logging.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/7/16 0016.
 * 封装redis帮助类
 */
public class RedisProvider {

    protected static final Logger LOG = (Logger) LoggerFactory.getLogger(RedisProvider.class);
    protected static JedisPool jedispool;
    protected static int EXPIRE = 130;
    static{
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        if (bundle == null) {
            throw new IllegalArgumentException(
                    "[redis.properties] is not found!");
        }

        EXPIRE = Integer.valueOf(bundle.getString("redis.expire"));

        JedisPoolConfig jedisconfig = new JedisPoolConfig();
        jedisconfig.setMaxTotal(Integer.valueOf(bundle
                .getString("redis.pool.maxActive")));
        jedisconfig.setMaxIdle(Integer.valueOf(bundle
                .getString("redis.pool.maxIdle")));
        jedisconfig.setMaxWaitMillis(Long.valueOf(bundle
                .getString("redis.pool.maxWait")));
        jedisconfig.setTestOnBorrow(Boolean.valueOf(bundle
                .getString("redis.pool.testOnBorrow")));
        jedisconfig.setTestOnReturn(Boolean.valueOf(bundle
                .getString("redis.pool.testOnReturn")));
        jedispool = new JedisPool(jedisconfig, bundle.getString("redis.ip"),
                Integer.valueOf(bundle.getString("redis.port")), 100000);
    }

    public static Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = jedispool.getResource();
        } catch (JedisConnectionException jce) {
            ExceptionUtil.getTrace(jce);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                ExceptionUtil.getTrace(e);
            }
            jedis = jedispool.getResource();
        }
        return jedis;
    }

    public static void returnResource(JedisPool pool, Jedis jedis) {
        if (jedis != null) {
            pool.returnResource(jedis);
        }
    }

//    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
//        jedis.set("runoobkey", "www.runoob.com");
//        // 获取存储的数据并输出
//        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
//    }
}
