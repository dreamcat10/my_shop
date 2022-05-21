package com.syliva.mymall.controller;

import com.syliva.mymall.pojo.*;
import com.syliva.mymall.service.impl.*;
import com.syliva.mymall.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    CargoServiceImpl cargoService;

    @Autowired
    DetailsServiceImpl detailsService;

    @Autowired
    StoreServiceImpl storeService;

    @Autowired
    RecomServiceImpl recomService;

    @Autowired
    Header_imgServiceImpl headerImgService;
    @GetMapping("/cargos")
    public Result getCargos(String type, int page){
        try {
            List<Cargo> cargos = cargoService.getCargo(type, page);
            if (cargos == null){
                return Result.fail(400, "");
            }
            return Result.succ(200, "", cargos);
        } catch (Exception e) {
            return Result.fail(400, ""+e);
        }

    }

    @GetMapping("/detail")
    public Result getDetails(int cId){
        HashMap<String , Object> map = new HashMap<>();
        try {
            //拿到详情轮播图
            List<Header_img> imgs = headerImgService.getImg(cId);

            //获取店铺信息
            Store store = storeService.getStore(cId);

            //获取推荐信息
            List<Recom> recoms = recomService.getRecom();

            //获取商品信息
            Details details = detailsService.getDetails(cId);
            Cargo cargo = cargoService.getCargo1(cId);

            if (imgs == null || store == null || recoms == null){
                return Result.fail(400, "");
            }else {
                map.put("imgs", imgs);
                map.put("store", store);
                map.put("recoms", recoms);
                map.put("detail", details);
                map.put("cargo", cargo);
                return Result.succ(200, "", map);
            }
        } catch (Exception e) {
            return Result.fail(400, ""+e);
        }


    }
}
