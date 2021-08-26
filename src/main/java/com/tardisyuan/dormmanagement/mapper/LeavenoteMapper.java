package com.tardisyuan.dormmanagement.mapper;

import com.tardisyuan.dormmanagement.bean.Leavenote;

import java.util.List;

public interface LeavenoteMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(Leavenote record);

    int insertSelective(Leavenote record);

    Leavenote selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(Leavenote record);

    int updateByPrimaryKeyWithBLOBs(Leavenote record);

    int updateByPrimaryKey(Leavenote record);

    List<Leavenote> getList(Leavenote record);
}