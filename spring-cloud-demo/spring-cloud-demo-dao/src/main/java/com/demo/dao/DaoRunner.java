package com.demo.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/15
 * @time: 10:08
 */
@EnableEurekaClient
@SpringBootApplication
public class DaoRunner {
    public static void main(String[] args) {
        SpringApplication.run(DaoRunner.class, args);
        System.out.println("\ndaoserver success\n");
    }
}
