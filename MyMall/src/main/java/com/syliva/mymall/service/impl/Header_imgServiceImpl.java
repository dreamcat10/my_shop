package com.syliva.mymall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syliva.mymall.mapper.Header_imgMapper;
import com.syliva.mymall.pojo.Header_img;
import com.syliva.mymall.service.Header_imgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Header_imgServiceImpl implements Header_imgService {
    @Autowired
    Header_imgMapper headerImgMapper;

    @Override
    public List<Header_img> getImg(int cId) {
        QueryWrapper<Header_img> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cId", cId);
        List<Header_img> imgs = headerImgMapper.selectList(queryWrapper);
        return imgs;
    }
}
