package com.example.learnitem.config;

import com.example.learnitem.config.userDefined.MailConfig;
import com.example.learnitem.config.userDefined.MyConfig;
import com.example.learnitem.config.userDefined.UploadConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.config
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-01 14:54.
 * @Description: 系统对象
 */

@Component
public class SystemObject {

    public static MyConfig myConfig;

    public static MailConfig mailConfig;

    public static UploadConfig uploadConfig;

    @Autowired
    void setMyConfig(MyConfig myConfig) {
        SystemObject.myConfig = myConfig;
    }

    @Autowired
    void setMailConfig(MailConfig mailConfig) {
        SystemObject.mailConfig = mailConfig;
    }

    @Autowired
    void setUploadConfig(UploadConfig uploadConfig) {
        SystemObject.uploadConfig = uploadConfig;
    }
}
