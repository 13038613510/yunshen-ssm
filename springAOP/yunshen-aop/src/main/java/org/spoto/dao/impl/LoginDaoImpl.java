package org.spoto.dao.impl;

import org.spoto.dao.LoginDao;
import org.spoto.model.Account;
import org.spoto.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {

    @Override
    public Account doLogin(String name, String passwd) {
        try {
            Connection conn = JdbcUtils.getConn();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM account WHERE name = ? AND passwd = ?");
            //设置参数
            ps.setString(1, name);
            ps.setString(2, passwd);
            //执行
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                //String name1 = rs.getString("name");
                //String passwd = rs.getString("passwd");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");
                String juese = rs.getString("juese");
                Account ac = new Account(id, name, passwd, sex, age, juese);
                return ac;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
