package com.yy.service.impl;

import com.yy.dao.UserDao;
import com.yy.dao.impl.UserDaoImpl;
import com.yy.dao.impl.UserDaoMysqlImpl;
import com.yy.dao.impl.UserOracleImpl;
import com.yy.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    // 利用set进行动态实现值的注入！
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
