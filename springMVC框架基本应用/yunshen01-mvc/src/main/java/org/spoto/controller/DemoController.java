package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//这个注解表示这个类交给springMVC去管理
@RestController
public class DemoController {

    // 请求 demo
    @RequestMapping("go1")
    @GetMapping("go1")
    @PostMapping("go1")
    public void go1(){
        System.out.println("go1");
    }


    //响应demo
    @RequestMapping("go2")
    public ModelAndView go2(){
        System.out.println("go2");
        ModelAndView mv = new ModelAndView();
        //带数据给jsp
        mv.addObject("x1","a");
        mv.addObject("x2","b");
        mv.setViewName("demo");
        return mv;
    }

    //模拟一个json demo
    @RequestMapping("go3")
    public JSONObject go3(){
        System.out.println("go3");
        JSONObject data = new JSONObject();
        data.put("aa", "bb");
        return data;

    }

    //springMVC接收参数1（不推荐用基本数据类型接收参数）
    @RequestMapping("go4")
    public String go4(String str,Integer age){
        System.out.println("go4");
        System.out.println(str);
        System.out.println(age);
        return "suc";
    }

    //
    @RequestMapping("go5")
    public String go5(Account ac){
        System.out.println("go5");
        System.out.println(ac.toString());
        return "suc";
    }

    //接收参数3
    @RequestMapping("go6")
    public String go6(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("go7");
        //重定向
        try {
            resp.sendRedirect("login.html");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "suc";
    }

    //接收参数4（把URL当做参数）
    @RequestMapping("go7/{id}")
    public String go7(@PathVariable Integer id){
        System.out.println("go7");
        System.out.println(id);

        return "suc";
    }


}
