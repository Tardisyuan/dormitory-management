package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.Sc;
import com.tardisyuan.dormmanagement.service.ScService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sc")
public class ScController {
    @Autowired
    private ScService scService;

    @RequestMapping("/page")
    public String page(){
        return  "sc/sc-list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(Integer page, Integer limit, Sc sc){
        return scService.getPage(page,limit,sc);
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer scid, HttpServletRequest request){
        if(scid!=null){
            Sc sc=scService.getById(scid);
            request.setAttribute("sc",sc);
        }
        return "sc/sc-addOrUpdate";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(Sc sc){
        return scService.addOrUpdate(sc);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer scid){
        return scService.delete(scid);
    }
}
