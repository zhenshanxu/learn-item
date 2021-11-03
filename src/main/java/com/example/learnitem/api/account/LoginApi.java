package com.example.learnitem.api.account;

import com.example.learnitem.service.userInfo.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.api.system
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-03 10:32.
 * @Description:
 */

@Api(tags = "登录管理")
@RestController
public class LoginApi {

    @Autowired
    IUserService userService;
}
