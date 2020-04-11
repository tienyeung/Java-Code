package cn.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.import jar,get driver
        Class.forName("com.mysql.jdbc.Driver");//import jar,get driver
        //2.get Connection obj
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "qwe123qwe");
        //3.define sql
        String sql = " update stu set score=88 where name = 'Jerry'";
        //4.get Statement obj
        Statement stmt = conn.createStatement();
        //5.execute sql
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        //6.release resource
        stmt.close();
        conn.close();

    }
}
