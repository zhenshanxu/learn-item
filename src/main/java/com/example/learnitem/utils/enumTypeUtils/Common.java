package com.example.learnitem.utils.enumTypeUtils;

import cn.hutool.crypto.SecureUtil;
import com.example.learnitem.config.SystemObject;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.utils
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-05 14:08.
 * @Description: 公共的，常见的
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
                + "     <h3>${name} 您好!</h3>"
                + "<h3>您登录的账号 ${name} 所需的 ${item} 的令牌验证码 为：</h3>"
                + "<div>"
                + "<p style='font-size:25px;color:darkblue;line-height:10px'> ${verifyCode} </p>"
                + "<p style='font-size:15px;color:red;line-height:10px'>有效时间 ${time} 分钟有效</p>"
                + "<p style='font-size:15px;color:red;line-height:1px'>为保证账号安全，请勿向任何人提供验证码</p>"
                + "</div>";
    }

    /**
     * 返回md5加密后的密码，根据当前配置的salt
     *
     */
    public static String getPasswordMd5(int userId,String password){
        return SecureUtil.md5(SystemObject.myConfig.getMd5Salt()+userId+password);
    }

}
