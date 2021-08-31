package com.tardisyuan.dormmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tardisyuan.dormmanagement.bean.Leavenote;
import com.tardisyuan.dormmanagement.mapper.LeavenoteMapper;
import com.tardisyuan.dormmanagement.service.LeavenoteService;
import com.tardisyuan.dormmanagement.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LeavenoteServiceImpl implements LeavenoteService {

    @Autowired
    private LeavenoteMapper leavenoteMapper;

    @Override
    public R getPage(int page, int limit, Leavenote leavenote) {
        PageHelper.startPage(page,limit);//在查询方法前一行调用
        List<Leavenote> list= leavenoteMapper.getList(leavenote);
        //封装分页数据
        PageInfo<Leavenote> pageInfo=new PageInfo<>(list);
        return R.page(pageInfo.getTotal(),list);
    }

    @Override
    public R addOrUpdate(Leavenote leavenote) {
        Leavenote lea = new Leavenote();
        lea.setLid(leavenote.getLid());
        List<Leavenote> list = leavenoteMapper.getList(lea);
        if (list.isEmpty()){
            leavenoteMapper.insertSelective(leavenote);//添加学院
            return R.ok();
        }
        //修改学院信息
        leavenoteMapper.updateByPrimaryKeySelective(leavenote);
        return R.ok();
    }

    @Override
    public R delete(Integer id) {
        leavenoteMapper.deleteByPrimaryKey(id);
        return R.ok();
    }

    @Override
    public Leavenote getById(Integer id) {
        Leavenote leavenote = leavenoteMapper.selectByPrimaryKey(id);
        return leavenote;
    }

    @Override
    public List<Leavenote> getAll(Leavenote leavenote) {
        return leavenoteMapper.getList(leavenote);
    }
}
