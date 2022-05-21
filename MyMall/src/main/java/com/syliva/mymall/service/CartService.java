package com.syliva.mymall.service;

import com.syliva.mymall.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface CartService {

    //添加一条购物车数据
    void addCart(Cart cart);

    //根据用户id拿到购物车数据
    List<Cart> getCarts(String userId);

    //购物车商品被选购，清楚购物车数据
    void delCarts(List idList);
}
