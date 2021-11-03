package com.example.learnitem.service.impl.account;

import com.example.learnitem.service.account.LoginService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.service.impl.account
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-03 11:04.
 * @Description:
 */

@Service
public class LoginServiceImpl implements LoginService {

    /**
     * 账号登录
     *
     * @param account  账号（手机号/邮箱）
     * @param password 密码
     * @return 返回值
     */
    @Override
    public Map<String, Object> accountToLogin(String account, String password) {
        return null;
    }

    /**
     * 验证码登录
     *
     * @param account 账号（手机号/邮箱）
     * @param code    验证码
     * @return 返回值
     */
    @Override
    public Map<String, Object> codeToLogin(String account, String code) {
        return null;
    }

    /**
     * 获取验证码
     *
     * @param account 账号（手机号/邮箱）
     * @return 返回值
     */
    @Override
    public Map<String, Object> getVerifyCode(String account) {
        return null;
    }
}
