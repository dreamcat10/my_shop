package com.syliva.mymall.controller;

import com.syliva.mymall.pojo.Indent;
import com.syliva.mymall.service.impl.IndentServiceImpl;
import com.syliva.mymall.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/indent")
public class IndentController {
    @Autowired
    IndentServiceImpl indentService;

    @GetMapping("/getIndent")
    public Result getIndents(String uId){

        try {
            List<Indent> indents = indentService.getIndentByuId(uId);
            if ( indents.isEmpty() ){
                return Result.fail(400, "");
            }else {
                return Result.succ(200, "", indents);
            }
        } catch (Exception e) {
            return Result.fail(400, ""+e);
        }


    }

}
