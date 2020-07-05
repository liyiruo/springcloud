package com.liyiruo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liyiruo
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer_6002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_6002.class, args);
    }
}
