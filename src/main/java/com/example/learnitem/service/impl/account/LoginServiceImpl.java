package com.example.learnitem.service.impl.account;

import com.example.learnitem.service.account.LoginService;
import com.example.learnitem.utils.Common;
import com.example.learnitem.utils.Constant;
import com.example.learnitem.utils.sendUtils.MailSendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    private final MailSendUtil mailSendUtil;

    @Autowired
    public LoginServiceImpl(MailSendUtil mailSendUtil) {
        this.mailSendUtil = mailSendUtil;
    }


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
        Map<String,Object> result = new HashMap<>();
        boolean isMail = account.matches(Constant.MAIL_RULES);
        int verifyCode = Common.getRandomCode();
        if(isMail){
           String content = Common.getVerifyCodeHtml();
           content = content.replace("${name}", account).replace("${item}", "学习项目").replace("${verifyCode}", String.valueOf(verifyCode));
           mailSendUtil.sendWithHtml(account,"验证码",content);
        }else{
            //todo 添加短信
        }
        return null;
    }
}
