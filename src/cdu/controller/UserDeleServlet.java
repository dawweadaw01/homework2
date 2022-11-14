package cdu.controller;

import cdu.model.User;
import cdu.servie.UserServie;
import cdu.servie.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/del")
public class UserDeleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        if (sid==null||"".equals(sid)){resp.sendRedirect("list");return;}
        //2.获取要修改的用户数据
        UserServie userServie=new UserServiceImpl();
        userServie.del(Integer.parseInt(sid));
        resp.sendRedirect("list");
    }
}
