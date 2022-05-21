package com.syliva.mymall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syliva.mymall.mapper.RecomMapper;
import com.syliva.mymall.pojo.Recom;
import com.syliva.mymall.service.RecomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomServiceImpl implements RecomService {
    @Autowired
    RecomMapper recomMapper;

    @Override
    public List<Recom> getRecom() {
        QueryWrapper<Recom> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("rId", 60);
        List<Recom> recoms = recomMapper.selectList(queryWrapper);

        return recoms;
    }
}
