package com.chaoshuibiao.service;

import com.chaoshuibiao.bean.Room;
import com.chaoshuibiao.bean.User;

import java.util.ArrayList;

/**
 * @author iamdragon
 * @version 1.0
 */
public interface FileService {
    ArrayList<Room> getRoomList();

    Room findByRoomname(String roomname);

    void changeDateByParameter(String roomname, double rent_price, double used_water, double used_electronic, double net_price);

    int addARoom(String roomname, double rent_price, double used_water, double used_electronic, double net_price);

    void deleteByRoomname(String roomname);
}
