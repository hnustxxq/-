package com.hnust.web;

import com.hnust.pojo.Course;
import com.hnust.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private CourseService service= new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收表单提交的数据，封装为Course对象
        String name=request.getParameter("name");
        //System.out.println(id+"2");

        //2.调用service完成删除
        service.delete(name);

        //3.转发到查询所有servlet
        request.getRequestDispatcher("/SelectAllServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
