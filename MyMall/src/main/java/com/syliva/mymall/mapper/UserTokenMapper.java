package com.syliva.mymall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syliva.mymall.pojo.UserToken;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {
    //存入一条数据
    public int addUserToken(UserToken userToken);

    //删除一条数据
    public int removeById(String userId);
}
