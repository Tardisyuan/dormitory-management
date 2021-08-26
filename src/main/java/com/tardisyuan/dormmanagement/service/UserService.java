package com.tardisyuan.dormmanagement.service;

import com.tardisyuan.dormmanagement.bean.User;
import com.tardisyuan.dormmanagement.util.R;

public interface UserService {
    User login(User user);
    R getPage(int page,int limit,User user);
    R delete(Integer id);
    R addOrUpdate(User user);
    User getById(Integer id);
    R checkUsername(String username);
    R checkPassword(User user);
}
