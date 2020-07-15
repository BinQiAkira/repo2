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

@WebServlet("/studentchaxun")
public class StudentChaXunServlet extends HttpServlet {
    private StudentRepository studentRepository=new StudentRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = studentRepository.findAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("student.jsp").forward(req,resp);
    }
}
