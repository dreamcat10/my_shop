package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("recom")
public class Recom {
    @TableId(value = "rId")
    private int rId;
    @TableField(value = "rName")
    private String rName;
    @TableField(value = "img")
    private String img;
    @TableField(value = "value")
    private Double value;
    //销量
    @TableField(value = "grss")
    private String grss;
}
