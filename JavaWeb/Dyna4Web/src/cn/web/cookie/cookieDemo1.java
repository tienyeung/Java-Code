package cn.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo1")
public class cookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "hello");
        cookie.setMaxAge(30);//持久化到硬盘30秒
        response.addCookie(cookie);
        //获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookie!=null){
            for(Cookie c:cookies){
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name+":"+value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
