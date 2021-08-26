package com.tardisyuan.dormmanagement.controller;

import com.tardisyuan.dormmanagement.bean.*;
import com.tardisyuan.dormmanagement.service.*;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private ScService scService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private DormService dormService;

    @Autowired
    private PowerService powerService;

    @RequestMapping("/page")
    public String page(Model model){
        model.addAttribute("mList",majorService.getAll(new Major()));
        model.addAttribute("scList",scService.getAll(new Sc()));
        model.addAttribute("collList",collegeService.getAll(new College()));
        model.addAttribute("cList",classesService.getAll(new Classes()));
        model.addAttribute("dList",dormService.getAll(new Dorm()));
        return  "student/student-list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(Integer page, Integer limit, Student student){
        return studentService.getPage(page,limit,student);
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer sid, HttpServletRequest request){
        request.setAttribute("pList",powerService.getAll(new Power()));
        request.setAttribute("collList",collegeService.getAll(new College()));
        request.setAttribute("cList",classesService.getAll(new Classes()));
        if(sid!=null){
            Student student=studentService.getById(sid);
            Dorm dorm = dormService.getById(student.getDid());
            student.setDhno(dorm.getDhno());
            student.setDno(dorm.getDno());
            student.setDbno(dorm.getDbno());
            request.setAttribute("student",student);
        }
        return "student/student-addOrUpdate";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public R doUpdate(Student student){
        Dorm dorm = new Dorm();
        dorm.setDhno(student.getDhno());
        dorm.setDno(student.getDno());
        dorm.setDbno(student.getDbno());
        List<Dorm> dList= dormService.getAll(dorm);
        if (dList.isEmpty()){
            return new R(0,"无此宿舍号");
        }
        student.setDid(dList.get(0).getDid());
        return studentService.addOrUpdate(student);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(Integer sid){
        return studentService.delete(sid);
    }
}
