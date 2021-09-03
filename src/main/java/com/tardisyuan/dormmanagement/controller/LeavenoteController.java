package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.Leavenote;
import com.tardisyuan.dormmanagement.bean.Sc;
import com.tardisyuan.dormmanagement.bean.Student;
import com.tardisyuan.dormmanagement.service.LeavenoteService;
import com.tardisyuan.dormmanagement.service.ScService;
import com.tardisyuan.dormmanagement.service.StudentService;
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

    @Autowired
    private ScService scService;

    @Autowired
    private StudentService studentService;

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
        request.setAttribute("scList",scService.getAll(new Sc()));
        if(lid!=null){
            Leavenote leavenote=leavenoteService.getById(lid);
            request.setAttribute("leavenote",leavenote);
            Student student = studentService.getById(leavenote.getSid());
            leavenote.setSname(student.getSname());
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
