package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.Student;
import com.tardisyuan.dormmanagement.mapper.StudentMapper;
import com.tardisyuan.dormmanagement.service.StudentService;
import com.tardisyuan.dormmanagement.util.MD5Util;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(Student student) {
        student.setSpassword(MD5Util.MD5(student.getSpassword()));
        return studentMapper.login(student);
    }

    @Override
    public R getPage(int page, int limit, Student student) {

        PageHelper.startPage(page,limit);//在查询方法前一行调用
        List<Student> list= studentMapper.getList(student);
        //封装分页数据
        PageInfo<Student> pageInfo=new PageInfo<>(list);
        return R.page(pageInfo.getTotal(),list);
    }

    @Override
    public R addOrUpdate(Student student) {
        Student s = new Student();
        s.setCid(student.getCid());
        List<Student> list = studentMapper.getList(s);
        if (list.isEmpty()){
            studentMapper.insertSelective(student);//添加学院
            return R.ok();
        }
        //修改学院信息
        studentMapper.updateByPrimaryKeySelective(student);
        return R.ok();
    }

    @Override
    public R delete(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
        return R.ok();
    }

    @Override
    public Student getById(Integer id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @Override
    public List<Student> getAll(Student student) {
        return studentMapper.getList(student);
    }
}
