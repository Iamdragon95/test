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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        User u = new User();
        u.setUsername(username);
        u.setPwd(pwd);
        LoginService ls=new LoginServiceImpl();
        User user=ls.findByUserObject(u);

        if (user!=null){
            FileService fs =new FileServiceImpl();
            ArrayList<Room> list=fs.getRoomList();
            req.setAttribute("user",user);
            req.setAttribute("list",list);
            req.getRequestDispatcher("mainpage.jsp").forward(req,resp);

        }else {
            req.setAttribute("error","账号/密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
}
