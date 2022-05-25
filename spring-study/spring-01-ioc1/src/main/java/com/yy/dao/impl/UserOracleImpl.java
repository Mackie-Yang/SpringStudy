package com.yy.dao.impl;

import com.yy.dao.UserDao;

public class UserOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Oracle获取用户数据！");
    }
}
