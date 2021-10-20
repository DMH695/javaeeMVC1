package utils;



import java.sql.Connection;
import java.sql.DriverManager;

public final class DBConnection {
	String driver = "com.mysql.cj.jdbc.Driver";
    String url= "jdbc:mysql://localhost:3306/blog";
    String user = "root";
    String password = "123456";
    
    public Connection conn;

    public DBConnection() {

        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
