package com.syliva.mymall.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syliva.mymall.pojo.Cart;
import com.syliva.mymall.pojo.Indent;
import com.syliva.mymall.pojo.User;
import com.syliva.mymall.service.impl.CartServiceImpl;
import com.syliva.mymall.service.impl.IndentServiceImpl;
import com.syliva.mymall.service.impl.UserServiceImpl;
import com.syliva.mymall.utils.Result;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartServiceImpl cartService;
    @Autowired
    IndentServiceImpl indentService;
    @Autowired
    UserServiceImpl userService;

    private ObjectMapper mapper = new ObjectMapper();
    //完成购物车中的商品
    @PostMapping("/finishCart")
    public Result finishCarts(@RequestHeader("token") String token, @RequestBody Map<String, Object> map){
        try {
            List idList = (List) map.get("idList");
            cartService.delCarts(idList);

            Object indents = map.get("Indents");
            List<Indent> indents1 = JSON.parseArray(JSON.toJSONString(indents), Indent.class);

            for (Indent indent : indents1) {
                indentService.addIndent(indent);
            }
            Double money = (Double) map.get("money");
            String  userId = (String) map.get("uId");
            userService.updateMoney(money, userId);
            User user = userService.findById(userId);
            return Result.succ(200, "购买成功",user);
        } catch (Exception e) {
          return Result.fail(400, ""+e);
        }
    }

    //添加到购物车
    @PostMapping("/addCart")
    public Result addCart(@RequestHeader("token")String token ,@RequestBody Cart cart){
        try {
            cartService.addCart(cart);
            return Result.succ(200, "添加成功");
        } catch (Exception e) {
           return Result.fail(400, "添加失败" +e);
        }

    }
    //拿到用户的购物车数据
    @GetMapping("/getCarts")
    public Result getCarts( @RequestHeader("token")String token , String userId){

        try {
            List<Cart> carts = cartService.getCarts(userId);
            if (carts == null){
                return Result.fail(400, "");
            }else {
                return Result.succ(200, "" , carts);
            }
        } catch (Exception e) {
            return Result.fail(400, ""+e);
        }
    }
}

