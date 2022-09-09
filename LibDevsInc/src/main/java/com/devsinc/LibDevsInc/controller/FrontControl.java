package com.devsinc.LibDevsInc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControl {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
