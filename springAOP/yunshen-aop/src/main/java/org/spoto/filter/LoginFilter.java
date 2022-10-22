package org.spoto.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //放过登录页面和3rd资源和其他资源
        String uri = req.getRequestURI();
        if("/login.html".equals(uri)
                || uri.startsWith("/3rd")
                || "/favicon.ico".equals(uri)
                || "/login".equals(uri)
        ){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Object logined = req.getSession().getAttribute("logined");
        if (logined != null && (boolean)logined){
            //已经登录
            //放过
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //未登录
            resp.sendRedirect("login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
