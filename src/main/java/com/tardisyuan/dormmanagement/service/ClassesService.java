package com.tardisyuan.dormmanagement.service;


import com.tardisyuan.dormmanagement.bean.Classes;
import com.tardisyuan.dormmanagement.util.R;

import java.util.List;

public interface ClassesService {
    R getPage(int page, int limit, Classes classes);
    R addOrUpdate(Classes classes);
    R delete(Integer id);
    Classes getById(Integer id);
    List<Classes> getAll(Classes classes);
}
