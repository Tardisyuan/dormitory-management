package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.Classes;
import com.tardisyuan.dormmanagement.bean.Major;
import com.tardisyuan.dormmanagement.bean.Sc;
import com.tardisyuan.dormmanagement.service.ClassesService;
import com.tardisyuan.dormmanagement.service.MajorService;
import com.tardisyuan.dormmanagement.service.ScService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private ScService scService;

    @RequestMapping("/page")
    public String page(Model model){
        model.addAttribute("mList",majorService.getAll(new Major()));
        model.addAttribute("scList",scService.getAll(new Sc()));
        return  "classes/classes-list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(Integer page, Integer limit, Classes classes){
        return classesService.getPage(page,limit,classes);
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer cid, HttpServletRequest request){
        request.setAttribute("mList",majorService.getAll(new Major()));
        request.setAttribute("scList",scService.getAll(new Sc()));
        if(cid!=null){
            Classes classes=classesService.getById(cid);
            request.setAttribute("classes",classes);
        }
        return "classes/classes-addOrUpdate";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(Classes classes){
        return classesService.addOrUpdate(classes);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer cid){
        return classesService.delete(cid);
    }
}
