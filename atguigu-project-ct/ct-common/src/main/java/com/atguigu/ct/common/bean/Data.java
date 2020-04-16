package com.atguigu.ct.common.bean;

public class Data implements Val{

    public String content;

    public void setValue(String value){
        content=value;
    }
    @Override
    public Object value() {
        return content;
    }
}
