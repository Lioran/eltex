package com.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HTML{
    @GetMapping("/")
    public String welcome(){
        return "index";
    }
}
