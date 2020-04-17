package cn.practice.web.servlet;

import cn.practice.dao.UserDao;
import cn.practice.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取请求参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        //3.实例化对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        //对2，3进行简化封装，使用BeanUtils
        Map<String, String[]> map = request.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用UserDao方法，验证请求
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //5.进行转发
        if(user==null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            //存储数据
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
