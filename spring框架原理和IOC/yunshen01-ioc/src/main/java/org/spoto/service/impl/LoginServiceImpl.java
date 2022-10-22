package org.spoto.service.impl;

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
    public Account doLogin(String name, String passed) {
        LoginDao ld = new LoginDaoImpl();
        return ld.doLogin(name, passed);
    }

}
