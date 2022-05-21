package com.syliva.mymall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("store")
public class Store {
    @TableId(value = "sId")
    private int sId;
    @TableField(value = "sName")
    private String sName;
    @TableField(value = "img")
    private String  img;
    //总销量
    @TableField(value = "grss")
    private int grss;
    //货物数量
    @TableField(value = "count")
    private String count;
    //描述相符评分
    @TableField(value = "acc")
    private Double acc;
    //质量评分
    @TableField(value = "zhiliang")
    private Double zhiliang;
    //价格合理评分
    @TableField(value = "jiage")
    private Double jiage;
    @TableField(value = "cargoid")
    private int cargoid;

}
