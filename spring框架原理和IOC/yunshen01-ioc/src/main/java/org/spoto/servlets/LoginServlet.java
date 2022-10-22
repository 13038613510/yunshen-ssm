package org.spoto.servlets;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;
import org.spoto.service.LoginService;
import org.spoto.service.impl.LoginServiceImpl;
import org.spoto.utils.SpringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");

        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        JSONObject d = new JSONObject();
        //调用Service
        //这里一定要用接口去接实现类
        LoginService ls = (LoginService) SpringUtils.getBean("loginService");
        Account ac = ls.doLogin(username, password);
        if (ac != null){
            //登录成功去存储的状态
            request.getSession().setAttribute("logined", true);
            d.put("type", true);

        }else {
            d.put("type", false);

        }
        String data = d.toString();
        //将字符串的JSON数据写出
        PrintWriter writer = response.getWriter();
        writer.write(data);
        writer.flush();


    }
}
