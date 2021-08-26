package com.tardisyuan.dormmanagement.service;


import com.tardisyuan.dormmanagement.bean.College;
import com.tardisyuan.dormmanagement.util.R;

import java.util.List;

public interface CollegeService {
    R getPage(int page, int limit, College college);
    R addOrUpdate(College college);
    R delete(Integer id);
    College getById(Integer id);
    List<College> getAll(College college);
}
