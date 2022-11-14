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
import java.util.List;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServie userServie=new UserServiceImpl();

        List<User> userList=userServie.findAll();
        //返回包含用户数据的html页面
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>用户列表</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<a href='add.html'>添加用户</a>");
        //
        if (null==userList||userList.isEmpty())  {
            out.println("<h1>暂时无用户</h1>");
        }      else {
            out.println("<table>");
            out.println("<caption>用户列表</caption>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>name</th>");
            out.println("<th>password</th>");
            out.println("<th>sex</th>");
            out.println("<th>hobby</th>");
            out.println("<th>操作</th>");
            out.println("</tr>");
            for (User user : userList) {
                out.println("<tr>");
                out.println("<td>" + user.getId() + "</td>");
                out.println("<td>" + user.getUsername() + "</td>");
                out.println("<td>" + user.getPassword() + "</td>");
                out.println("<td>" + user.getSex() + "</td>");
                out.println("<td>" + user.getHobby() + "</td>");
                out.println("<td><a href='mod?id=" + user.getId() + "'>修改</a> " +
                        "<a href='del?id=" + user.getId() + "'>删除</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
        out.println("</body>");
        out.println("</html>");
















    }
}
