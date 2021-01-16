package com.demo.zuul.config;

import com.demo.commons.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/15
 * @time: 9:25
 */
@Configuration
public class SystemConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }


}
