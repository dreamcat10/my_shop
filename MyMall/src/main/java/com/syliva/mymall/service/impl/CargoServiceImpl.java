package com.syliva.mymall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syliva.mymall.mapper.CargoMapper;
import com.syliva.mymall.pojo.Cargo;
import com.syliva.mymall.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    CargoMapper cargoMapper;

    @Override
    public List<Cargo> getCargo(String type, int page) {

        QueryWrapper<Cargo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type);
        queryWrapper.eq("page", page);
        List<Cargo> cargos = cargoMapper.selectList(queryWrapper);
        return cargos;
    }

    @Override
    public Cargo getCargo1(int cId) {
        Cargo cargo = cargoMapper.selectById(cId);
        return cargo;
    }
}
