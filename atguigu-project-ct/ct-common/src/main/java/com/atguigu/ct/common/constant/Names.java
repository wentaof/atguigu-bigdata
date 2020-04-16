package com.atguigu.ct.common.constant;

import com.atguigu.ct.common.bean.Val;

/**
 * 名称常量枚举类
 */
public enum Names implements Val {
    NAMESPACE("ct");

    private String name;
    Names(String name) {
        this.name=name;
    }

    @Override
    public String value() {
        return name;
    }
}
