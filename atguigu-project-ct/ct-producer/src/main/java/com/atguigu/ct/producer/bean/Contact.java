package com.atguigu.ct.producer.bean;

import com.atguigu.ct.common.bean.Data;

public class Contact extends Data {

    private String tel;
    private String name;


    public String getPhone() {
        return tel;
    }

    public void setPhone(String phone) {
        this.tel = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void setValue(String line) {
        String[] split = line.split("\t");
        setName(split[1]);
        setPhone(split[0]);
    }

    @Override
    public String toString() {
        return "contact:[name:"+name+",phone:"+tel+"]";
    }
}
