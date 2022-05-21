package com.syliva.mymall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syliva.mymall.mapper.DetailsMapper;
import com.syliva.mymall.pojo.Details;
import com.syliva.mymall.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    DetailsMapper detailsMapper;

    @Override
    public Details getDetails(int cId) {
        QueryWrapper<Details> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cargoid", cId);
        Details details = detailsMapper.selectOne(queryWrapper);

        return details;
    }
}
