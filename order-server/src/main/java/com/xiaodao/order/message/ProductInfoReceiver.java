package com.xiaodao.order.message;


import com.xiaodao.order.utils.JsonUtil;
import com.xiaodao.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 * @ClassName : ProductInfoReceiver
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/8  0:05
 * @Version : 1.0
 **/
@Slf4j
@Component
public class ProductInfoReceiver {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final  String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
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
        List<ProductInfoOutput>  productInfoOutputList  = (List<ProductInfoOutput>) JsonUtil.fromJson(message, new TypeReference<List<ProductInfoOutput>>( ) {

        });

        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),String.valueOf(productInfoOutput.getProductStock()));

        }
    }
}
