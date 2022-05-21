package com.syliva.mymall.service;

import com.syliva.mymall.pojo.Header_img;

import java.util.List;

public interface Header_imgService {

    //根据商品id拿到图片
    public List<Header_img> getImg(int cId);
}
