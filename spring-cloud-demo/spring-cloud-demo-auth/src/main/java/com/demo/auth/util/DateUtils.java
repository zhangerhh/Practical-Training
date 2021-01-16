package com.demo.auth.util;

import java.text.SimpleDateFormat;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 10:25
 */
public class DateUtils {


    private static SimpleDateFormat dateFormat = new SimpleDateFormat();


    /**
     * 获取当前时间字符串
     *
     * @return string
     */
    public static String nowTime() {
        dateFormat.applyPattern("yyyyMMddhhmmss");
        return dateFormat.format(System.currentTimeMillis());
    }


}
