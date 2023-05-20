package com.hnust.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;



//登录验证过滤器
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req= (HttpServletRequest) request;
        //判断访问路径是否和登录相关
        String[] urls={"/login.jsp","/imgs/","/css/","/LoginServlet","/register.jsp","/RegisterServlet","/CheckCodeServlet"};
        String url=req.getRequestURI().toString();

        //循环判断
        for (String u:urls){
            if(url.contains(u)){
                //找到了
                //放行
                chain.doFilter(request,response);
                return;
            }
        }


        //1。判断session是否有user对象
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //2.判断user是否为null
        if(user != null ){
            //放行
            chain.doFilter(request, response);
        }else{
            //没登录，存储提示信息
            req.setAttribute("login_msg","未登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }


    }
}
