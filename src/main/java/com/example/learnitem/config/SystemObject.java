package com.example.learnitem.config;

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

    @Autowired
    void setMyConfig(MyConfig myConfig){
        SystemObject.myConfig = myConfig;
    }

    @Autowired
    void setMailConfig(MailConfig mailConfig){
        SystemObject.mailConfig = mailConfig;
    }
}
