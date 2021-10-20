package utils;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlUtil {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person person = new Person("2011","��ͮ","��",22,190,80);
//		String sqlInsert = "INSERT  INTO Person (Pno,Pname,Psex,Page,Pheight,Pweight) VALUES('";		
//		sqlInsert += person.getPno()+"','";
//		sqlInsert += person.getName()+"','";
//		sqlInsert += person.getSex()+"',";
//		sqlInsert += person.getAge()+",";
//		sqlInsert += person.getHeight()+",";
//		sqlInsert += person.getWeight()+")";
//		
//		System.out.println(add(sqlInsert));
		String sqlquery = "select * from Person";
		String[] params = {"Pno","Pname","Psex","Page","Pheight","Pweight"};
		System.out.println("编号" +"\t"+ "姓名" +"\t"+ "性别"+"\t"+ "年龄"+"\t"+ "身高"+"\t"+ "体重");
		List<Map<String,String>> listmap = new ArrayList<>();
		listmap = show(sqlquery, params);
		for(int i =0 ; i<listmap.size();i++) {
			
			for(int j=0 ; j<listmap.get(i).size();j++) {
				System.out.print(listmap.get(i).get(params[j])+"\t");
			}
			System.out.println();
		}
		
		
	}
	
	
	public static int add(String sql) {
        int message = 0;
        //注册驱动，创建连接
        DBConnection db = new DBConnection();
        try {        
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
            preStmt.executeUpdate();
            //Statement statement = (Statement) db.conn.createStatement();
            //statement.executeUpdate(sql);
            
            preStmt.close();
            db.close();
            message = 1;
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
        return message;
    }
    

    public static List< Map<String,String> > show(String sql, String[] params){
        // String sql ="select * from employee";
   	
    	 List< Map<String,String> > listmap = new ArrayList<>();
   	
         DBConnection db = new DBConnection();
         ResultSet rs = null;
        
         try {
            Statement stmt = (Statement) db.conn.createStatement();
            rs = (ResultSet) stmt.executeQuery(sql);
            while(rs.next()){
            	
            	Map<String,String> map = new HashMap<>();
            	for(int i = 0; i < params.length; i++) {
            		
            		map.put(params[i], rs.getString(params[i]));
            	}
            	listmap.add(map);
            }
            rs.close();
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return listmap; 
         
     
    }
    
    public static int del(String sql) {
        int i=0;
      //  String sql="delete from employee where name=?";
        DBConnection db = new DBConnection();
        try {    
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
         
            preStmt.executeUpdate();
            
            preStmt.close();
            db.close();
            
            i = 1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }
    
    public static int update( String sql ) {
        int i =0;
       // String sql="update employee set email=?,pwd=? where name=?";
        DBConnection db = new DBConnection();
        
        try {
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
//            preStmt.setString(1, uemail);
//            preStmt.setString(2, upwd);
//            preStmt.setString(3, uname);
            preStmt.executeUpdate();
            
            preStmt.close();
            db.close();
            i = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
