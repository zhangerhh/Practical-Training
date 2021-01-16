package com.demo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 9:31
 */
@SpringBootApplication
@EnableEurekaClient
public class AuthRunner {
    public static void main(String[] args) {
        SpringApplication.run(AuthRunner.class, args);
        System.out.println("\nauthServer success\n");
    }
}
