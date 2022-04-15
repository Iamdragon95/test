package com.chaoshuibiao.bean;

/**
 * @author iamdragon
 * @version 1.0
 */
public class Room {
    private String roomname;
    private double rent_price;
    private double used_water;
    private double used_electronic;
    private double net_price;

    public Room() {
    }

    public Room(String roomname, double rent_price, double used_water, double used_electronic, double net_price) {
        this.roomname = roomname;
        this.rent_price = rent_price;
        this.used_water = used_water;
        this.used_electronic = used_electronic;
        this.net_price = net_price;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public double getRent_price() {
        return rent_price;
    }

    public void setRent_price(double rent_price) {
        this.rent_price = rent_price;
    }

    public double getUsed_water() {
        return used_water;
    }

    public void setUsed_water(double used_water) {
        this.used_water = used_water;
    }

    public double getUsed_electronic() {
        return used_electronic;
    }

    public void setUsed_electronic(double used_electronic) {
        this.used_electronic = used_electronic;
    }

    public double getNet_price() {
        return net_price;
    }

    public void setNet_price(double net_price) {
        this.net_price = net_price;
    }

}
