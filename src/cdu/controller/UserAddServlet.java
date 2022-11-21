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
import java.util.Arrays;

@WebServlet("/add")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解析表单中的数据
        User user=new User();
        req.setCharacterEncoding("utf-8");
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setSex(req.getParameter("sex"));
        user.setHobby(Arrays.toString(req.getParameterValues("hobby")));
        //添加到数据库中
        UserServie userServie=new UserServiceImpl();
        //返回用户列表
        if(userServie.add(user)){
            resp.sendRedirect("list");
        }else {
            resp.sendRedirect("add.html");
        }

    }
}
