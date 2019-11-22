package com.example.springcloudclients.service;
import	java.io.FileReader;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {


    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;


    @RequestMapping("/show")
    public String getInfo() {

        return "I'm form service:"+serviceName+",port:"+port;
    }
//    @Value("${sen}")
     String value;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "defaultStores")
    public String hi() throws Exception {

        return value;
    }

    public String defaultStores(){
        System.err.println("hiException");
        return "hhh";
    }
}
