package com.chaoshuibiao.dao;

import com.chaoshuibiao.bean.Room;
import com.chaoshuibiao.bean.User;
import com.chaoshuibiao.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author iamdragon
 * @version 1.0
 */
public class FileDaoImpl implements FileDao {

    @Override
    public ArrayList<Room> getRoomList() {
        ArrayList<Room> list = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "select * from room_situation";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomname(resultSet.getString("roomname"));
                room.setRent_price(resultSet.getDouble("rent_price"));
                room.setUsed_water(resultSet.getDouble("used_water"));
                room.setUsed_electronic(resultSet.getDouble("used_electronic"));
                room.setNet_price(resultSet.getDouble("net_price"));
                list.add(room);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("error!");
        }
        return list;
    }

    @Override
    public Room findByRoomname(String roomname) {
        Room room = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "select * from room_situation where roomname=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, roomname);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                room = new Room();
                room.setRoomname(resultSet.getString("roomname"));
                room.setRent_price(resultSet.getDouble("rent_price"));
                room.setUsed_water(resultSet.getDouble("used_water"));
                room.setUsed_electronic(resultSet.getDouble("used_electronic"));
                room.setNet_price(resultSet.getDouble("net_price"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("error!");
        }
        return room;
    }

    @Override
    public void changeDateByParameter(String roomname, double rent_price, double used_water, double used_electronic, double net_price) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "update room_situation set rent_price=?,used_water=?,used_electronic=?,net_price=? where roomname=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, rent_price);
            preparedStatement.setDouble(2, used_water);
            preparedStatement.setDouble(3, used_electronic);
            preparedStatement.setDouble(4, net_price);
            preparedStatement.setString(5, roomname);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("error!");
        }
    }

    @Override
    public int addARoom(String roomname, double rent_price, double used_water, double used_electronic, double net_price) {
        int lineCount = -1;
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO room_situation VALUES(?,?,?,?,?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, roomname);
            preparedStatement.setDouble(2, rent_price);
            preparedStatement.setDouble(3, used_water);
            preparedStatement.setDouble(4, used_electronic);
            preparedStatement.setDouble(5, net_price);
            lineCount = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("error!");
        }
        return lineCount;
    }

    @Override
    public void deleteByRoomname(String roomname) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "delete from room_situation where roomname=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, roomname);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("error!");
        }
    }
}
