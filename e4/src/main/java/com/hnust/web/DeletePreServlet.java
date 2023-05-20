package com.hnust.web;

import com.hnust.pojo.Course;
import com.hnust.service.CourseService;
import com.hnust.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeletePreServlet")
public class DeletePreServlet extends HttpServlet {
    private CourseService service= new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        Course course = service.selectById(Integer.parseInt(id));
        //System.out.println(id+"1");
        //存到session
        HttpSession session = request.getSession();
        session.setAttribute("course",course);

        request.getRequestDispatcher("/delete.jsp?id="+id).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
