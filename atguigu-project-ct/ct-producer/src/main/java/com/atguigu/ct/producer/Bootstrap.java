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

        if(args.length < 2){
            System.err.println("请输入正确格式的参数：\n参数1：联系人路径 \n参数2：通话记录输出路径");
            System.exit(1);
        }


        producer.setIn(new LocalFileDataIn(args[0]));
        producer.setOut(new LocalFileDataOut(args[1]));
        //生产数据
        producer.produce();
        //关闭生产者对象
        producer.close();
    }
}
