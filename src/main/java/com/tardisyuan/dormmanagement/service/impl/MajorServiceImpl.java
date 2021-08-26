package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.Major;
import com.tardisyuan.dormmanagement.mapper.MajorMapper;
import com.tardisyuan.dormmanagement.service.MajorService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public R getPage(int page, int limit, Major major) {

        PageHelper.startPage(page,limit);//在查询方法前一行调用
        List<Major> list= majorMapper.getList(major);
        //封装分页数据
        PageInfo<Major> pageInfo=new PageInfo<>(list);
        return R.page(pageInfo.getTotal(),list);
    }

    @Override
    public R addOrUpdate(Major major) {
        Major maj = new Major();
        maj.setMid(major.getMid());
        List<Major> list = majorMapper.getList(maj);
        if (list.isEmpty()){
            majorMapper.insertSelective(major);//添加学院
            return R.ok();
        }
        //修改学院信息
        majorMapper.updateByPrimaryKeySelective(major);
        return R.ok();
    }

    @Override
    public R delete(Integer id) {
        majorMapper.deleteByPrimaryKey(id);
        return R.ok();
    }

    @Override
    public Major getById(Integer id) {
        Major major = majorMapper.selectByPrimaryKey(id);
        return major;
    }

    @Override
    public List<Major> getAll(Major major) {
        return majorMapper.getList(major);
    }
}
