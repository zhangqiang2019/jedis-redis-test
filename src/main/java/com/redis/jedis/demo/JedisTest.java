package com.redis.jedis.demo;

import com.cmcc.zeus.dhome.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;
/**
 * @author 张强[zhangqiang]
 * @date 2019年07月31日 - 下午08:33:28
 * @history 2019年07月31日 - 下午08:33:28  create.
 * @description 以连接的方式，通过jedis java客户端远程简单操作redis客户端
 * 设置一个值
 * 获取一个值
 */

public class JedisTest {
//    private Logger                     log                     = LoggerFactory.getLogger(this.getClass().getName());



  /**
   * 测试jedis连接redis服务器
   *
   * @return void
   * @author 张强[zhangqiang]
   * @date 2019年08月01日 - 下午02:30:09
   * @history
   *          2019年08月01日 - 下午02:30:09 张强[zhangqiang] create.
   */
    @Test
    public void testSet(){
        //创建连接
        Jedis connection = new Jedis("192.168.206.155",6379);
//        Jedis connection = new Jedis("172.28.19.80",6380);

      /**
       * @auther zhangqiang
       * @description 连接redis服务器
       * */
//        Jedis connection = new Jedis("172.28.19.85",6380);
//        Jedis connection = new Jedis("172.28.19.89",6380);
//        Jedis connection = new Jedis("172.28.19.80",6381);
//        Jedis connection = new Jedis("172.28.19.85",6381);
//        Jedis connection = new Jedis("172.28.19.89",6381);
//        connection.auth("redis_dhome");
        //执行操作
//        connection.set("name","zhangqiang");
//        Map<String,String> map = connection.hgetAll("hy");
//        Set<String> set = map.keySet();
//        for(String str:set){
//            System.out.println((str+":"+map.get(str)));
//        }
        Set<String> set = connection.keys("*");

        int i=0;
//        String s = connection.hget("hy","zhejiang");
//        System.out.println(s);
        for(String str:set){
            i++;
            System.out.println((i+"//1//"+str));
            try{
                Object value = connection.get(str);
                Object value2 = connection.hget(str,"zhejiang");
                Object value3 = connection.hmget(str,"0");
                System.out.println(i+"////2////"+value.toString());
                System.out.println(i+"////22////"+value2.toString());
                System.out.println(i+"////23////"+value3.toString());
            }catch (Exception e){
                System.out.println(i+"有问题");
            }
        }
        //关闭连接
        connection.close();
    }
}
