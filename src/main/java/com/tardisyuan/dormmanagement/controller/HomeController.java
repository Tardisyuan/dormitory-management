package com.tardisyuan.dormmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(HttpSession session){
        if(session.getAttribute("loginInfo") == null){
            return "redirect:/index.jsp";
        }
        return "home/index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "home/welcome";
    }
}
