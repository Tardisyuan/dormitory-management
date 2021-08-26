package com.tardisyuan.dormmanagement.service;


import com.tardisyuan.dormmanagement.bean.Leavenote;
import com.tardisyuan.dormmanagement.util.R;

import java.util.List;

public interface LeavenoteService {
    R getPage(int page, int limit, Leavenote leavenote);
    R addOrUpdate(Leavenote leavenote);
    R delete(Integer id);
    Leavenote getById(Integer id);
    List<Leavenote> getAll(Leavenote leavenote);
}
