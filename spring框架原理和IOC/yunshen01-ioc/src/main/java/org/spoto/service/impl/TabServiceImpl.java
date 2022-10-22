package org.spoto.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.spoto.dao.TabDao;
import org.spoto.dao.impl.TabDaoImpl;
import org.spoto.model.Account;
import org.spoto.service.TabService;
import org.spoto.utils.JdbcUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Service("tabService")
public class TabServiceImpl implements TabService {

    @Override
    public JSONObject list(int pageIndex, int pageSize,String uname){
        //范围
        int offset = (pageIndex - 1) * pageSize;
        int limit = pageSize;

        //持久层读取数据
        TabDao td = new TabDaoImpl();
        List<Account> al = td.getList(offset,limit,uname);

        //算最大页数
        int size = td.count(uname);
        int maxPage = (size % pageIndex == 0) ? (size / pageSize) : (size / pageSize) + 1 ;

        JSONObject data = new JSONObject();
        data.put("dataList", al);
        data.put("maxPage", maxPage);
        return data;
    }


    @Override
    public boolean save(Account ac){
        Integer id = ac.getId();
        TabDao td = new TabDaoImpl();
        if (id.equals(0)){
            //新增
            return td.add(ac);
        }else {
            return td.update(ac);
        }
    }

    @Override
    public boolean del(String[] idArr){
        //持久层删除数据
        TabDao td = new TabDaoImpl();
        boolean b = true;
        for (String idStr : idArr){
            int id = Integer.parseInt(idStr);
            boolean del = td.del(id);
            if (!del){
                b = false;
            }
        }
        return b;
    }
}
