package com.atguigu.ct.producer.bean;

import com.atguigu.ct.common.bean.DataIn;
import com.atguigu.ct.common.bean.DataOut;
import com.atguigu.ct.common.bean.Producer;
import com.atguigu.ct.common.constant.Names;
import com.atguigu.ct.common.util.DateUtil;
import com.atguigu.ct.common.util.NumUtil;

import java.io.IOException;
import java.text.ParseException;
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

            while (flag) {
                //从通讯录中获取两个电话号码
                int call1_index = new Random().nextInt(contacts.size());
                int call2_index;
                while (true) {
                    call2_index = new Random().nextInt(contacts.size());
                    if (call1_index != call2_index) {
                        break;
                    }
                }
                Contact call1 = contacts.get(call1_index);
                Contact call2 = contacts.get(call2_index);
                //生成随机的通话时间
                String startTime = "2019-01-01 00:00:00";
                String endTime = "2019-12-31 23:59:59";

                long startTimestamp = DateUtil.parse(startTime, Names.TimePartten.getValue());
                long endTimestamp = DateUtil.parse(endTime, Names.TimePartten.getValue());
                long callTimeTimestamp = (long) (startTimestamp + (endTimestamp - startTimestamp) * Math.random());
                String callTime = DateUtil.format(callTimeTimestamp, Names.TimePartten.getValue());

                //生成随机的通话时长
                int durationInt = new Random().nextInt(3600);
                String duration = NumUtil.format(durationInt, "0000");

                //生成通话记录
                CallLog callLog = new CallLog(call1.getPhone(), call2.getPhone(), callTime, duration);
                System.out.println(callLog);
                //将通话记录写道数据文件中
                out.write(callLog);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 关闭生产者
     *
     * @throws IOException
     */
    public void close() throws IOException {
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
    }
}
