package myjava.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by YRP-Laptop on 2018/1/6.
 */
public class RedisTest {

    public static final String IP_ADDRESS = "192.168.239.128";
    //    public static final String IP_ADDRESS = "localhost";
    public static final String PASSWORD = "1210933445";
    public static final int IP_PORT = 6379;
    public static final int TIME_OUT = 2000;

    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis(IP_ADDRESS);
//        System.out.println("Windows连接Linux的redis已经成功"+(jedis==null));
        if (jedis != null) {
            jedis.auth(PASSWORD);
            System.out.println("connect to redis server sucessfully");
        }
//        jedis.set("gender", "male");
        System.out.println("Linux的redis存储的内容是：" + jedis.get("gender"));
    }
}
