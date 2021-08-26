package com.tardisyuan.dormmanagement.mapper;

import com.tardisyuan.dormmanagement.bean.Classes;

import java.util.List;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    List<Classes> getList(Classes classes);
}