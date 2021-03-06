package com.example.learnitem.service.impl.userInfo;

import com.example.learnitem.bean.userInfo.UserInfoBean;
import com.example.learnitem.dao.userInfo.UserInfoDao;
import com.example.learnitem.service.userInfo.IUserInfoService;
import com.example.learnitem.utils.enumTypeUtils.Constant;
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
    public Map<String, Object> addUserInfo(UserInfoBean userInfoBean) {
        Map<String, Object> result = new HashMap<>();
        userInfoDao.addUserInfo(userInfoBean);
        return result;
    }

    @Override
    public Map<String, Object> updateUserInfo(UserInfoBean userInfoBean) {
        Map<String, Object> result = new HashMap<>();
        userInfoDao.updateUserInfo(userInfoBean);
        return result;
    }

    @Override
    public void deleteUserInfo(UserInfoBean userInfoBean) {
        userInfoBean.setIsDelete(Constant.DELETE_STATUS);
        userInfoDao.updateUserInfo(userInfoBean);
    }

    @Override
    public List<UserInfoBean> queryUserInfo(UserInfoBean userInfoBean) {
        if (userInfoBean.getPage() > 0) {
            userInfoBean.setPage((userInfoBean.getPage() - 1) * userInfoBean.getPageSize());
        }
        return userInfoDao.queryUserInfo(userInfoBean);
    }
}
