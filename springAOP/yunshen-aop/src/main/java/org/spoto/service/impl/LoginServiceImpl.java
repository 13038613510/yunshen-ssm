package org.spoto.service.impl;

import org.spoto.aop.AopDemo;
import org.spoto.aop.Spotp;
import org.spoto.dao.LoginDao;
import org.spoto.dao.impl.LoginDaoImpl;
import org.spoto.model.Account;
import org.spoto.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

    //昵称
    @Value("${xx}")
    private String uname;


    @Override
    @Spotp(name = "dologin",opt = "查询登录")
    public Account doLogin(String name, String passwd) {

        //service里面的业务代码
        LoginDao ld = new LoginDaoImpl();
        Account account = ld.doLogin(name, passwd);


        return account;
    }

}
