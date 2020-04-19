package com.atguigu.ct.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 根据指定时间字符串获取时间戳
     * @param timeStr
     * @param partten
     * @return
     * @throws ParseException
     */
    public static long parse(String timeStr, String partten) {
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        long time = 0;
        try {
            time = sdf.parse(timeStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 根据时间戳 获取时间字符串
     * @param time
     * @param partten
     * @return
     */
    public static String format(long time,String partten){
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        String timeStr = sdf.format(new Date(time));
        return timeStr;

    }
}
