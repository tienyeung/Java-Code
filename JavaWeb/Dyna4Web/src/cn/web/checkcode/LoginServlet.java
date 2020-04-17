package cn.web.checkcode;

import cn.web.checkcode.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
//        Map<String, String[]> map = request.getParameterMap();
//        try {
//            BeanUtils.populate(loginUser,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        //调用UserDao方法，验证请求
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //判断验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        if(checkCode_session.equalsIgnoreCase(checkCode)){
            //若验证码符合，则判断用户名密码是否一致
            if(user!=null){
                session.setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

        }else {
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
