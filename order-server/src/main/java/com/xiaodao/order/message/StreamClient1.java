package com.xiaodao.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ClassName : StreamClient1
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/6  1:09
 * @Version : 1.0
 **/
public interface StreamClient1 {
    @Input("myMessage")
    SubscribableChannel input();
    @Input("myMessage1")
    SubscribableChannel input1();
}
