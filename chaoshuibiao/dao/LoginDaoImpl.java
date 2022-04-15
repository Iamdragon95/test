package com.chaoshuibiao.dao;

import com.chaoshuibiao.bean.User;
import com.chaoshuibiao.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author iamdragon
 * @version 1.0
 */
public class LoginDaoImpl implements LoginDao {
    @Override
    public User findByUserObject(User u) {
        String username = u.getUsername();
        String pwd = u.getPwd();
        User user = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "select * from user where username=? and pwd=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pwd);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPwd(resultSet.getString("pwd"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("error!");
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "select * from user where username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPwd(resultSet.getString("pwd"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("error!");
        }
        return user;
    }
}
