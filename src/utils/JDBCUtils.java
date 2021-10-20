package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    static String driverclass = null;
    static String url = null;
    static String name = null;
    static String password = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    public static Connection con = null;

    static{
        try {
            Properties pros = new Properties();
            // 利用类加载器classLoader获取src下的资源
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pros.load(is);//读取输入流,也就是读取我们在jdbc.properties下存放的各种连接数据库的属性

            //读取连接数据库的属性,通过这些属性才能连接到数据库
            driverclass = pros.getProperty("driverclass");
            url = pros.getProperty("url");
            name = pros.getProperty("name");
            password = pros.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  该方法用于获取数据库连接
     * @return
     */

    public static Connection getConn(){

        Connection conn = null;
        try {
            //1.利用反射注册driverclass
            Class.forName(driverclass);
            //2.建立连接 参数一：协议 + 访问的数据库，参数二：用户名，参数三： 密码。
            conn = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //获取PreparedStatement
    public static PreparedStatement createPstmt(String sql,Object[] params) throws ClassNotFoundException, SQLException {
        pstmt = getConn().prepareStatement(sql);
        if(params != null) {
            for(int i = 0; i < params.length; i++) {
                pstmt.setObject(i+1, params[i]);
            }
        }
        return pstmt;
    }


    //获取数据总数
    public static int getCount(String sql) {
        int count = -1;
        try {
            pstmt = createPstmt(sql, null);
            rs = pstmt.executeQuery();
            if(rs.next())
                count = rs.getInt(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(con, pstmt,rs);
        }
        return count;
    }
    //通用查询
    public static ResultSet executeQuery(String sql, Object[] params) {
        try {
            pstmt = createPstmt(sql,params);
            return pstmt.executeQuery();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *  该方法用于关闭连接资源,不关闭就会浪费资源
     * @param conn
     */
    public static void release(Connection conn, PreparedStatement ps){
        closeConn(conn);
        closePs(ps);
    }
    public static void release(Connection conn, PreparedStatement ps, ResultSet rs){
        closePs(ps);
        closeConn(conn);
        closeRs(rs);
    }


    public static void closeConn(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    public static void closePs(PreparedStatement ps){
        try {
            if(ps !=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ps=null;
        }
    }
    public static void closeRs(ResultSet rs){
        try {
            if(rs !=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs=null;
        }
    }
}
