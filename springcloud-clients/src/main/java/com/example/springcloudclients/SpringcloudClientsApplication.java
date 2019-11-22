package com.example.springcloudclients;




import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //允许断路器
@EnableApolloConfig
public class SpringcloudClientsApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringcloudClientsApplication.class, args);
    }


}
