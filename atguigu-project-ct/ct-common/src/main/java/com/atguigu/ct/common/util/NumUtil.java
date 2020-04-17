package com.atguigu.ct.common.util;

import java.text.DecimalFormat;

public class NumUtil {
    /**
     * 按着指定的格式 格式数字 返回字符串
     * @param i 数字
     * @param f 格式 “0000”
     * @return
     */
    public static String format(int i,String f){
        DecimalFormat fmt = new DecimalFormat(f);
        return fmt.format(i);
    }
}
