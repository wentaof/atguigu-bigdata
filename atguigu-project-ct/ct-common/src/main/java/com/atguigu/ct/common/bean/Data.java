package com.atguigu.ct.common.bean;

public abstract class Data implements Val{

    public String content;

    public void setValue(String value){
        content=value;
    }

    @Override
    public String getValue() {
        return content;
    }

    @Override
    public void setValue(Object val) {
        content=(String) val;
    }
}
