package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;
import org.spoto.service.LoginService;
import org.spoto.utils.SpringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {

    //调用Service
    //这里一定要用接口去接实现类
    private LoginService ls = (LoginService) SpringUtils.getBean("loginService");

    @RequestMapping("dologin")
    public String doLogin(String username, String password, HttpServletRequest request){
        System.out.println(username);
        System.out.println(password);

        JSONObject d = new JSONObject();

        Account ac = ls.doLogin(username, password);
        if (ac != null){
            //登录成功去存储的状态
            request.getSession().setAttribute("logined", true);
            d.put("type", true);

        }else {
            d.put("type", false);

        }
        return d.toString();
    }


    @RequestMapping("exitlogin")
    public void outLogin(HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("logined", false);
        try {
            response.sendRedirect("login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
