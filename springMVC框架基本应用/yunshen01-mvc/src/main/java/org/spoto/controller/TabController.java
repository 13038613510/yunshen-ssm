package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;
import org.spoto.service.TabService;
import org.spoto.utils.OutJson;
import org.spoto.utils.SpringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TabController {

    //调用业务层，处理数据
    private TabService ts = (TabService) SpringUtils.getBean("tabService");

    @RequestMapping("tab-list")
    public String list(String uname,String pageIndex){
        //参数校验

        if (pageIndex == null || pageIndex.equals("")){
            pageIndex = "1";
        }
        //转换
        int pageIndexInt = Integer.parseInt(pageIndex);

        //定义每一页显示几条数据
        int pageSize = 3;


        JSONObject data = ts.list(pageIndexInt, pageSize,uname);

        //输出
        return data.toString();
    }

    @RequestMapping("tab-save")
    public String save(Account ac){
        ac.setPasswd("123456");
        System.out.println(ac.toString());
        boolean save = ts.save(ac);

        JSONObject data = new JSONObject();
        data.put("type", save);

        //输出
        return data.toString();
    }

    @RequestMapping("tab-del")
    public String del(String ids){
        JSONObject data = new JSONObject();
        //参数校验
        if (ids == null || ids.equals("")){
            data.put("type", false);
            return data.toString();
        }
        String[] idArr = ids.split(",");

        //调用业务层，处理数据
        boolean del = ts.del(idArr);


        data.put("type", del);

        //输出
        return data.toString();
    }

}
