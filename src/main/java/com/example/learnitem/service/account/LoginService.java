package com.example.learnitem.service.account;

import java.util.Map;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.service.account
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-03 11:03.
 * @Description:
 */

public interface LoginService {

    /**
     * 账号登录
     *
     * @param account  账号（手机号/邮箱）
     * @param password 密码
     * @return 返回结果
     */
    Map<String, Object> accountToLogin(String account, String password);

    /**
     * 验证码登录
     *
     * @param account 账号（手机号/邮箱）
     * @param code    验证码
     * @return 返回结果
     */
    Map<String, Object> codeToLogin(String account, String code);

    /**
     * 获取验证码
     *
     * @param account 账号（手机号/邮箱）
     * @return 返回值
     */
    Map<String, Object> getVerifyCode(String account);
}
