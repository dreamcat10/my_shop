package com.syliva.mymall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.syliva.mymall.mapper.CartMapper;
import com.syliva.mymall.pojo.Cart;
import com.syliva.mymall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartMapper cartMapper;

    @Override
    public void addCart(Cart cart) {
        cartMapper.insert(cart);
    }

    @Override
    public List<Cart> getCarts(String userId) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        List<Cart> carts = cartMapper.selectList(queryWrapper);
        return carts;
    }

    @Override
    public void delCarts(List idList) {
        cartMapper.deleteBatchIds(idList);
    }
}
