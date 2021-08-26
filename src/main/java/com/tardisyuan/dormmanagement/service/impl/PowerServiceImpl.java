package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.Power;
import com.tardisyuan.dormmanagement.bean.User;
import com.tardisyuan.dormmanagement.mapper.PowerMapper;
import com.tardisyuan.dormmanagement.mapper.UserMapper;
import com.tardisyuan.dormmanagement.service.PowerService;
import com.tardisyuan.dormmanagement.util.R;
import com.tardisyuan.dormmanagement.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerMapper powerMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public R page(Integer page, Integer pageSize, Power power) {
        PageHelper.startPage(page,pageSize);//在查询方法前一行调用
        List<Power> list= powerMapper.getList(power);
        //封装分页数据
        PageInfo<Power> pageInfo=new PageInfo<>(list);
        System.out.println(pageInfo.getTotal());
        return R.page(pageInfo.getTotal(),list);
    }

    @Override
    public Power getById(Integer id) {
        return powerMapper.selectByPrimaryKey(id);
    }

    @Override
    public R addOrUpdate(Power power) {
        if(power.getId()==null){
            powerMapper.insertSelective(power);
        }else{
            powerMapper.updateByPrimaryKeySelective(power);
        }
        return R.ok();
    }

    @Override
    public R delete(Integer id) {
        //1.根据权限id查询用户表
        User user=new User();
        user.setPowerid(id);
        List<User> userList=userMapper.getList(user);
        //2.判断该权限是否已经存在关联用户
        if(userList.size()>0){
            return new R(0,"请先删除该选线的关联用户！");
        }
        powerMapper.deleteByPrimaryKey(id);
        return R.ok();
    }

    @Override
    public List<Power> getAll(Power power) {
        return powerMapper.getList(power);
    }
}
