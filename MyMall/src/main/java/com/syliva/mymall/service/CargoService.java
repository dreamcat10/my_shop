package com.syliva.mymall.service;

import com.syliva.mymall.pojo.Cargo;

import java.util.List;

public interface CargoService {
    //根据类型和页码来拿到商品数据
    public List<Cargo> getCargo(String type, int page);

    //根据id获取商品信息
    Cargo getCargo1(int cId);
}
