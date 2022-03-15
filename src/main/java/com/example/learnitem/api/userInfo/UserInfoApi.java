package com.example.learnitem.api.userInfo;

import com.example.learnitem.bean.assist.ResponseBean;
import com.example.learnitem.bean.userInfo.UserInfoBean;
import com.example.learnitem.service.userInfo.IUserInfoService;
import com.example.learnitem.utils.enumTypeUtils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    @PostMapping("/api/addUserInfo")
    public ResponseBean addUserInfo(@RequestBody UserInfoBean userInfo) {
        ResponseBean response = new ResponseBean();
        try {
            Map<String, Object> flag = userInfoService.addUserInfo(userInfo);
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
            Map<String, Object> flag = userInfoService.updateUserInfo(userInfo);
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
            userInfoService.deleteUserInfo(userInfo);
            response.setSuccess(true);
            response.setResult("用户信息删除成功!");
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @ApiOperation("查询用户信息")
    @PostMapping("/api/queryUserInfo")
    public ResponseBean queryUserInfo(@RequestBody UserInfoBean userInfo) {
        ResponseBean response = new ResponseBean();
        try {
            List<UserInfoBean> userInfoList = userInfoService.queryUserInfo(userInfo);
            response.setSuccess(true);
            response.setResult(userInfoList);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

}
