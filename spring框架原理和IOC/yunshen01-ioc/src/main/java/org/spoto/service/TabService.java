package org.spoto.service;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;

public interface TabService {

    JSONObject list(int pageIndex, int pageSize,String uname);

    boolean del(String[] idArr);

    boolean save(Account us);

}
