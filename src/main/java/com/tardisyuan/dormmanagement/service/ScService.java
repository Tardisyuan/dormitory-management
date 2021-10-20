package com.tardisyuan.dormmanagement.service;


import com.tardisyuan.dormmanagement.bean.Sc;
import com.tardisyuan.dormmanagement.util.R;

import java.util.List;

public interface ScService {
    Sc login(Sc sc);
    R getPage(int page, int limit, Sc sc);
    R addOrUpdate(Sc sc);
    R delete(Integer id);
    Sc getById(Integer id);
    List<Sc> getAll(Sc sc);
}
