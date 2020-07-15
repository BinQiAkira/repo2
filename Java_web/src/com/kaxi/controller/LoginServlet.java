package com.kaxi.controller;

import com.kaxi.entity.Admin;
import com.kaxi.entity.Reader;
import com.kaxi.service.LoginService;
import com.kaxi.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();

    /**
     * 处理登录的业务逻辑
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        Object object = loginService.login(username,password,type);
        if(object != null){
            HttpSession session = req.getSession();
            switch (type){
                case "reader":
                    Reader reader = (Reader) object;
                     //跳转到学生的查询界面
                    Integer id=reader.getId();
                    String name=reader.getName();
                    Integer age=reader.getAge();
                    Integer room_id=reader.getRoom_id();
                    req.setAttribute("reader",reader);
                    resp.sendRedirect("student.jsp");
                    break;
                case "admin":
                    Admin admin = (Admin) object;
                    session.setAttribute("admin",admin);
                    //跳转到管理员的首页
                    resp.sendRedirect("/student");
                    break;
            }
        }else{
            resp.sendRedirect("login.jsp");
        }
    }
}
