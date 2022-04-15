package com.chaoshuibiao.dao;

import com.chaoshuibiao.bean.User;

/**
 * @author iamdragon
 * @version 1.0
 */
public interface LoginDao {
    User findByUserObject(User u);

    User findByUsername(String username);
}
