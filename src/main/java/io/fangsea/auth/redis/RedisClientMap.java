package io.fangsea.auth.redis;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengzhi.wang
 * description 对当前类的描述
 * date 2019/4/16
 */
@Component
public class RedisClientMap {

    private Map<String,Object> redisMap = new HashMap<>();

    public void put(String key, Object obj) {
        redisMap.put(key,obj);
    }

    public Object get(String key) {
        return redisMap.get(key);
    }

    public boolean remove(String key) {
        redisMap.remove(key);
        return !redisMap.containsKey(key);
    }


}
