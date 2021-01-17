package com.demo.auth.config;

import com.demo.commons.utils.RedisUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.demo.auth.mapper"})
public class SystemConfig {
    /** 生成RedisUtils实例对象**/
    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }
}
