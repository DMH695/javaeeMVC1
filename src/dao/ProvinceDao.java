package dao;

import utils.JDBCUtils;

import java.sql.*;

public class ProvinceDao {
    public String queryProvinceName(Integer provinceId) {
        String url = "jdbc:mysql://localhost:3306/blog";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = "";
        try {
            //创建驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接对象
            conn = DriverManager.getConnection(url, username, password);
            //创建ps对象
            String sql = "select name from province where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, provinceId);
            //执行sql
            rs = ps.executeQuery();
            while (rs.next()) {
                //接收查询结果
                name = rs.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
