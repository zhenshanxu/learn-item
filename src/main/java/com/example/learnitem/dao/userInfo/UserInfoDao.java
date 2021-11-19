package com.example.learnitem.dao.userInfo;

import com.example.learnitem.bean.userInfo.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.dao
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-03 10:25.
 * @Description:
 */

@Mapper
public interface UserInfoDao {

    /**
     * 插入用户信息
     *
     * @param userInfoBean
     * @return
     */
    void addUserInfo(UserInfoBean userInfoBean);

    /**
     * 更新用户信息
     *
     * @param userInfoBean
     * @return
     */
    void updateUserInfo(UserInfoBean userInfoBean);


    /**
     * 获取用户
     *
     * @param userInfoBean
     * @return
     */
    List<UserInfoBean> getUserList(UserInfoBean userInfoBean);

}
