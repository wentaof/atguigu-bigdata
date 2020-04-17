package com.atguigu.ct.producer.io;

import com.atguigu.ct.common.bean.Data;
import com.atguigu.ct.common.bean.DataIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 本地文件数据输入
 */
public class LocalFileDataIn implements DataIn {

    public String path;
    BufferedReader reader;
    public LocalFileDataIn(String s) {
        setPath(s);
    }

    /**
     * 在设置路径的时候 直接创建了流对象，给下面使用
     * @param path
     */
    public void setPath(String path) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object read() throws IOException {
        return null;
    }

    /**
     * 读取数据返回数据集合
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T extends Data> List<T> read(Class<T> clazz) throws IOException {
        List<T> ts = new ArrayList<T>();
        try {
            //从数据文件中获取所有的数据
            String line = null;
            while ((line=reader.readLine()) != null ){
                T t = clazz.newInstance();
                t.setValue(line);
                ts.add(t);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //并将数据转换为指定对象，封装成集合返回
        return ts;
    }

    /**
     * 关闭资源
     * @throws IOException
     */
    public void close() throws IOException {
        if(reader != null){
            reader.close();
        }
    }
}
