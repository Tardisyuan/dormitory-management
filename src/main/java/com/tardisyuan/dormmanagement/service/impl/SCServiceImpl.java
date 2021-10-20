package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.Sc;
import com.tardisyuan.dormmanagement.mapper.ScMapper;
import com.tardisyuan.dormmanagement.service.ScService;
import com.tardisyuan.dormmanagement.util.MD5Util;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SCServiceImpl implements ScService {

    @Autowired
    private ScMapper scMapper;

    @Override
    public Sc login(Sc sc) {
        sc.setScpassword(MD5Util.MD5(sc.getScpassword()));
        return scMapper.login(sc);
    }

    @Override
    public R getPage(int page, int limit, Sc sc) {

        PageHelper.startPage(page,limit);//在查询方法前一行调用
        List<Sc> list= scMapper.getList(sc);
        //封装分页数据
        PageInfo<Sc> pageInfo=new PageInfo<>(list);
        return R.page(pageInfo.getTotal(),list);
    }

    @Override
    public R addOrUpdate(Sc sc) {
        Sc sc1 = new Sc();
        sc1.setScid(sc.getScid());
        List<Sc> list = scMapper.getList(sc1);
        if (list.isEmpty()){
            scMapper.insertSelective(sc);//添加学院
            return R.ok();
        }
        //修改学院信息
        scMapper.updateByPrimaryKeySelective(sc);
        return R.ok();
    }

    @Override
    public R delete(Integer id) {
        scMapper.deleteByPrimaryKey(id);
        return R.ok();
    }

    @Override
    public Sc getById(Integer id) {
        Sc sc = scMapper.selectByPrimaryKey(id);
        return sc;
    }

    @Override
    public List<Sc> getAll(Sc sc) {
        return scMapper.getList(sc);
    }
}
