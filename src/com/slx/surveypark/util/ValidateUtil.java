package com.slx.surveypark.util;

import java.util.Collection;

/**
 * Created by lenovo on 2016/11/27.
 */
//校验工具类
public class ValidateUtil {

    //判断字符串是否有效性
    public static boolean isValid(String src){
        if(src==null ||"".equals(src.trim())){
            return false;
        }
        return true;
    }

    //判断集合的有效性
    public static boolean isValid(Collection col){
        if(col==null || col.isEmpty()){
            return false;
        }
        return true;
    }
}


