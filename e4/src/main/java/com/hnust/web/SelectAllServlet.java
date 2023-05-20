package com.hnust.web;

import com.hnust.mapper.CourseMapper;
import com.hnust.pojo.Course;
import com.hnust.service.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private  CourseService service = new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用CourseService完成查询

        List<Course> courses = service.selectAll();

        //2.存入request域中
        request.setAttribute("courses",courses);

        //3.转发到course.jsp
        request.getRequestDispatcher("/course.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
