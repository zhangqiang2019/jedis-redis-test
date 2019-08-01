package com.redis.jedis.demo;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * 通过jedis连接池简单操作redis
 * 设置一个值
 * 获取一个值
 * @author 张强[zhangqiang]
 * @date 2019年08月01日 - 下午03:19:42
 * @history
 *          2019年08月01日 - 下午03:19:42 张强[zhangqiang] create.
 */

public class JedisPoolTest {


  /**
   * @author 张强[zhangqiang]
   * @date 2019年08月01日 - 下午03:20:54
   * @history
   *          2019年08月01日 - 下午03:20:54 张强[zhangqiang] create.
   */
    @Test
    public void testSet() {

        //（1）创建连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //（2）对配置对象进行配置
        config.setMaxIdle(2);//最小连接数
        config.setMaxTotal(10);//最大连接池
        config.setMaxWaitMillis(1000*2);//最大等待时间2秒
        config.setTestOnBorrow(true);//获取连接时测试连接是否畅通
        //（3）通过连接池配置对象创建连接池对象
        JedisPool pool = new JedisPool(config,"192.168.206.155",6379);
        //（4）从连接池中获取对象
        Jedis connection = pool.getResource();
        //（5）测试
        System.out.println(connection.get("name"));
        //（6）释放连接
        connection.close();//该方法是两用的，既可以关闭，又可以释放。
        //（7）在测试环境需要摧毁连接池，但是在实际开发中，是spring的一个单例
        //项目启动中永远存在
        pool.destroy();


    }
}
