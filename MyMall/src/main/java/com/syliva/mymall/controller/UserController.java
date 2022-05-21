package com.syliva.mymall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syliva.mymall.dto.LoginDto;
import com.syliva.mymall.mapper.UserMapper;
import com.syliva.mymall.pojo.User;
import com.syliva.mymall.pojo.UserToken;
import com.syliva.mymall.service.impl.UserServiceImpl;
import com.syliva.mymall.service.impl.UserTokenServiceImpl;
import com.syliva.mymall.utils.Result;
import com.syliva.mymall.utils.TokenUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserTokenServiceImpl userTokenService;

    @GetMapping("/getUser")
    public Result  getUsers(@RequestHeader("token") String token, String userId) {

        try {
            User user = userService.findById(userId);
            return Result.succ(200, "",user);
        } catch (Exception e) {
            return Result.fail(400, ""+e);
        }

    }

    @GetMapping("/login")
    public Result login( LoginDto loginDto) {
        Result result = new Result();
        Map<String , Object> map = new HashMap<>();

        User user = userService.findById(loginDto.getUserId());

        if (user == null){
            result =  Result.fail(400, "用户名错误");
        }else if (!user.getPassword().equals(loginDto.getUserPassword()) || user.getPassword() == null){
            result =  Result.fail(400, "密码错误");
            }else {
                //创建userToken，存到数据库
                  map = userTokenService.createToken(loginDto.getUserId());
                  map.put("user", user);
                result =  Result.succ(200,"登录成功", map);

            }

        return result;
    }
    @RequiresUser
    @DeleteMapping("/logout")
    public Result logout(@RequestHeader("token") String token){
        HashMap<String, String> map = new HashMap<>();
        try {
            userTokenService.logout(token);
            map.put("role", "0");
            return Result.succ(200, "退出登录成功", map);
        } catch (Exception e) {
            return Result.fail(400, "退出登录失败," + e);
        }

    }
    @PostMapping("/inLogin")
    public Result inLogin(@RequestBody User user){

        try {
            userService.addUser(user);
            return Result.succ(200, "注册成功");
        } catch (Exception e) {
            return Result.fail(400, "注册失败," );
        }
    }

    @RequiresUser
    @DeleteMapping("/remove")
    public Result remove(@RequestHeader("token") String token){
        HashMap<String , String> map = new HashMap<>();
        UserToken userToken = userTokenService.findByToken(token);
        User user = userService.findById(userToken.getUserId());
        try {
            userTokenService.logout(token);
            userService.removeUser(user);
            map.put("role", "0");
           return Result.succ(200, "注销成功",map);
        } catch (Exception e) {
           return Result.fail(400, "注销失败" );
        }

    }
}

