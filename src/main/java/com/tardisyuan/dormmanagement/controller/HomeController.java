package com.tardisyuan.dormmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "home/index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "home/welcome";
    }
}
