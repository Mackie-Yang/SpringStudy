package com.yy.dao.impl;

import com.yy.dao.UserDao;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Mysql获取用户！");
    }
}
