package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.College;
import com.tardisyuan.dormmanagement.mapper.CollegeMapper;
import com.tardisyuan.dormmanagement.service.CollegeService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public R getPage(int page, int limit, College college) {

        PageHelper.startPage(page,limit);//在查询方法前一行调用
        List<College> list= collegeMapper.getList(college);
        //封装分页数据
        PageInfo<College> pageInfo=new PageInfo<>(list);
        return R.page(pageInfo.getTotal(),list);
    }

    @Override
    public R addOrUpdate(College college) {
        College coll = new College();
        coll.setCollegeid(college.getCollegeid());
        List<College> list = collegeMapper.getList(coll);
        if (list.isEmpty()){
            collegeMapper.insertSelective(college);//添加学院
            return R.ok();
        }
        //修改学院信息
        collegeMapper.updateByPrimaryKeySelective(college);
        return R.ok();
    }

    @Override
    public R delete(Integer id) {
        collegeMapper.deleteByPrimaryKey(id);
        return R.ok();
    }

    @Override
    public College getById(Integer id) {
        College college = collegeMapper.selectByPrimaryKey(id);
        return college;
    }

    @Override
    public List<College> getAll(College college) {
        return collegeMapper.getList(college);
    }
}
