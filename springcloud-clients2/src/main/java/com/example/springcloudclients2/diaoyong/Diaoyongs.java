package com.example.springcloudclients2.diaoyong;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "eureka-client")
public interface Diaoyongs {

   @RequestMapping(value = "/show",method = RequestMethod.GET)
    String getInfo();
}
