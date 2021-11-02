package com.example.learnitem.service;

import com.example.learnitem.bean.userInfo.UserBean;
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
public class IUserServiceImpl implements IUserService{

    @Override
    public Map<String, Object> login(UserBean userBean) {
        return null;
    }

    @Override
    public Map<String, Object> saveUser(UserBean userBean) {
        return null;
    }

    @Override
    public Map<String, Object> updateUser(UserBean userBean) {
        return null;
    }

    @Override
    public void deleteUser(UserBean userBean) {

    }

    @Override
    public List<UserBean> getUserList(UserBean userBean) {
        return null;
    }
}
