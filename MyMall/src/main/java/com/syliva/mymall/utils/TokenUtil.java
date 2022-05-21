package com.syliva.mymall.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class TokenUtil {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }
    // 将文本转换为32位小写的MD5
    public static String generateValue(String param){
        try {
            // 进行实例化和初始化
            MessageDigest algorithm = MessageDigest.getInstance("MD5");

            algorithm.reset();
            // 得到一个操作系统默认的字节编码格式的字节数组, 对得到的字节数组进行处理
            algorithm.update(param.getBytes());
            // 进行Hash计算并得到返回结果
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("token生成失败");
        }
    }
    private static final char[] hexCode = "0123456789abcdefgh".toCharArray();

    public static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        // 得到进行Hash计算后数据的长度
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }
    /**
     * 获取请求的token
     */
    public static String getRequestToken(HttpServletRequest httpRequest) {

        //从header中获取token
        String token = httpRequest.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }


}
