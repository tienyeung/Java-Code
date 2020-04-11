package cn.base.jdbc;

import java.sql.*;
import java.util.Scanner;

import cn.base.util.*;

/**
 * 1. 通过键盘录入用户名和密码
 * 2. 判断用户是否登录成功
 */
public class practice2 {
    public static void main(String[] args) {
        String username = InputUtil.getString("请输入用户名：");
        String password = InputUtil.getString("请输入密码：");
        if(login(username,password)){
            System.out.println("登陆成功！");
        }else {
            System.err.println("登陆失败！数据库不存在该账号");
        }
    }
    //登陆是否成功
    public static boolean login(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt =  null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = " select * from user where username = ? and password = ? ";
            pstmt = conn.prepareStatement(sql);
            //赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(pstmt,conn,rs);
        }
        return false;
    }
}
