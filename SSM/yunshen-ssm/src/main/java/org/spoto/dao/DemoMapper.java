package org.spoto.dao;

import org.spoto.model.Account;

import java.util.List;

public interface DemoMapper {

    List<Account> getAll();

    Integer add(Account ac);

}
