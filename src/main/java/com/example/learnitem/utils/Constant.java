package com.example.learnitem.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.utils
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-01 15:31.
 * @Description: 常量
 */

@Component
public class Constant {

    public static final long VERIFY_CODE_VALID_TIME = 60;

    /**
     * token有效时间(24小时)
     */
    public static final long TOKEN_EXPIRE_TIME = 60 * 60 * 1000L;

    /**
     * JWT_ID
     */
    public static final String JWT_ID = UUID.randomUUID().toString();

    /**
     * 私钥
     */
    public static final String TOKEN_SECRET = "encryption encoding";

    /**
     * 邮件规则
     */
    public static String MAIL_RULES = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$";

    /**
     * 错误值
     */
    public static String ERROR_VALUE = "error";

    /**
     * 删除状态
     */
    public static int DELETE_STATUS = -1;
}
