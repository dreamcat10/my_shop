package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("details")
public class Details {
    @TableField(value = "cargoid")
    private int cargoid;
    @TableField(value = "xiaoliang")
    private String xiaoliang;
    @TableField(value = "shoucang")
    private String  shoucang;

}
