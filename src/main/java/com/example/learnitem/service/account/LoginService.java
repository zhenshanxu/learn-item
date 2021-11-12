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
     * @param accountToLogin  账号（手机号/邮箱）密码登录
     * @return 返回结果
     */
    Map<String, Object> accountToLogin(Map<String,Object>accountToLogin);

    /**
     * 验证码登录
     *
     * @param codeToLogin 账号（手机号/邮箱）验证码登录
     * @return 返回结果
     */
    Map<String, Object> codeToLogin(Map<String,Object>codeToLogin);

    /**
     * 用户注册
     *
     * @param signInMap
     * @return
     */
    Map<String, Object> signIn(Map<String, Object> signInMap);

    /**
     * 获取验证码
     *
     * @param account 账号（手机号/邮箱）
     * @return 返回值
     */
    Map<String, Object> getVerifyCode(String account);

}
