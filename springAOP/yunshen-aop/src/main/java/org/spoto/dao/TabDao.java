package org.spoto.dao;

import org.spoto.model.Account;

import java.util.List;

public interface TabDao {

    List<Account> getList(int offset, int limit,String uname);

    Integer count(String uname);

    boolean del(Integer id);


    boolean add(Account ac);

    boolean update(Account ac);

}
