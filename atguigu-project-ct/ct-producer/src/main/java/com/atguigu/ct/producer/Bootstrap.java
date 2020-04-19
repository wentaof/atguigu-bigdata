package com.atguigu.ct.producer;

import com.atguigu.ct.common.bean.Producer;
import com.atguigu.ct.producer.bean.LocalFileProducer;
import com.atguigu.ct.producer.io.LocalFileDataIn;
import com.atguigu.ct.producer.io.LocalFileDataOut;

import java.io.IOException;

/**
 * 启动对象
 */
public class Bootstrap {
    public static void main(String[] args) throws IOException {
        //构建生产者对象
        Producer producer = new LocalFileProducer();
//        producer.setIn(new LocalFileDataIn("E:\\data\\baiduyundownload\\尚学堂\\01\\2.资料\\辅助文档\\contact.log"));
//        producer.setOut(new LocalFileDataOut("E:\\data\\baiduyundownload\\尚学堂\\01\\2.资料\\辅助文档\\call.log"));


        //生产数据
        producer.produce();
        //关闭生产者对象
        producer.close();
    }
}
