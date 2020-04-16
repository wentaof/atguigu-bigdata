package com.atguigu.ct.producer.bean;

import com.atguigu.ct.common.bean.DataIn;
import com.atguigu.ct.common.bean.DataOut;
import com.atguigu.ct.common.bean.Producer;

import java.io.IOException;

/**
 * 本地数据文件的生产者
 */
public class LocalFileProducer implements Producer {
    private DataIn in;
    private DataOut out;
    private volatile boolean flag = true;


    public void setIn(DataIn in) {
        this.in = in;
    }

    public void setOut(DataOut out) {
        this.out = out;
    }

    /**
     * 生产数据
     */
    public void produce() {
        //读取通讯录的数据

       while (flag){
           //        从通讯录中获取两个电话号码

//        生成随机的通话时间

//        生成随机的通话时长

//        生成通话记录

//        将通话记录写道数据文件中
       }



    }

    /**
     * 关闭生产者
     * @throws IOException
     */
    public void close() throws IOException {
        if ( in != null){
            in.close();
        }
        if ( out != null){
            out.close();
        }
    }
}
