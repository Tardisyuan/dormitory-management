package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.User;
import com.tardisyuan.dormmanagement.mapper.UserMapper;
import com.tardisyuan.dormmanagement.service.UserService;
import com.tardisyuan.dormmanagement.util.MD5Util;
import com.tardisyuan.dormmanagement.util.R;
import com.tardisyuan.dormmanagement.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    /*自动装载*/
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        user.setPassword(MD5Util.MD5(user.getPassword()));
        return userMapper.login(user);
    }

    @Override
    public R getPage(int page, int limit, User user) {
        PageHelper.startPage(page,limit);
        List<User> list= userMapper.getList(user);
        PageInfo<User> pageInfo=new PageInfo<>(list);
        return R.page(pageInfo.getTotal(), list);
    }
    @Override
    public R delete(Integer id) {
        if(userMapper.deleteByPrimaryKey(id)>0){
            return R.ok();
        }
        return R.error();
    }
    @Override
    public R addOrUpdate(User user) {
        int result=0;
        //密码不为空时给密码MD5加密
        if(StringUtils.isNotEmpty(user.getPassword())){
            user.setPassword(MD5Util.MD5(user.getPassword()));
        }
        if(user.getId()==null){
            result=userMapper.insertSelective(user);
        }else{
            result= userMapper.updateByPrimaryKeySelective(user);
        }
        return result>0?R.ok():R.error();
    }
    @Override
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public R checkUsername(String username) {
        User user=new User();
        user.setUsername(username);
        List<User> list= userMapper.getList(user);
        return new R(list.size());
    }

    @Override
    public R checkPassword(User user) {
        User user2=userMapper.selectByPrimaryKey(user.getId());
        if(MD5Util.checkMD5(user.getPassword(),user2.getPassword())){
            return R.ok();
        }
        return R.error();
    }
}
