package com.tardisyuan.dormmanagement.mapper;

import com.tardisyuan.dormmanagement.bean.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getList(Student record);
}