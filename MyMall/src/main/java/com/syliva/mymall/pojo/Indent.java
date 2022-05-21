package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("indent")
public class Indent {
    @TableId(value = "iId")
    private int iId;
    @TableField(value = "name")
    private String name;
    @TableField(value = "total")
    private Double total;
    @TableField(value = "count")
    private int count;
    @TableField(value = "img")
    private String img;
    @TableField(value = "size")
    private String size;
    @TableField(value = "cargoid")
    private int cargoid;
    @TableField(value = "userId")
    private String  userId;
}
