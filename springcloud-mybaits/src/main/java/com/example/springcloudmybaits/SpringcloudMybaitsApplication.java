package com.example.springcloudmybaits;

import com.example.springcloudmybaits.dao.Pet;
import com.example.springcloudmybaits.dao.PetDao;
import com.example.springcloudmybaits.dao.PetExample;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@MapperScan("com.example.*")
@EnableEurekaClient
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringcloudMybaitsApplication {
    @Autowired
    PetDao dao;
    private static Logger LOGGER = LoggerFactory.getLogger(SpringcloudMybaitsApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudMybaitsApplication.class, args);
    }

    @RequestMapping("/test")
    public String Test(){

       PetExample p = new PetExample();
       p.setLimit(10000);
//       p.setOffset(10L);
        List<Pet> pets = dao.selectByExample(p);
        LOGGER.info(pets.toString());
        return pets.toString();

    }
}
