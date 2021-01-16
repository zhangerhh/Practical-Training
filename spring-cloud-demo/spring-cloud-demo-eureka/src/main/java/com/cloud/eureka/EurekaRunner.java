package com.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/13
 * @time: 17:20
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaRunner {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRunner.class, args);
        System.out.println("\neureka success\n");
    }
}
