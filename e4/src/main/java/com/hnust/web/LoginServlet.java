package com.hnust.web;

import com.hnust.pojo.User;
import com.hnust.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取邮箱和密码
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //2.调用service查询
        User user = service.login(email, password);

        //3.判断
        if(user!=null){
            //登录成功

            //将登录成功后的对象，存到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/SelectAllServlet");
        }
        else {
         //登录失败

            //存储错误信息
            request.setAttribute("login_msg","邮箱或密码错误");
            //跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
