package com.example.learnitem.service.impl.account;

import com.example.learnitem.bean.userInfo.UserInfoBean;
import com.example.learnitem.config.JwtUtil;
import com.example.learnitem.config.redis.RedisService;
import com.example.learnitem.service.account.LoginService;
import com.example.learnitem.service.userInfo.IUserInfoService;
import com.example.learnitem.utils.Common;
import com.example.learnitem.utils.Constant;
import com.example.learnitem.utils.sendUtils.MailSendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
    private final RedisService redisService;
    private final IUserInfoService userInfoService;

    @Autowired
    public LoginServiceImpl(MailSendUtil mailSendUtil, RedisService redisService, IUserInfoService userInfoService) {
        this.mailSendUtil = mailSendUtil;
        this.redisService = redisService;
        this.userInfoService = userInfoService;
    }

    /**
     * 账号登录
     *
     * @param accountToLogin  账号（手机号/邮箱）密码登录
     * @return 返回值
     */
    @Override
    public Map<String, Object> accountToLogin(Map<String,Object> accountToLogin) {
        Map<String,Object> result = new HashMap<>();
        UserInfoBean userInfo = new UserInfoBean();
        String account = String.valueOf(accountToLogin.get("account"));
        String password = String.valueOf(accountToLogin.get("password"));
        boolean isMail = account.matches(Constant.MAIL_RULES);
        if(isMail){
            userInfo.setEmail(account);
        }else{
            userInfo.setPhone(account);
        }
        List<UserInfoBean> userInfoList = userInfoService.getUserList(userInfo);
        UserInfoBean user = new UserInfoBean();
        if(userInfoList.size()==0){
            result.put(Constant.ERROR_VALUE, "未检测到账号,请注册后使用!");
            return result;
        }else{
            user = userInfoList.get(0);
        }
        if(!user.getPassword().equals(Common.getPasswordMd5(user.getId(),password))){
            result.put(Constant.ERROR_VALUE, "密码输入错误,请重新输入!");
            return result;
        }
        String token = JwtUtil.createJWT(user.getId(),account);
        redisService.set(token, user,Constant.TOKEN_EXPIRE_TIME);
        return result;
    }

    /**
     * 验证码登录
     *
     * @param codeToLogin 账号（手机号/邮箱）验证码登录
     * @return 返回值
     */
    @Override
    public Map<String, Object> codeToLogin(Map<String,Object> codeToLogin) {
        Map<String,Object> result = new HashMap<>();
        UserInfoBean userInfo = new UserInfoBean();
        String account = String.valueOf(codeToLogin.get("account"));
        String verifyCode = String.valueOf(codeToLogin.get("verifyCode"));
        Object code = redisService.get(account);
        if(code == null){
            result.put(Constant.ERROR_VALUE, "验证码已过期,请重新获取!");
            return result;
        }
        if (verifyCode == code) {
            result.put(Constant.ERROR_VALUE, "验证码不正确,请重新输入!");
            return result;
        }
        boolean isMail = account.matches(Constant.MAIL_RULES);
        if(isMail){
            userInfo.setEmail(account);
        }else{
            userInfo.setPhone(account);
        }
        List<UserInfoBean> userInfoList = userInfoService.getUserList(userInfo);
        UserInfoBean user = new UserInfoBean();
        if(userInfoList.size()==0){
            result.put(Constant.ERROR_VALUE, "未检测到账号,请注册后使用!");
            return result;
        }else{
            user = userInfoList.get(0);
        }
        String token = JwtUtil.createJWT(user.getId(),account);
        redisService.set(token, user,Constant.TOKEN_EXPIRE_TIME);
        return result;
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
        long time = Constant.VERIFY_CODE_VALID_TIME;
        boolean isMail = account.matches(Constant.MAIL_RULES);
        int verifyCode = Common.getRandomCode();
        if(isMail){
           String content = Common.getVerifyCodeHtml();
           content = content.replace("${name}", account)
                   .replace("${item}", "学习项目")
                   .replace("${verifyCode}", String.valueOf(verifyCode))
                   .replace("${time}", String.valueOf(time/60));
           mailSendUtil.sendWithHtml(account,"验证码",content);
        }//todo 添加短信
        redisService.set(account, verifyCode,time);
        return result;
    }
}
