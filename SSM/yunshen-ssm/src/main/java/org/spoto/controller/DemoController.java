package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;
import org.spoto.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class DemoController {



    @Resource
    private DemoService ds;

    @RequestMapping("index")
    public String index(){
        boolean demo = ds.demo("controller");
        JSONObject data = new JSONObject();
        data.put("type", demo);
        return data.toString();
    }

    @RequestMapping("sw")
    public String sw(Integer num){
        ds.sw(num == null);
        return "suc";
    }

}
