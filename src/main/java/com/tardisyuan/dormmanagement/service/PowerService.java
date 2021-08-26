package com.tardisyuan.dormmanagement.service;

import com.tardisyuan.dormmanagement.bean.Power;
import com.tardisyuan.dormmanagement.util.R;

import java.util.List;

public interface PowerService {
    R page(Integer page, Integer pageSize, Power power);
    Power getById(Integer id);
    R addOrUpdate(Power power);
    R delete(Integer id);

    List<Power> getAll(Power power);
}
