package com.demo.auth.config;

import com.demo.commons.utils.RedisUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 16:09
 */
@Configuration
@MapperScan({"com.demo.auth.mapper"})
public class SystemConfig {

    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }
}
