package com.xiaodao.order.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


/**
 * @ClassName : StreamClient
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/5  1:35
 * @Version : 1.0
 **/
public interface StreamClient {
     @Output("myMessage")
     MessageChannel output();
     @Output("myMessage1")
     MessageChannel output1();



}
