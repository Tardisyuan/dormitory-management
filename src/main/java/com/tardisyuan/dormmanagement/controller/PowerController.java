package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.Power;
import com.tardisyuan.dormmanagement.service.PowerService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    @RequestMapping("/page")
    public String toPage(){
        return "power/power-list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R getList(Integer page, Integer limit, Power power){
        return powerService.page(page,limit,power);
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, HttpServletRequest request){
        if(id!=null){
            Power power=powerService.getById(id);
            request.setAttribute("power",power);
        }
        return "power/power-addOrUpdate";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(Power power){
        return powerService.addOrUpdate(power);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer id){
        return powerService.delete(id);
    }

}
