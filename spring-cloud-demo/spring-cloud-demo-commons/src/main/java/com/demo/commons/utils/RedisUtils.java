package com.demo.commons.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 重置redis
     */
    public void initRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        redisTemplate = new RedisTemplate <String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
    }


    /**
     * 删除
     *
     * @param key 关键字
     */
    public void delByKey(String key) {
        redisTemplate.delete(key);
    }


//    ---------------key val

    /**
     * 存储key val
     *
     * @param key      关键字
     * @param target   目标数据
     * @param timeUnit 时间类型
     * @param time     时间
     */
    public void storeValue(String key, Object target, TimeUnit timeUnit, long time) {
        redisTemplate.opsForValue().setIfAbsent(key, target, time, timeUnit);
    }


    /**
     * 获取value
     *
     * @param key 关键字
     * @return Object
     */
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }


}
