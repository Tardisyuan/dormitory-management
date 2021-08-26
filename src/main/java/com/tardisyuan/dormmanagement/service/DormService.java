package com.tardisyuan.dormmanagement.service;


import com.tardisyuan.dormmanagement.bean.Dorm;
import com.tardisyuan.dormmanagement.util.R;

import java.util.List;

public interface DormService {
    R getPage(int page, int limit, Dorm dorm);
    R addOrUpdate(Dorm dorm);
    R delete(Long id);
    Dorm getById(Long id);
    List<Dorm> getAll(Dorm dorm);
}
