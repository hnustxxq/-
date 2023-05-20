package com.hnust.web;

import com.hnust.pojo.Course;
import com.hnust.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private  CourseService service = new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收id
        String id = request.getParameter("id");
        //调用service查询
        Course course = service.selectById(Integer.parseInt(id));
        //存到request中
        request.setAttribute("course",course);

        //转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
