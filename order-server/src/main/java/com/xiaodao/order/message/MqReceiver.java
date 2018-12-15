package com.xiaodao.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : MqReceiver
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/3  22:00
 * @Version : 1.0
 **/
@Component
@Slf4j
public class MqReceiver {
   //1 @RabbitListener(queues = "MyQueue")
    //2自动创建队列
    //@RabbitListener(queuesToDeclare = @Queue("MyQueue"))
    //3自动创建Exchange和Queue邦迪你那个
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("MyQueue"),
            exchange = @Exchange("MyExchange")
    ))
    public void process(String message){
        log.info("MQReceiver:{}",message);


    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            key ="computer" ,
            exchange = @Exchange("order")
    ))
    public void computerProcess(String message){
        /**
         * @Description :数码供应商 接收消息
         * @Params :
            * @param : message
         * @Author : xiaodao
         * @Date : 2018/12/4  22:29
         * @Return :  void
         * @Throws :
         **/
        log.info("computer  MQReceiver:{}",message);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            key ="fruit" ,
            exchange = @Exchange("order")
    ))
    public void fruitProcess(String message){
        /**
         * @Description :数码供应商 接收消息
         * @Params :
         * @param : message
         * @Author : xiaodao
         * @Date : 2018/12/4  22:29
         * @Return :  void
         * @Throws :
         **/
        log.info("computer  MQReceiver:{}",message);


    }
}
