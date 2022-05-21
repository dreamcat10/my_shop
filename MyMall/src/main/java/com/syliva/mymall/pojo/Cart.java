package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("cart")
public class Cart {
    @TableId("id")
    private int id;
    @TableField("size")
    private String size;
    @TableField("price")
    private Double price;
    @TableField("count")
    private int count;
    @TableField("total")
    private Double total;
    @TableField("img")
    private String  img;
    @TableField("name")
    private String  name;
    @TableField("flag")
    private Boolean  flag;
    @TableField("cargoid")
    private int cargoid;

    @TableField("userId")
    private String userId;

}
