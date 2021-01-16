package com.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 16:01
 */
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
@SpringBootApplication
public class ZuulRunner {
    public static void main(String[] args) {
        SpringApplication.run(ZuulRunner.class, args);
        System.out.println("\nzuul success\n");
    }
}
