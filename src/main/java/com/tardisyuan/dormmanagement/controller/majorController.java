package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.College;
import com.tardisyuan.dormmanagement.bean.Major;
import com.tardisyuan.dormmanagement.bean.Power;
import com.tardisyuan.dormmanagement.service.CollegeService;
import com.tardisyuan.dormmanagement.service.MajorService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/major")
public class majorController {
    @Autowired
    private MajorService majorService;

    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/page")
    public String page(Model model){
        model.addAttribute("cList",collegeService.getAll(new College()));
        return  "major/major-list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(Integer page, Integer limit, Major major){
        return majorService.getPage(page,limit,major);
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer mid, HttpServletRequest request){
        request.setAttribute("cList",collegeService.getAll(new College()));
        if(mid!=null){
            Major major=majorService.getById(mid);
            request.setAttribute("major",major);
        }
        return "major/major-addOrUpdate";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(Major major){
        return majorService.addOrUpdate(major);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer mid){
        return majorService.delete(mid);
    }
}
