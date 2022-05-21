package com.syliva.mymall.service.impl;

import com.syliva.mymall.mapper.StoreMapper;
import com.syliva.mymall.pojo.Store;
import com.syliva.mymall.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreMapper storeMapper;

    @Override
    public Store getStore(int cId) {
        Store store = storeMapper.selectById(cId);

        return store;
    }

}
