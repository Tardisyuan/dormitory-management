package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.Power;
import com.tardisyuan.dormmanagement.bean.User;
import com.tardisyuan.dormmanagement.service.PowerService;
import com.tardisyuan.dormmanagement.util.R;
import com.tardisyuan.dormmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PowerService powerService;

    @RequestMapping(value = "/adminlogin",method = RequestMethod.POST)
    @ResponseBody
    public R login(User user, HttpSession session){
        /*调用service的登录方法，失败返回null*/
        user=userService.login(user);
        if(user!=null){
            Power power=powerService.getById(user.getPowerid());//获取权限信息
            if(power.getStatus()==1){
                session.setAttribute("loginInfo",user);
                return R.ok();
            }
            return new R(0,"该账号已被封禁，请联系管理员！");
        }else{
            return new R(0,"用户名或密码不正确！");
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();//销毁session
        return "redirect:/index.jsp";
    }
}
