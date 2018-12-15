package com.xiaodao.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @ClassName : GirlConfig
 * @Description : TODO
 * @Author : xiaodao
 * @Date : 2018/12/1  17:59
 * @Version : 1.0
 **/
@Data
@Component
@ConfigurationProperties("girl")
@RefreshScope
public class GirlConfig {
    private String name;
    private Integer age;
}
