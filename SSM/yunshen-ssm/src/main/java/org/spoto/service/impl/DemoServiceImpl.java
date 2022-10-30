package org.spoto.service.impl;

import org.spoto.dao.DemoMapper;
import org.spoto.model.Account;
import org.spoto.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoMapper dm;

    @Override
    @Transactional(rollbackFor = Exception.class)//事务标签，rollbackFor当这个方法出现异常时，会自动回滚
    public boolean demo(String data){
        List<Account> all = dm.getAll();
        for (Account ac : all){
            System.out.println(ac.toString());
        }
        System.out.println("service:" + data);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sw(boolean type){
        Account ac = new Account(null,"xxx","1234",1,11,"学生");
        dm.add(ac);
        if (type){
            int i = 1/0;
        }

    }

}
