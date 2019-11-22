package com.example.springcloudclients2.diaoyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowFeignService {

    @Autowired
    Diaoyongs d ;
    @Autowired
    MybatisFeign mybatis;
    @RequestMapping("/shows")
    public String getInfo(){

        return d.getInfo();
//        return "test";
    }

    @RequestMapping("/mybatis")
    public String mybatis(){
//        String test = mybatis.Test();
         String test = mybatis.mts();
        return test;
    }

}
