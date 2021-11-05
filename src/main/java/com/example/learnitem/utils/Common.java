package com.example.learnitem.utils;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.utils
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-05 14:08.
 * @Description: 公共的
 */

@Component
public class Common {

    /**
     * 获取一个6位整数
     *
     * @return
     */
    public static int getRandomCode() {
        return (int) ((Math.random() * 900000) + 100000);
    }

    /**
     * 生成邮箱验证码
     *
     * @return
     */
    public static String getVerifyCodeHtml() {
        return "<h2>亲爱的用户：</h2>"
                + "<h3>${name} 您好!</h3>"
                + "<h3>您登录的账号 ${name} 所需的 ${item} 的令牌验证码 为：</h3>"
                + "<div style ='margin-top:50px'>"
                + "<h1>${verifyCode}</h1>"
                + "</div>";
    }

}
