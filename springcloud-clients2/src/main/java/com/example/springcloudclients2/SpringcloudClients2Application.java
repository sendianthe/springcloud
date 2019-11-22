package com.example.springcloudclients2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableZuulProxy
//@ComponentScan("com.example.springcloudclients2.diaoyong")
public class SpringcloudClients2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudClients2Application.class, args);
    }

}
