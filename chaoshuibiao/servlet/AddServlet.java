package com.chaoshuibiao.servlet;

import com.chaoshuibiao.bean.User;
import com.chaoshuibiao.service.FileService;
import com.chaoshuibiao.service.FileServiceImpl;
import com.chaoshuibiao.service.LoginService;
import com.chaoshuibiao.service.LoginServiceImpl;
import com.sun.net.httpserver.HttpPrincipal;

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
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        LoginService ls = new LoginServiceImpl();
        User user = ls.findByUsername(username);
        String roomname = req.getParameter("roomname");
        String rent_pricestr = req.getParameter("rent_price");
        String used_waterstr = req.getParameter("used_water");
        String used_electronicstr = req.getParameter("used_electronic");
        String net_pricestr = req.getParameter("net_price");


        if (roomname == null && rent_pricestr == null && used_waterstr == null && used_electronicstr == null & net_pricestr == null || roomname == "" || rent_pricestr == "" || used_waterstr == "" || used_electronicstr == "" || net_pricestr == "") {
            req.setAttribute("user", user);
            req.getRequestDispatcher("addpage.jsp").forward(req, resp);
        } else {
            double rent_price = Double.parseDouble(rent_pricestr);
            double used_water = Double.parseDouble(used_waterstr);
            double used_electronic = Double.parseDouble(used_electronicstr);
            double net_price = Double.parseDouble(net_pricestr);
            FileService fs = new FileServiceImpl();
            int lineCount = fs.addARoom(roomname, rent_price, used_water, used_electronic, net_price);
            req.setAttribute("user", user);
            if (lineCount !=-1) {
                req.setAttribute("error", "增加成功");
            } else {
                req.setAttribute("error", "增加失败");
            }
            req.getRequestDispatcher("addpage.jsp").forward(req, resp);
        }
    }
}
