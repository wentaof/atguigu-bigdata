package com.atguigu.ct.producer.io;

import com.atguigu.ct.common.bean.DataOut;

import java.io.*;

/**
 * 生产者文件输出
 */
public class LocalFileDataOut implements DataOut {

    private PrintWriter writer;

    public LocalFileDataOut(String s) {
        setPath(s);
    }

    public void setPath(String path) {
        try {
            writer=new PrintWriter(new OutputStreamWriter(new FileOutputStream(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(Object callLog) {
        writer.println(callLog.toString());
        writer.flush();
    }

    public void close() throws IOException {

    }
}
