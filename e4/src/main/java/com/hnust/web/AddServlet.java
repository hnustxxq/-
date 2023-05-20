package com.hnust.web;

import com.hnust.pojo.Course;
import com.hnust.service.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private CourseService service= new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收表单提交的数据，封装为Course对象
        String name = request.getParameter("name");
        String hours = request.getParameter("hours");
        String sid = request.getParameter("sid");

        //解决乱码
        name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
        Course course=new Course();
        course.setName(name);
        course.setHours(Integer.parseInt(hours));
        course.setSid(Integer.parseInt(sid));

        //2.调用service完成添加
        service.add(course);

        //3.转发到查询所有servlet
        request.getRequestDispatcher("/SelectAllServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
