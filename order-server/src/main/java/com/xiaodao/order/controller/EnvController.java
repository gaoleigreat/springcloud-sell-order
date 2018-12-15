package com.xiaodao.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : EnvController
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/1  11:51
 * @Version : 1.0
 **/
@RestController
@RequestMapping("/env")
@RefreshScope
public class EnvController {
    @Value("${env}")
    private String env;
    @GetMapping("/print")
    public String print(){
        return env;
    }

}
