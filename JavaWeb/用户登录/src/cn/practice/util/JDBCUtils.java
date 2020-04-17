package cn.practice.util;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.objenesis.SpringObjenesis;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds = null;
    static {
        try {
            Properties pro = new Properties();
//            InputStream is = new FileInputStream(new File("/Users/apple/Documents/文稿/Study/Java Code/用户登录/src/druid.properties"));
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 通过连接池返回连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
