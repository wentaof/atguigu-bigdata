package com.atguigu.ct.producer.bean;

import com.atguigu.ct.common.bean.DataIn;
import com.atguigu.ct.common.bean.DataOut;
import com.atguigu.ct.common.bean.Producer;
import com.atguigu.ct.common.util.NumUtil;

import java.io.IOException;
import java.util.List;
import java.util.Random;

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

        try {
            //读取通讯录的数据
            List<Contact> contacts = in.read(Contact.class);

            while (flag){
                //从通讯录中获取两个电话号码
                int call1_index=new Random().nextInt(contacts.size());
                int call2_index;
                while (true){
                    call2_index=new Random().nextInt(contacts.size());
                    if(call1_index != call2_index){
                        break;
                    }
                }
                Contact call1 = contacts.get(call1_index);
                Contact call2 = contacts.get(call2_index);
                //生成随机的通话时间
                int durationInt = new Random().nextInt(3600);
                String duration = NumUtil.format(durationInt, "0000");
                //生成随机的通话时长

                //生成通话记录

                //将通话记录写道数据文件中

            }
        } catch (IOException e) {
            e.printStackTrace();
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
