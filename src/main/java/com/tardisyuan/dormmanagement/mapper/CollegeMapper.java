package com.tardisyuan.dormmanagement.mapper;

import com.tardisyuan.dormmanagement.bean.College;

import java.util.List;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeid);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeid);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

    List<College> getList(College college);
}