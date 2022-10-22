package org.spoto.dao.impl;

import org.spoto.dao.TabDao;
import org.spoto.model.Account;
import org.spoto.utils.FileUtils;
import org.spoto.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TabDaoImpl implements TabDao {


    @Override
    public List<Account> getList(int offset, int limit, String uname) {
        try {
            //获取连接
            Connection conn = JdbcUtils.getConn();
            PreparedStatement ps = null;
            if (uname == null || uname.equals("")){
                ps = conn.prepareStatement("SELECT * FROM account LIMIT ?,?");
                ps.setInt(1, offset);
                ps.setInt(2, limit);
            }else {
                ps = conn.prepareStatement("SELECT * FROM account WHERE name LIKE ? LIMIT ?,?");
                ps.setString(1, "%" + uname + "%");
                ps.setInt(2, offset);
                ps.setInt(3, limit);
            }

            ResultSet rs = ps.executeQuery();

            //处理结果
            List<Account> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String passwd = rs.getString("passwd");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");
                String juese = rs.getString("juese");
                Account ac = new Account(id, name, passwd, sex, age, juese);
                list.add(ac);
            }
            //关闭资源
            JdbcUtils.close(conn, ps, rs);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer count(String uname) {
        try {
            //获取连接
            Connection conn = JdbcUtils.getConn();
            PreparedStatement ps = null;
            if (uname == null || uname.equals("")){
                ps = conn.prepareStatement("SELECT COUNT(*) FROM account");
            }else {
                ps = conn.prepareStatement("SELECT COUNT(*) FROM account WHERE name LIKE ? ");
                ps.setString(1, "%" + uname + "%");
            }

            ResultSet rs = ps.executeQuery();

            Integer count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            //关闭资源
            JdbcUtils.close(conn, ps, rs);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean del(Integer id) {
        try {
            Connection conn = JdbcUtils.getConn();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM account WHERE id = ?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            JdbcUtils.close(conn, ps);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean add(Account ac) {
        try {
            Connection conn = JdbcUtils.getConn();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO account (name, passwd, sex, age, juese) VALUES (?,?,?,?,?)");
            ps.setString(1, ac.getName());
            ps.setString(2, ac.getPasswd());
            ps.setInt(3, ac.getSex());
            ps.setInt(4, ac.getAge());
            ps.setString(5, ac.getJuese());

            int i = ps.executeUpdate();
            JdbcUtils.close(conn, ps);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(Account ac) {
        try {
            Connection conn = JdbcUtils.getConn();
            PreparedStatement ps = conn.prepareStatement("UPDATE account SET name = ?, passwd = ?, sex = ?, age = ?, juese = ? WHERE id = ?");
            ps.setString(1, ac.getName());
            ps.setString(2, ac.getPasswd());
            ps.setInt(3, ac.getSex());
            ps.setInt(4, ac.getAge());
            ps.setString(5, ac.getJuese());
            ps.setInt(6, ac.getId());

            int i = ps.executeUpdate();
            JdbcUtils.close(conn, ps);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
