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
 * 查询
 */
@WebServlet(urlPatterns = "/tab-list")
public class TabListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //参数校验
        String uname = request.getParameter("uname");
        System.out.println(uname);
        String pageIndexStr = request.getParameter("pageIndex");
        if (pageIndexStr == null || pageIndexStr.equals("")){
            pageIndexStr = "1";
        }
        //转换
        int pageIndex = Integer.parseInt(pageIndexStr);

        //定义每一页显示几条数据
        int pageSize = 3;

        //调用业务层，处理数据
        TabService ts = (TabService) SpringUtils.getBean("tabService");
        JSONObject data = ts.list(pageIndex, pageSize,uname);

        //输出
        OutJson.out(data, response);

    }
}
