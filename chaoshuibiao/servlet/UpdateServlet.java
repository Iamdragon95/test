package com.chaoshuibiao.servlet;

import com.chaoshuibiao.bean.Room;
import com.chaoshuibiao.bean.User;
import com.chaoshuibiao.service.FileService;
import com.chaoshuibiao.service.FileServiceImpl;
import com.chaoshuibiao.service.LoginService;
import com.chaoshuibiao.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author iamdragon
 * @version 1.0
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String roomname = req.getParameter("roomname");
        String username = req.getParameter("username");
        LoginService ls = new LoginServiceImpl();
        User user = ls.findByUsername(username);
        FileService fs=new FileServiceImpl();
        Room room = fs.findByRoomname(roomname);

        String rent_pricestr = req.getParameter("rent_price");
        String used_waterstr = req.getParameter("used_water");
        String used_electronicstr = req.getParameter("used_electronic");
        String net_pricestr = req.getParameter("net_price");
        double rent_price;
        double used_water;
        double used_electronic;
        double net_price;
        if (rent_pricestr == null && used_waterstr == null && used_electronicstr == null && net_pricestr == null) {
            req.setAttribute("user", user);
            req.setAttribute("room", room);
            req.getRequestDispatcher("uppage.jsp").forward(req, resp);
        } else {
            if (rent_pricestr == "") {
                rent_price = room.getRent_price();
            } else {
                rent_price = Double.parseDouble(rent_pricestr);
            }

            if (used_waterstr == "") {
                used_water=room.getUsed_water();
            } else {
                used_water = Double.parseDouble(used_waterstr);
            }

            if (used_electronicstr == "") {
                used_electronic=room.getUsed_electronic();
            } else {
                used_electronic=Double.parseDouble(used_electronicstr);
            }

            if (net_pricestr == "") {
                net_price=room.getNet_price();
            } else {
                net_price=Double.parseDouble(net_pricestr);
            }

            fs.changeDateByParameter(roomname, rent_price, used_water, used_electronic, net_price);
            req.setAttribute("user", user);
            req.setAttribute("room", room);
            req.setAttribute("error","修改成功");
            req.getRequestDispatcher("uppage.jsp").forward(req, resp);

        }
    }
}