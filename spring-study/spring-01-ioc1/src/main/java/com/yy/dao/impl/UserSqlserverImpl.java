package com.yy.dao.impl;

import com.yy.dao.UserDao;

public class UserSqlserverImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Sqlserver获取用户数据！");
    }
}
