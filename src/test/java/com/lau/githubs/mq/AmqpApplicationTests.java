package com.lau.githubs.mq;

import com.lau.githubs.common.Constants;
import com.lau.githubs.rabbitmq.ImmediateSender;
import com.lau.githubs.rabbitmq.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpApplicationTests {

    @Autowired
    ImmediateSender immediateSender;
    @Test
    public void test() {
        immediateSender.send("我是一个延时消息", Config.DEAD_LETTER_EXCHANGE, Config.DELAY_ROUTING_KEY,10000);//3秒

        //让服务一直挂起，不然，接收消息时，服务已经停了
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}