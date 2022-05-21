package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("header_img")
public class Header_img {
    @TableId(value = "pId")
    private int pId;
    @TableField(value = "img")
    private String img;
    @TableField(value = "cId")
    private int cId;

}
