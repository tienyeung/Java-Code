package cn.practice.test;

import cn.practice.dao.UserDao;
import cn.practice.domain.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("Frank");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);

    }

}
