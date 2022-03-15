package com.example.learnitem.config.userDefined;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.config.userDefined
 * @Author: ZhenShanXu
 * @CreateTime: 2022-03-15 11:19.
 * @Description: 地址配置 TODO 待定（临时）
 */

@Data
@Component
@ConfigurationProperties(prefix = "spring.hosts-config")
public class HostsConfig {
    /**
     * 单点登录地址 TODO 待定（临时）
     */
    private String ssoHost;
}
