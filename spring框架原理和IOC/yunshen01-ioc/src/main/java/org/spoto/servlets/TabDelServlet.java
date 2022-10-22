package org.spoto.servlets;

import com.alibaba.fastjson.JSONObject;
import org.spoto.service.TabService;
import org.spoto.service.impl.TabServiceImpl;
import org.spoto.utils.OutJson;
import org.spoto.utils.SpringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 删除
 */
@WebServlet(urlPatterns = "/tab-del")
public class TabDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //参数接收
        String ids = request.getParameter("ids");
        //参数校验
        if (ids == null || ids.equals("")){
            return;
        }
        String[] idArr = ids.split(",");

        //调用业务层，处理数据
        TabService ts = (TabService) SpringUtils.getBean("tabService");
        boolean del = ts.del(idArr);

        JSONObject data = new JSONObject();
        data.put("type", del);

        //输出
        OutJson.out(data, response);

    }
}
