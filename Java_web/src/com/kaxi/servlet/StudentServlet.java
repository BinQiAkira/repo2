package com.kaxi.servlet;

import com.kaxi.entity.Student;
import com.kaxi.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentRepository studentRepository = new StudentRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method == null){
            method = "findAll";
        }
        switch (method){
            case "findAll":
                //返回视图加数据
                List<Student> list = studentRepository.findAll();
                req.setAttribute("list",list);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
            case "deleteById":
                String idStr= req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                studentRepository.deleteById(id);
                resp.sendRedirect("/student");
                break;
            case "findById":
                String idStr1=req.getParameter("id");
                id=Integer.parseInt(idStr1);
                System.out.println(id);
                req.setAttribute("student",studentRepository.findById(id));
                req.getRequestDispatcher("update.jsp").forward(req,resp);
                System.out.println("已查询到要修改的位置");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String method = req.getParameter("method");
        String method = req.getParameter("method");
        switch (method){
            case "add":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String name= req.getParameter("name");
                String ageStr = req.getParameter("age");
                Integer age = Integer.parseInt(ageStr);
                System.out.println("00");
                String room_idStr =req.getParameter("room_id");
                Integer room_id = Integer.parseInt(room_idStr);
                System.out.println("11");
                studentRepository.add(username,password,name,age,room_id);
                resp.sendRedirect("/student");
                break;
            case "update":
                System.out.println("到达update");
                String idStr = req.getParameter("id");
                System.out.println(idStr);
                Integer id1 =Integer.parseInt(idStr);
                System.out.println(id1);
                name = req.getParameter("name");
                room_idStr = req.getParameter("room_id");
                System.out.println(room_idStr);
                room_id = Integer.parseInt(room_idStr);
                studentRepository.update(id1,name,room_id);
                break;
        }
        resp.sendRedirect("/student");
    }
}
