package com.example.springcloudclients2.diaoyong;

import org.springframework.stereotype.Component;

@Component
public class Testcon implements MybatisFeign{
    @Override
    public String Test() {
        return "hh";
    }

    @Override
    public String mts() {
        return "hh";
    }
}
