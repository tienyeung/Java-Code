package cn.pool.datasource.druid;

import cn.pool.Utils.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        PreparedStatement pstmt = null;
        Connection conn = null ;
        try{
            //1.获取连接
            conn = JdbcUtils.getConnection();
            //2.定义sql
            String sql = " insert into user values(null,?,?) ";
            //3.获取pstmt
            pstmt = conn.prepareStatement(sql);
            //4.赋值
            pstmt.setString(1,"Lily");
            pstmt.setString(2,"789");
            //5.执行
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }

    }
}
