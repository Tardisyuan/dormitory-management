package com.tardisyuan.dormmanagement.mapper;

import com.tardisyuan.dormmanagement.bean.Dorm;

import java.util.List;

public interface DormMapper {
    int deleteByPrimaryKey(Long did);

    int insert(Dorm record);

    int insertSelective(Dorm record);

    Dorm selectByPrimaryKey(Long did);

    int updateByPrimaryKeySelective(Dorm record);

    int updateByPrimaryKey(Dorm record);

    List<Dorm> getList(Dorm record);
}