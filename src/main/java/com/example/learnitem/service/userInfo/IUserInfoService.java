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
     * 插入用户信息
     *
     * @param userInfoBean
     * @return
     */
    Map<String, Object> addUserInfo(UserInfoBean userInfoBean);

    /**
     * 更新用户信息
     *
     * @param userInfoBean
     * @return
     */
    Map<String, Object> updateUserInfo(UserInfoBean userInfoBean);

    /**
     * 删除用户
     *
     * @param userInfoBean
     */
    void deleteUserInfo(UserInfoBean userInfoBean);

    /**
     * 获取用户
     *
     * @param userInfoBean
     * @return
     */
    List<UserInfoBean> queryUserInfo(UserInfoBean userInfoBean);
}
