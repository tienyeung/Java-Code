package cn.pool.template;

import cn.pool.Utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemp1 {
    public static void main(String[] args) {
        //1.导入spring包
        //2.获取Template对象
        DataSource dataSource = JdbcUtils.getDatasource();
        JdbcTemplate template = new JdbcTemplate(dataSource);
        //3.调用方法
        String sql = " update user set username='Frank' where username = ? " ;
        int count = template.update(sql, "Jack");
        System.out.println(count);
    }
}
