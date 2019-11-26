package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JedisPoolUtil {
    /*
     * 获取连接的方法
     *
     * */

    private static JedisPool jedisPool;

    static {
        try {
            String path = JedisPoolUtil.class.getClassLoader().getResource("jedis.properties").getPath();
            System.out.println(path);
            Properties properties = new Properties();
            properties.load(new FileReader(path));

            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
            jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

            String host = properties.getProperty("host");
            Integer port = Integer.parseInt(properties.getProperty("port"));

            jedisPool = new JedisPool(jedisPoolConfig, host, port);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


}
