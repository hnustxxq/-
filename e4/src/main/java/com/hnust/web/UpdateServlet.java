package com.hnust.web;

import com.hnust.pojo.Course;
import com.hnust.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private CourseService service= new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收表单提交的数据，封装为Course对象
        String id=request.getParameter("id");
        String name = request.getParameter("name");
        String hours = request.getParameter("hours");
        String sid = request.getParameter("sid");

        //解决乱码
        name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
        Course course=new Course();
        course.setId(Integer.parseInt(id));
        course.setName(name);
        course.setHours(Integer.parseInt(hours));
        course.setSid(Integer.parseInt(sid));

        //2.调用service完成修改
        service.update(course);

        //3.转发到查询所有servlet
        request.getRequestDispatcher("/SelectAllServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
