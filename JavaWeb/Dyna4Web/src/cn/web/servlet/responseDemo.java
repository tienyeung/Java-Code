package cn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 重定向to Demo2
 */
@WebServlet("/responseDemo")
public class responseDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1....");
        //1.设置状态码,告诉客户端需要重新访问另一个资源
//        response.setStatus(302);
//        //2.设置响应头
//        response.setHeader("location","/responseDemo2");
        response.sendRedirect("/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
