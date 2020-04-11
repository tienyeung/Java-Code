package cn.base.jdbc;

import java.sql.*;

public class JdbcDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = " select * from stu ";
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
            String user = "root";
            String password = "qwe123qwe";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(5);
                int age = rs.getInt(2);
                int score = rs.getInt(3);
                int dept = rs.getInt(6);
                String name = rs.getString(1);
                String sex = rs.getString(4);
                System.out.println("|id: "+id+"|name: "+name+"|age: "+age+"|sex: "+sex+"|score: "+score+"|dept: "+dept+"|");
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
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
