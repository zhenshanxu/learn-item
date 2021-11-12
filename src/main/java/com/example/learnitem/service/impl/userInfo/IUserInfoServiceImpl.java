package com.example.learnitem.service.impl.userInfo;

import com.example.learnitem.bean.userInfo.UserInfoBean;
import com.example.learnitem.dao.userInfo.UserInfoDao;
import com.example.learnitem.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Autowired
    private final UserInfoDao userInfoDao;

    public IUserInfoServiceImpl(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public Map<String, Object> saveUser(UserInfoBean userInfoBean) {
        Map<String, Object> result = new HashMap<>();
        userInfoDao.saveUser(userInfoBean);
        return result;
    }

    @Override
    public Map<String, Object> updateUser(UserInfoBean userInfoBean) {
        Map<String, Object> result = new HashMap<>();
        userInfoDao.updateUser(userInfoBean);
        return result;
    }

    @Override
    public void deleteUser(UserInfoBean userInfoBean) {
        userInfoDao.updateUser(userInfoBean);
    }

    @Override
    public List<UserInfoBean> getUserList(UserInfoBean userInfoBean) {
        return userInfoDao.getUserList(userInfoBean);
    }
}
