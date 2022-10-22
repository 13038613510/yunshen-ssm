package org.spoto.service;

import org.spoto.model.Account;

public interface LoginService {

    Account doLogin(String name,String passed);

}
