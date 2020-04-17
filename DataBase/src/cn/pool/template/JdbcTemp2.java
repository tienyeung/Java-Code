package cn.pool.template;

import cn.pool.Utils.JdbcUtils;
import cn.pool.Utils.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

//查询所有记录，将其封装为User类的List集合
public class JdbcTemp2 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDatasource());
        String sql1 = " select * from user ";
        List<User> query = template.query(sql1, new BeanPropertyRowMapper<User>(User.class));
        for(User user:query){
            System.out.println(user);
        }
        String sql2 = " select count(id) from user ";
        Long count = template.queryForObject(sql2,Long.class);
        System.out.println(count);

    }

}
