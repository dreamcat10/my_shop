package com.syliva.mymall.service;

import com.syliva.mymall.pojo.Indent;

import java.util.List;

public interface IndentService {

    //通过用户id拿到用户订单数据
    public List<Indent> getIndentByuId(String userId);

    //添加新的订单
    public void addIndent(Indent indent);
}
