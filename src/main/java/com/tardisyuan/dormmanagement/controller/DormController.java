package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.Dorm;
import com.tardisyuan.dormmanagement.service.DormService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dorm")
public class DormController {
    @Autowired
    private DormService dormService;

    @RequestMapping("/page")
    public String page(){
        return  "dorm/dorm-list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(Integer page, Integer limit, Dorm dorm){
        return dormService.getPage(page,limit,dorm);
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Long did, HttpServletRequest request){
        if(did!=null){
            Dorm dorm=dormService.getById(did);
            request.setAttribute("dorm",dorm);
        }
        return "dorm/dorm-addOrUpdate";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(Dorm dorm){
        return dormService.addOrUpdate(dorm);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Long did){
        return dormService.delete(did);
    }
}
