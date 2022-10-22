package org.spoto.dao;

import org.spoto.model.Account;

public interface LoginDao {

    Account doLogin(String name, String passed);

}
