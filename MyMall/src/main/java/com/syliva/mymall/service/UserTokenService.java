package com.syliva.mymall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.syliva.mymall.pojo.UserToken;

import java.io.Serializable;
import java.util.Map;

public interface UserTokenService extends IService<UserToken> {

    //生成token
    public Map<String, Object> createToken(String  userId);

    //登出
    public void logout(String token);

    //根据token查找userToken
    public UserToken findByToken(String token);

    //根据ID查找userToken
    public UserToken findById(String userId);

    //根据ID更新userToken
    public void updateById(String userId, UserToken userToken);

    public void deleteById(String userId);

}
