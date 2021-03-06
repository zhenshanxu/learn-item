package com.example.learnitem.api.account;

import com.example.learnitem.bean.assist.ResponseBean;
import com.example.learnitem.service.account.LoginService;
import com.example.learnitem.utils.enumTypeUtils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    LoginService loginService;

    @ApiOperation("获取验证码")
    @PostMapping("/api/getVerifyCode")
    public ResponseBean getVerifyCode(@RequestBody Map<String, Object> accountObject) {
        ResponseBean response = new ResponseBean();
        try {
            Map<String, Object> flag = loginService.getVerifyCode(accountObject.get(Constant.ACCOUNT).toString());
            if (flag.containsKey(Constant.ERROR_VALUE)) {
                response.setSuccess(false);
                response.setErrorMessage(flag.get(Constant.ERROR_VALUE).toString());
            } else {
                response.setSuccess(true);
                response.setResult("验证码发送成功!");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @ApiOperation("验证码登录")
    @PostMapping("/api/codeToLogin")
    public ResponseBean codeToLogin(@RequestBody Map<String, Object> codeToLogin) {
        ResponseBean response = new ResponseBean();
        try {
            Map<String, Object> flag = loginService.codeToLogin(codeToLogin);
            if (flag.containsKey(Constant.ERROR_VALUE)) {
                response.setSuccess(false);
                response.setErrorMessage(flag.get(Constant.ERROR_VALUE).toString());
            } else {
                response.setSuccess(true);
                response.setResult(flag);
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @ApiOperation("密码登录")
    @PostMapping("/api/accountToLogin")
    public ResponseBean accountToLogin(@RequestBody Map<String, Object> accountToLogin) {
        ResponseBean response = new ResponseBean();
        try {
            Map<String, Object> flag = loginService.accountToLogin(accountToLogin);
            if (flag.containsKey(Constant.ERROR_VALUE)) {
                response.setSuccess(false);
                response.setErrorMessage(flag.get(Constant.ERROR_VALUE).toString());
            } else {
                response.setSuccess(true);
                response.setResult(flag);
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    @ApiOperation("新用户注册")
    @PostMapping("/api/signUp")
    public ResponseBean signUp(@RequestBody Map<String, Object> signUpParam) {
        ResponseBean response = new ResponseBean();
        try {
            Map<String, Object> flag = loginService.signUp(signUpParam);
            if (flag.containsKey(Constant.ERROR_VALUE)) {
                response.setSuccess(false);
                response.setErrorMessage(flag.get(Constant.ERROR_VALUE).toString());
            } else {
                response.setSuccess(true);
                response.setResult(flag);
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
