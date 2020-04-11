package cn.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into stu(name,age,score,sex,dept) value('Mary',18,85,'female',2)";
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
            String user = "root";
            String password = "qwe123qwe";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println("影响行数"+count);
            if(count > 0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
