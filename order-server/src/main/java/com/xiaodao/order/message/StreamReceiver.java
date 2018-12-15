package com.xiaodao.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @ClassName : StreamReceiver
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/5  19:01
 * @Version : 1.0
 **/
@Slf4j
@Component
@EnableBinding(value={StreamClient1.class})
public class StreamReceiver {
    @StreamListener("myMessage")
    @SendTo("myMessage1")
    public String receive(Object payLoad){
        log.info("received StreamReceiver  {}",payLoad);
        return "高磊";
    }
    @StreamListener("myMessage1")
    public void receive1(Object payLoad){
        log.info("received StreamReceiver  {}",payLoad);
    }

}
