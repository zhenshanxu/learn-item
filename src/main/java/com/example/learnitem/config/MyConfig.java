package com.example.learnitem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.config
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-01 14:31.
 * @Description:
 */

@Data
@Component
@ConfigurationProperties(prefix = "spring.myconfig")
public class MyConfig {

    private Boolean swaggerEnable;

}
