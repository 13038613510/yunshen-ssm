package org.spoto.servlets;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;
import org.spoto.service.TabService;
import org.spoto.service.impl.TabServiceImpl;
import org.spoto.utils.OutJson;
import org.spoto.utils.SpringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 保存（新增和修改）
 */
@WebServlet(urlPatterns = "/tab-save")
public class TabSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //参数接收
        String id = request.getParameter("edid");
        String name = request.getParameter("edname");
        String sex = request.getParameter("edsex");
        String age = request.getParameter("edage");
        String juese = request.getParameter("edjuese");


        Account us = new Account(
                Integer.parseInt(id),
                name,
                "123456",
                Integer.parseInt(sex),
                Integer.parseInt(age),
                juese
        );

        TabService ts = (TabService) SpringUtils.getBean("tabService");
        boolean save = ts.save(us);

        JSONObject data = new JSONObject();
        data.put("type", save);

        //输出
        OutJson.out(data, response);

    }
}
