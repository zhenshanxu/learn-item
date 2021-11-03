package com.example.learnitem.service.userInfo;

import com.example.learnitem.bean.userInfo.UserBean;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.service
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-02 14:22.
 * @Description:
 */

public interface IUserService {

    /**
     * 用户登录
     *
     * @param userBean
     * @return
     */
    Map<String, Object> login(UserBean userBean);

    /**
     * 插入用户信息
     *
     * @param userBean
     * @return
     */
    Map<String, Object> saveUser(UserBean userBean);

    /**
     * 更新用户信息
     *
     * @param userBean
     * @return
     */
    Map<String, Object> updateUser(UserBean userBean);

    /**
     * 删除用户
     *
     * @param userBean
     */
    void deleteUser(UserBean userBean);

    /**
     * 获取用户
     *
     * @param userBean
     * @return
     */
    List<UserBean> getUserList(UserBean userBean);
}
