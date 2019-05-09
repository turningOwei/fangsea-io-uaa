package io.fangsea.auth.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author shengzhi.wang
 * description 对当前类的描述
 * date 2019/4/16
 */
@Component
public class RedisUtil {

//    private static RedisClientMap redisClient = new RedisClientMap();

    @Autowired
    RedisClient redisClient;

    static RedisUtil redisUtil;

    @PostConstruct
    public void init() {
        redisUtil = this;
        redisUtil.redisClient = this.redisClient;
    }

    /**
     *
     * @param key key值
     * @param value  数据
     */
    public static void save2Redis(String key, Object value, long leaseTime, TimeUnit timeUnit) {
            redisUtil.redisClient.set(key, value, timeUnit.toSeconds(leaseTime));
    }

    /**
     *
     * @param key key值
     * @param value  数据
     */
    public static void save2Redis(String key, Object value) {
        redisUtil.redisClient.set(key, value);
    }

    /**
     *
     * @param key key值
     * @return 数据
     */
    public static Object getFromRedis (String key) {
        return redisUtil.redisClient.get(key);
    }

    /**
     *
     * @param key
     * @return
     */
    public static boolean removeFromRedis (String key) {
        redisUtil.redisClient.del(key);
        return ! redisUtil.redisClient.hasKey(key);
    }
}
