package com.syliva.mymall.service;

import com.syliva.mymall.pojo.Details;

import java.util.List;

public interface DetailsService {

    //拿到商品的销量和收藏数
    public Details getDetails(int cId);
}
