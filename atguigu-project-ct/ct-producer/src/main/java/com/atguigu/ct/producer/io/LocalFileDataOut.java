package com.atguigu.ct.producer.io;

import com.atguigu.ct.common.bean.DataOut;

import java.io.IOException;

/**
 * 生产者文件输出
 */
public class LocalFileDataOut implements DataOut {



    public LocalFileDataOut(String s) {
        setPath(s);
    }

    public void setPath(String path) {

    }

    public void close() throws IOException {

    }
}
