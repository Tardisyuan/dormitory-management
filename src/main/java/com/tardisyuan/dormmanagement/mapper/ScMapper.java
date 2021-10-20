package com.tardisyuan.dormmanagement.mapper;

import com.tardisyuan.dormmanagement.bean.Sc;

import java.util.List;

public interface ScMapper {
    int deleteByPrimaryKey(Integer scid);

    int insert(Sc record);

    int insertSelective(Sc record);

    Sc selectByPrimaryKey(Integer scid);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);

    Sc login(Sc sc);

    List<Sc> getList(Sc sc);
}