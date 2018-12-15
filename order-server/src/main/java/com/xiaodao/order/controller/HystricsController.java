package com.xiaodao.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @ClassName : HystricsController
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/11  21:51
 * @Version : 1.0
 **/
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystricsController {
    //超时配置
    /*@HystrixCommand(commandProperties = {

    })*/

   //上面命令加入配置文件
    //@HystrixCommand
   @HystrixCommand(commandProperties = {
           @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
           @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
           @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
           @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
           @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
   })
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(){
        RestTemplate restTemplate = new RestTemplate();
      return  restTemplate.postForObject( "http://192.168.118.1:7001/product/listForOrder", Arrays.asList("157875196366160022"),String.class);
    }
    private String fallback(){
        return "太拥挤了，请稍后重试";
    }
    private String defaultFallback(){
        return "太拥挤了，请稍后重试!!!!!!!!!!!!!!!!!!!!!";
    }
}
