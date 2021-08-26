package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.Classes;
import com.tardisyuan.dormmanagement.mapper.ClassesMapper;
import com.tardisyuan.dormmanagement.service.ClassesService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public R getPage(int page, int limit, Classes classes) {

        PageHelper.startPage(page,limit);//在查询方法前一行调用
        List<Classes> list= classesMapper.getList(classes);
        //封装分页数据
        PageInfo<Classes> pageInfo=new PageInfo<>(list);
        return R.page(pageInfo.getTotal(),list);
    }

    @Override
    public R addOrUpdate(Classes classes) {
        Classes cla = new Classes();
        cla.setCid(classes.getCid());
        List<Classes> list = classesMapper.getList(cla);
        if (list.isEmpty()){
            classesMapper.insertSelective(classes);//添加学院
            return R.ok();
        }
        //修改学院信息
        classesMapper.updateByPrimaryKeySelective(classes);
        return R.ok();
    }

    @Override
    public R delete(Integer id) {
        classesMapper.deleteByPrimaryKey(id);
        return R.ok();
    }

    @Override
    public Classes getById(Integer id) {
        Classes college = classesMapper.selectByPrimaryKey(id);
        return college;
    }

    @Override
    public List<Classes> getAll(Classes classes) {
        return classesMapper.getList(classes);
    }
}
