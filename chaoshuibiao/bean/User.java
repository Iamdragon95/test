package com.chaoshuibiao.bean;

/**
 * @author iamdragon
 * @version 1.0
 */
public class User {
    private String username;
    private String pwd;

    public User() {
    }

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
