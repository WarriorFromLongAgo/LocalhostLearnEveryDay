package test;

import com.feijm.util.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*
 * Jedis的测试类
 * */
public class JedisTest {
    @Test
    public void redisTest1() {
//        1，获取连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        2，操作
        jedis.set("userName", "feijm");
//        3，释放资源，关闭资源
        jedis.close();

    }

    /*
     * 连接池对象
     *
     * */

    @Test
    public void redisTest2() {
//        1，创建JedisPool连接池对象
        JedisPool jedisPool = new JedisPool();
//        2，调用方法 getResource()获取连接
        Jedis jedis = jedisPool.getResource();

        jedis.set("hehe", "1234");

        jedis.close();
    }

    @Test
    public void redisTest3() {
//        0，创建一个配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        设置最大的连接数
        jedisPoolConfig.setMaxTotal(50);
//        空闲连接
        jedisPoolConfig.setMaxIdle(10);
//        1，创建JedisPool连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
//        2，调用方法 getResource()获取连接
        Jedis jedis = jedisPool.getResource();

        jedis.set("hehe", "hahahahhahahahaha");

        jedis.close();
    }

    @Test
    public void redisTest4() {
        Jedis jedis = JedisPoolUtil.getJedis();
        String set = jedis.set("address", "hubeisheng");
        System.out.println(set);
        jedis.close();
    }
}

