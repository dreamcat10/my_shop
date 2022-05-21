package com.syliva.mymall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syliva.mymall.mapper.IndentMapper;
import com.syliva.mymall.pojo.Indent;
import com.syliva.mymall.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentServiceImpl implements IndentService {
    @Autowired
    IndentMapper indentMapper;

    @Override
    public List<Indent> getIndentByuId(String userId) {
        QueryWrapper<Indent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);

        List<Indent> indents = indentMapper.selectList(queryWrapper);

        return indents;
    }

    @Override
    public void addIndent(Indent indent) {
        indentMapper.insert(indent);
    }
}
