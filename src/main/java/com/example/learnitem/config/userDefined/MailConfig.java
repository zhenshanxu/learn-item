package com.example.learnitem.config.userDefined;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.config.userDefined
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-04 13:52.
 * @Description:
 */

@Data
@Component
@ConfigurationProperties(prefix = "spring.mail")
public class MailConfig {

    /**
     * 邮件配置名
     */
    private String userName;

    /**
     * 邮件授权
     */
    private String password;

    /**
     * 邮箱host
     */
    private String host;
}
