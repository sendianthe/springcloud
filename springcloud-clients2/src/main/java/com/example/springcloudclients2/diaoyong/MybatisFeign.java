package com.example.springcloudclients2.diaoyong;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name= "mybatis",fallback = Testcon.class)
public interface MybatisFeign {

  @RequestMapping(value = "/test")
     String Test();
     @RequestMapping(value ="/mts")
     String mts();


}
