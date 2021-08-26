package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.Leavenote;
import com.tardisyuan.dormmanagement.service.LeavenoteService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/leavenote")
public class LeavenoteController {
    @Autowired
    private LeavenoteService leavenoteService;

    @RequestMapping("/page")
    public String page(){
        return  "leavenote/leavenote-list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(Integer page, Integer limit, Leavenote leavenote){
        return leavenoteService.getPage(page,limit,leavenote);
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer lid, HttpServletRequest request){
        if(lid!=null){
            Leavenote leavenote=leavenoteService.getById(lid);
            request.setAttribute("leavenote",leavenote);
        }
        return "leavenote/leavenote-addOrUpdate";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(Leavenote leavenote){
        return leavenoteService.addOrUpdate(leavenote);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer lid){
        return leavenoteService.delete(lid);
    }
}
