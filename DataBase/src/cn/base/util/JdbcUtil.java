package cn.base.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;


public class JdbcUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    //以配置文件的方式读取数据库连接信息
    static {
        //只需要读取一次即可拿到这些值;
        try {
            Properties pro = new Properties();
            //----->ClassLoader<------
            //1.get AbsPath
            ClassLoader classLoader = JdbcUtil.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //2.load resource
            pro.load(new FileReader(path));
            //pro.load(new FileReader("/Users/apple/Documents/文稿 /Study/Java Code/DataBase/src/jdbc.properties"));
            //3.set
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    /**
     * get Connection
     * @return Connection obj
     */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * release resource
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(Statement stmt, Connection conn, ResultSet rs){//reload
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                }
            }
        }
    }



