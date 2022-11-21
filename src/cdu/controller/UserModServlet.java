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
import java.util.Arrays;

@WebServlet("/mod")
public class UserModServlet extends HttpServlet {
    UserServie userServie=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //显示修改页面
        req.setCharacterEncoding("utf-8");
        //1.获取要修改的用户id
        String sid=req.getParameter("id");
        if (sid==null||"".equals(sid)){resp.sendRedirect("list");return;}
        //2.获取要修改的用户数据
        UserServie userServie=new UserServiceImpl();
        User user=userServie.get(sid);

        //3.返回修改页面
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html lang='zh-CN'>");
        out.println("<head>");
        out.println("<title>修改用户</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>修改用户</h1>");
        out.println("<form action='/user/mod' method='post'>");
        out.println("id:<input type='text' name='id' value='"+user.getId()+"'readonly><br>");
        out.println("用户名:<input type='text' name='username' value='"+user.getUsername()+"'><br>");
        out.println("密码:<input type='password' name='password' value='"+user.getPassword()+"'><br>");
        out.println("性别:<input type='radio' name='sex' value='女'"+(user.getSex().equals("女")?"check":"")+">");
        out.println("<input type='radio' name='sex' value='男' "+(user.getSex().equals("男") ?"checked":"")+">");
        out.println("爱好:<input type='text' name='id' value='"+user.getId()+"'readonly><br>");
        out.println("<input type='checkbox' name='hobby' value='音乐' "+(user.getHobby().contains("音乐")?"checked":"")+">");
        out.println("<input type='checkbox' name='hobby' value='阅读' "+(user.getHobby().contains("阅读")?"checked":"")+">");
        out.println("<input type='checkbox' name='hobby' value='唱' "+(user.getHobby().contains("唱")?"checked":"")+">");
        out.println("<input type='checkbox' name='hobby' value='挑' "+(user.getHobby().contains("挑")?"checked":"")+">");
        out.println("<input type='submit' value='确定'>");
        out.println("<input type='reset' value='重置'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //处理修改业务逻辑
        User user=new User();


        req.setCharacterEncoding("utf-8");
        user.setId(Integer.parseInt(req.getParameter("id")));

        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setSex(req.getParameter("sex"));
        user.setHobby(Arrays.toString(req.getParameterValues("hobby")));
        //添加到数据库中
        userServie.mod(user);
        //返回用户列表
        resp.sendRedirect("list");






    }
}
