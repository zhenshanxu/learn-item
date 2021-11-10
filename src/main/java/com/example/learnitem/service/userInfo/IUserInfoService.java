package com.example.learnitem.service.userInfo;

import com.example.learnitem.bean.userInfo.UserInfoBean;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.service
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-02 14:22.
 * @Description:
 */

public interface IUserInfoService {

    /**
     * 用户登录
     *
     * @param userInfoBean
     * @return
     */
    Map<String, Object> login(UserInfoBean userInfoBean);

    /**
     * 插入用户信息
     *
     * @param userInfoBean
     * @return
     */
    Map<String, Object> saveUser(UserInfoBean userInfoBean);

    /**
     * 更新用户信息
     *
     * @param userInfoBean
     * @return
     */
    Map<String, Object> updateUser(UserInfoBean userInfoBean);

    /**
     * 删除用户
     *
     * @param userInfoBean
     */
    void deleteUser(UserInfoBean userInfoBean);

    /**
     * 获取用户
     *
     * @param userInfoBean
     * @return
     */
    List<UserInfoBean> getUserList(UserInfoBean userInfoBean);
}
