package com.example.learnitem.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.utils
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-01 15:31.
 * @Description:
 */

@Component
public class CommonUtil {

    /**
     * token有效时间(365*24小时)
     */
    public static final long TOKEN_EXPIRE_TIME = 24 * 60 * 60 * 1000L;

    /**
     * JWT_ID
     */
    public static final String JWT_ID = UUID.randomUUID().toString();

    /**
     * 私钥
     */
    public static final String TOKEN_SECRET = "encryption encoding";
}
