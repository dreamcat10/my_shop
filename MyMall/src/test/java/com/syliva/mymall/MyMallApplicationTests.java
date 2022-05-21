package com.syliva.mymall;

import com.syliva.mymall.pojo.*;
import com.syliva.mymall.service.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class MyMallApplicationTests {
        @Autowired
    CartServiceImpl cartService;
    @Test
    void contextLoads() {
        List<Integer> list = new LinkedList<>();
        list.add(31);
        list.add(32);
        cartService.delCarts(list);

    }

}
