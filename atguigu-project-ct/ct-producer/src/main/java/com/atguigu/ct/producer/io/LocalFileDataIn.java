package com.atguigu.ct.producer.io;

import com.atguigu.ct.common.bean.DataIn;

import java.io.IOException;

/**
 * 本地文件数据输入
 */
public class LocalFileDataIn implements DataIn {

    public LocalFileDataIn(String s) {
        setPath(s);
    }

    public void setPath(String path) {

    }


    public void close() throws IOException {

    }
}
