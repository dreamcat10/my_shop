package com.syliva.mymall.utils;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
     private int code;
     private String msg;
     private Object data;

    public static Result succ(int code, String mess) {
         Result m = new Result();
         m.setCode(code);
         m.setData(null);
         m.setMsg(mess);
         return m;
         }
    public static Result succ(int code, String mess, Object data) {
         Result m = new Result();
         m.setCode(code);
         m.setData(data);
         m.setMsg(mess);
         return m;
 }
        public static Result fail(int code, String mess) {
         Result m = new Result();
         m.setCode(code);
         m.setData(null);
         m.setMsg(mess);
         return m;
 }
    public static Result fail(int code, String mess, Object data) {
        Result m = new Result();
        m.setCode(code);
        m.setData(data);
        m.setMsg(mess);
        return m;
     }
 }

