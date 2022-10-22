package org.spoto.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OutJson {

    /**
     * 输出JSON
     * @param data JSON数据
     * @param response HttpServletResponse
     * @throws Exception 异常
     */
    public static void out(JSONObject data, HttpServletResponse response) throws IOException{
        //写出结果
        PrintWriter writer = response.getWriter();
        writer.write(data.toJSONString());
        writer.flush();
    }

}
