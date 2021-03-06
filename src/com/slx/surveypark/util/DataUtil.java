package com.slx.surveypark.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lenovo on 2016/11/27.
 */
//数据工具类
public class DataUtil {
    //使用MD5进行加密
    public static String md5(String src){
        try {
            StringBuffer buffer=new StringBuffer();
            char[] chars={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            byte[] bytes=src.getBytes();
            MessageDigest md= null;
            md = MessageDigest.getInstance("MD5");
            byte[] targ=md.digest(bytes);
            for(byte b:targ){
                buffer.append(chars[(b>>4)&0x0F]);
                buffer.append(chars[b&0x0F]);
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
