package com.syliva.mymall.service;

import com.syliva.mymall.pojo.Store;

public interface StoreService {
    //根据商品id拿到店铺数据
    public Store getStore(int cId);
}
