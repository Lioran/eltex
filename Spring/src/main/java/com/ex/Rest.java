package com.ex;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
class Rest{
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
