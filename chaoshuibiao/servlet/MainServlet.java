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
import java.util.ArrayList;

/**
 * @author iamdragon
 * @version 1.0
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String roomname = req.getParameter("roomname");
        FileService fs = new FileServiceImpl();
        Room room = fs.findByRoomname(roomname);
        ArrayList<Room> resultList = new ArrayList<>();
        resultList.add(room);

        String username = req.getParameter("username");
        LoginService ls=new LoginServiceImpl();
        User user=ls.findByUsername(username);
        if (room != null) {
            req.setAttribute("user",user);
            req.setAttribute("list",resultList);
            req.getRequestDispatcher("mainpage.jsp").forward(req, resp);
        }else {
            req.setAttribute("user",user);
            ArrayList<Room> list=fs.getRoomList();
            req.setAttribute("list",list);
            req.getRequestDispatcher("mainpage.jsp").forward(req,resp);
        }

    }
}
