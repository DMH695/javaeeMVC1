package dao.impl;

import dao.UserDao;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConn();
            //2.预编译sql语句
            String sql = "select * from t_user where username=? and password=?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setString(1,username);
            ps.setString(2,password);

            //4.执行查询语句
            rs = ps.executeQuery();
            //5.如果结果集有对象，则查询到了，即返回true。若没查到。则返回false
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            JDBCUtils.release(conn,ps,rs);
        }

        return false;
    }
}
