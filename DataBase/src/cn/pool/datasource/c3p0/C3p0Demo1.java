package cn.pool.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo1 {
    public static void main(String[] args) throws SQLException {
        //1 create connect pool obj
        DataSource ds = new ComboPooledDataSource();
        //2 get Connect obj
        Connection conn = ds.getConnection();
    }
}
