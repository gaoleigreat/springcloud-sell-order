package com.xiaodao.order.controller;

import com.xiaodao.order.dto.OrderDTO;
import com.xiaodao.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : MyMessageController
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/7  21:51
 * @Version : 1.0
 **/
@RestController
public class MyMessageController {
    @Autowired @Qualifier(value = "myMessage")
    private MessageChannel myMessage;
    @RequestMapping("/myMessage")
    public void send(){
        OrderDTO orderDTO =  new OrderDTO();
        orderDTO.setOrderId("213");
        orderDTO.setBuyerOpenid("324");
        orderDTO.setBuyerName("xiaodao");
        orderDTO.setBuyerPhone("1232344354");
        myMessage.send(MessageBuilder.withPayload(orderDTO).build());
    }
}
