package com.tardisyuan.dormmanagement.service;


import com.tardisyuan.dormmanagement.bean.Student;
import com.tardisyuan.dormmanagement.util.R;

import java.util.List;

public interface StudentService {
    Student login(Student student);
    R getPage(int page, int limit, Student student);
    R addOrUpdate(Student student);
    R delete(Integer id);
    Student getById(Integer id);
    List<Student> getAll(Student student);
}
