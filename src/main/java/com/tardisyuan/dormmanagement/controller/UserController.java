package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.Power;
import com.tardisyuan.dormmanagement.bean.User;
import com.tardisyuan.dormmanagement.service.PowerService;
import com.tardisyuan.dormmanagement.service.UserService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PowerService powerService;

    @RequestMapping("/page")
    public String page(Model model){
        List<Power> pList= powerService.getAll(new Power());
        model.addAttribute("pList",pList);
        return "user/user-list";
    }
    @RequestMapping("/list")
    @ResponseBody
    public R list(Integer page, Integer limit, User user){
        return userService.getPage(page,limit,user);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer id){
        return userService.delete(id);
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, HttpServletRequest request){
        if(id!=null){
            request.setAttribute("user",userService.getById(id));
        }
        Power power=new Power();
        request.setAttribute("pList",powerService.getAll(power));
        return "user/user-addOrUpdate";
    }
    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(User user){
        return userService.addOrUpdate(user);
    }


    @RequestMapping("/checkUserName")
    @ResponseBody
    public R checkUserName(String username){
        return userService.checkUsername(username);
    }

    @RequestMapping("/toPwd")
    public String toPwd(){
        return "user/user-password";
    }

    @RequestMapping("/checkPwd")
    @ResponseBody
    public R checkPwd(User user){
        return userService.checkPassword(user);
    }

}
