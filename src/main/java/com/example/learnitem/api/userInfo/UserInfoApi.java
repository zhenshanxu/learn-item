package com.example.learnitem.api.userInfo;

import com.example.learnitem.bean.assist.ResponseBean;
import com.example.learnitem.bean.userInfo.UserInfoBean;
import com.example.learnitem.dao.userInfo.UserInfoDao;
import com.example.learnitem.service.userInfo.IUserInfoService;
import com.example.learnitem.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.api.userInfo
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-03 10:34.
 * @Description:
 */
@Api(tags = "用户管理")
@RestController
public class UserInfoApi {

    @Autowired
    IUserInfoService userInfoService;

    @ApiOperation("添加用户信息")
    @PostMapping("/api/saveUserInfo")
    public ResponseBean saveUserInfo(@RequestBody UserInfoBean userInfo) {
        ResponseBean response = new ResponseBean();
        try {
            Map<String, Object> flag = userInfoService.saveUser(userInfo);
            if (flag.containsKey(Constant.ERROR_VALUE)) {
                response.setSuccess(false);
                response.setErrorMessage(flag.get(Constant.ERROR_VALUE).toString());
            } else {
                response.setSuccess(true);
                response.setResult("新用户添加成功!");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @ApiOperation("修改更新用户信息")
    @PostMapping("/api/updateUserInfo")
    public ResponseBean updateUserInfo(@RequestBody UserInfoBean userInfo) {
        ResponseBean response = new ResponseBean();
        try {
            Map<String, Object> flag = userInfoService.updateUser(userInfo);
            if (flag.containsKey(Constant.ERROR_VALUE)) {
                response.setSuccess(false);
                response.setErrorMessage(flag.get(Constant.ERROR_VALUE).toString());
            } else {
                response.setSuccess(true);
                response.setResult("新用户添加成功!");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @ApiOperation("用户信息删除")
    @PostMapping("/api/deleteUserInfo")
    public ResponseBean deleteUserInfo(@RequestBody UserInfoBean userInfo) {
        ResponseBean response = new ResponseBean();
        try {
            userInfoService.deleteUser(userInfo);
            response.setSuccess(true);
            response.setResult("用户信息删除成功!");
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

}
