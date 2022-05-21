package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userToken")
public class UserToken {

    @TableField(value = "userId")
    private String  userId;
    @TableField(value = "token")
    private String token;
    @TableField(value = "expireTime")
    private Date expireTime;
    @TableField(value = "updateTime")
    private Date updateTime;
}
