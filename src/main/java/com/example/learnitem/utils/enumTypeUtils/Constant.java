package com.example.learnitem.utils.enumTypeUtils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.utils
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-01 15:31.
 * @Description: 常数，常量
 */

@Component
public class Constant {

    /**
     * 验证码有效时间
     */
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
     * 错误值-错误状态
     */
    public static String ERROR_VALUE = "error";

    /**
     * 删除状态
     */
    public static int DELETE_STATUS = -1;

    /**
     * 默认初始状态
     */
    public static int INITIAL_STATUS = 1;

    /**
     * 令牌 - 标识
     */
    public static String TOKEN_SYMBOL = "token";

    /**
     * 账号 - 标识
     */
    public static String ACCOUNT = "account";

    /**
     * 账号密码 - 标识
     */
    public static String PASSWORD = "password";

    /**
     * 设置默认的账号密码
     */
    public static String ACQUIESCENT_PASSWORD = "123456";

    /**
     * 验证码 - 标识
     */
    public static String VERIFY_CODE = "verifyCode";

    /**
     * 内容 - 标识
     */
    public static String CONTENT = "content";


}
