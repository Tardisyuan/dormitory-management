package com.tardisyuan.dormmanagement.mapper;

import com.tardisyuan.dormmanagement.bean.Major;

import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    List<Major> getList(Major major);
}