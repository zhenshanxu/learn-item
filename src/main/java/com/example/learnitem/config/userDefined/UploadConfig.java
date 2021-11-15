package com.example.learnitem.config.userDefined;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.config.userDefined
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-01 14:31.
 * @Description:
 */

@Data
@Component
@ConfigurationProperties(prefix = "spring.upload-config")
public class UploadConfig {

    /**
     * 文件上传根目录
     */
    private String rootFolder;

}
