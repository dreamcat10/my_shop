package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cargo")
public class Cargo {
    @TableId(value = "cId")
    private int cId;
    @TableField(value = "cName")
    private String cName;
    @TableField(value = "value")
    private Double value;
    @TableField(value = "img")
    private String  img;
    @TableField(value = "type")
    private String type;
    @TableField(value = "page")
    private int page;

}
