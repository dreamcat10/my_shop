package com.syliva.mymall.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syliva.mymall.mapper.UserTokenMapper;
import com.syliva.mymall.pojo.UserToken;
import com.syliva.mymall.service.UserTokenService;
import com.syliva.mymall.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {
    @Autowired
    UserTokenMapper userTokenMapper;

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;


    @Override
    public Map<String, Object> createToken(String  userId) {

        HashMap<String , Object> result = new HashMap<>();

        //生成一个token
        String token = TokenUtil.generateValue();

        //当前时间
        Date nowTime = new Date();

        //过期时间
        Date expireTime = new Date(nowTime.getTime() + EXPIRE * 1000);

        //是否已经存在UserToken
        UserToken userToken = findById(userId);
        if (userToken == null){
            userToken = new UserToken();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setExpireTime(expireTime);
            userToken.setUpdateTime(nowTime);

            //存进数据库中
            userTokenMapper.insert(userToken);
        }else {
            userToken.setToken(token);
            userToken.setExpireTime(expireTime);
            userToken.setUpdateTime(nowTime);

            //更新数据库中的userToken
            updateById(userId, userToken);
        }
        result.put("token", token);
        result.put("expireTime",expireTime.getTime());
        return result;

    }

    @Override
    public void logout(String token) {
        UserToken byToken = findByToken(token);

        //通过id删除userToken
        deleteById(byToken.getUserId());

    }

    @Override
    public UserToken findByToken(String token) {
        QueryWrapper<UserToken> wrapper = new QueryWrapper<>();
        wrapper.eq("token", token);
        UserToken userToken = userTokenMapper.selectOne(wrapper);
        return userToken;
    }

    @Override
    public UserToken findById(String userId) {
        QueryWrapper<UserToken> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        UserToken userToken = userTokenMapper.selectOne(queryWrapper);
        return userToken;
    }

    @Override
    public void updateById(String userId, UserToken userToken) {
        UpdateWrapper<UserToken> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("userId", userId);
        userTokenMapper.update(userToken, updateWrapper);
    }

    @Override
    public void deleteById(String userId) {
        QueryWrapper<UserToken> wrapper = new QueryWrapper<>();
        wrapper.eq("userId", userId);
        userTokenMapper.delete(wrapper);

    }


}
