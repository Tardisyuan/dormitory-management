package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.Dorm;
import com.tardisyuan.dormmanagement.mapper.DormMapper;
import com.tardisyuan.dormmanagement.service.DormService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DormServiceImpl implements DormService {

    @Autowired
    private DormMapper dormMapper;

    @Override
    public R getPage(int page, int limit, Dorm dorm) {

        PageHelper.startPage(page,limit);//在查询方法前一行调用
        List<Dorm> list= dormMapper.getList(dorm);
        //封装分页数据
        PageInfo<Dorm> pageInfo=new PageInfo<>(list);
        return R.page(pageInfo.getTotal(),list);
    }

    @Override
    public R addOrUpdate(Dorm dorm) {
        Dorm dor = new Dorm();
        dor.setDid(dorm.getDid());
        List<Dorm> list = dormMapper.getList(dor);
        if (list.isEmpty()){
            dormMapper.insertSelective(dorm);//添加学院
            return R.ok();
        }
        //修改学院信息
        dormMapper.updateByPrimaryKeySelective(dorm);
        return R.ok();
    }

    @Override
    public R delete(Long id) {
        dormMapper.deleteByPrimaryKey(id);
        return R.ok();
    }

    @Override
    public Dorm getById(Long id) {
        Dorm dorm = dormMapper.selectByPrimaryKey(id);
        return dorm;
    }

    @Override
    public List<Dorm> getAll(Dorm dorm) {
        return dormMapper.getList(dorm);
    }
}
