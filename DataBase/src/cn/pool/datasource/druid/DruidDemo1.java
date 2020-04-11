package cn.pool.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo1 {
    public static void main(String[] args) throws Exception {

        //获取配置文件
        Properties pro = new Properties();
        InputStream inputStream = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(inputStream);
        //获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //连接
        Connection conn = ds.getConnection();
    }
}
