package com.chaoshuibiao.service;

import com.chaoshuibiao.bean.Room;
import com.chaoshuibiao.bean.User;
import com.chaoshuibiao.dao.FileDao;
import com.chaoshuibiao.dao.FileDaoImpl;
import com.chaoshuibiao.dao.LoginDao;
import com.chaoshuibiao.dao.LoginDaoImpl;

import java.util.ArrayList;

/**
 * @author iamdragon
 * @version 1.0
 */
public class FileServiceImpl implements FileService {
    @Override
    public ArrayList<Room> getRoomList() {
        FileDao fd = new FileDaoImpl();
        return fd.getRoomList();
    }

    @Override
    public Room findByRoomname(String roomname) {
        FileDao fd = new FileDaoImpl();
        return fd.findByRoomname(roomname);
    }

    @Override
    public void changeDateByParameter(String roomname, double rent_price, double used_water, double used_electronic, double net_price) {
        FileDao fd = new FileDaoImpl();
        fd.changeDateByParameter(roomname, rent_price, used_water, used_electronic, net_price);
    }

    @Override
    public int addARoom(String roomname, double rent_price, double used_water, double used_electronic, double net_price) {
        FileDao fd = new FileDaoImpl();
        return fd.addARoom(roomname, rent_price, used_water, used_electronic, net_price);
    }

    @Override
    public void deleteByRoomname(String roomname) {
        FileDao fd = new FileDaoImpl();
        fd.deleteByRoomname(roomname);
    }
}
