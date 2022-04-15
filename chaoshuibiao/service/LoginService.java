package com.chaoshuibiao.service;

import com.chaoshuibiao.bean.User;

/**
 * @author iamdragon
 * @version 1.0
 */
public interface LoginService {
    User findByUserObject(User u);
    User findByUsername(String username);
}
