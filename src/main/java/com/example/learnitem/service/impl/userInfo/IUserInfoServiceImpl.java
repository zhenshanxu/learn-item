package com.example.learnitem.service.impl.userInfo;

import com.example.learnitem.bean.userInfo.UserInfoBean;
import com.example.learnitem.service.userInfo.IUserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.service
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-02 14:50.
 * @Description:
 */
@Service
public class IUserInfoServiceImpl implements IUserInfoService {

    @Override
    public Map<String, Object> login(UserInfoBean userInfoBean) {
        return null;
    }

    @Override
    public Map<String, Object> saveUser(UserInfoBean userInfoBean) {
        return null;
    }

    @Override
    public Map<String, Object> updateUser(UserInfoBean userInfoBean) {
        return null;
    }

    @Override
    public void deleteUser(UserInfoBean userInfoBean) {

    }

    @Override
    public List<UserInfoBean> getUserList(UserInfoBean userInfoBean) {
        return null;
    }
}
