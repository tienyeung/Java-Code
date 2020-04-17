package cn.web.checkcode.dao;

import cn.web.checkcode.JDBCUtils;
import cn.web.checkcode.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 操作数据库中user表的类
 * loginUser:只包含用户密码
 * @return 返回的user包括所有信息
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser){
        try{
            String sql="select * from user where username=? and password=?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                                loginUser.getUsername(),
                                loginUser.getPassword());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
