package com.atguigu.ct.common.bean;

import java.io.Closeable;

public interface DataIn extends Closeable {
    public void setPath(String path);
}
