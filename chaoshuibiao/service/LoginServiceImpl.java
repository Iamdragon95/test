package com.chaoshuibiao.service;

import com.chaoshuibiao.bean.User;
import com.chaoshuibiao.dao.LoginDao;
import com.chaoshuibiao.dao.LoginDaoImpl;

/**
 * @author iamdragon
 * @version 1.0
 */
public class LoginServiceImpl implements LoginService{
    @Override
    public User findByUserObject(User u) {
        LoginDao ld=new LoginDaoImpl();
        return ld.findByUserObject(u);
    }
    @Override
    public User findByUsername(String username) {
        LoginDao ld = new LoginDaoImpl();
        return ld.findByUsername(username);
    }
}
