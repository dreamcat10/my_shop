package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "userId")
    private String userId;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private int age;
    @TableField(value = "password")
    private String password;
    @TableField(value = "sex")
    private String sex;
    @TableField(value = "role")
    private String role;
    @TableField(value = "money")
    private Double money;
}
