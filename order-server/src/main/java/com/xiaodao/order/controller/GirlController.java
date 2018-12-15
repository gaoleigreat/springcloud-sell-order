package com.xiaodao.order.controller;

import com.xiaodao.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : GirlController
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/1  18:01
 * @Version : 1.0
 **/
@RestController
@RefreshScope
public class GirlController {
    @Autowired
    private GirlConfig girlConfig;
   @GetMapping("/girl/print")
    public String  print(){
        return "name:" +girlConfig.getName()+"age:" +girlConfig.getAge();
    }

}
