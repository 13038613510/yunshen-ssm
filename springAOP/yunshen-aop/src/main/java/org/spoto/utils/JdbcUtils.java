package org.spoto.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JdbcUtils {

    /**
     * 获取连接
     *
     * @return 数据库连接
     */
    public static Connection getConn(){
        try {
            //获取连接参数
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties ps = new Properties();
            ps.load(is);
            //1.注册驱动
            Class.forName(ps.getProperty("driver"));
            //2.连接数据库
            Connection conn = DriverManager.getConnection(
                    ps.getProperty("url"),
                    ps.getProperty("user"),
                    ps.getProperty("password")
            );
            return conn;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放资源
     *
     * @param conn 数据库连接
     * @param ps 查询器
     */
    public static void close(Connection conn, PreparedStatement ps){
        close(conn, ps, null);
    }


    /**
     * 释放资源
     *
     * @param conn 数据库连接
     * @param ps 查询器
     * @param rs 结果集
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
