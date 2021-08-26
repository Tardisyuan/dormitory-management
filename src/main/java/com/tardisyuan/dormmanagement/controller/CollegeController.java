package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.College;
import com.tardisyuan.dormmanagement.service.CollegeService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/page")
    public String page(){
        return  "college/college-list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(Integer page, Integer limit, College college){
        return collegeService.getPage(page,limit,college);
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer collegeid, HttpServletRequest request){
        if(collegeid!=null){
            College college=collegeService.getById(collegeid);
            request.setAttribute("college",college);
        }
        return "college/college-addOrUpdate";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(College college){
        return collegeService.addOrUpdate(college);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer collegeid){
        return collegeService.delete(collegeid);
    }
}
