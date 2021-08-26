package com.tardisyuan.dormmanagement.service;


import com.tardisyuan.dormmanagement.bean.Major;
import com.tardisyuan.dormmanagement.util.R;

import java.util.List;

public interface MajorService {
    R getPage(int page, int limit, Major major);
    R addOrUpdate(Major major);
    R delete(Integer id);
    Major getById(Integer id);
    List<Major> getAll(Major major);
}
