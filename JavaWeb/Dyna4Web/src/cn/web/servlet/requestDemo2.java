package cn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo2")
public class requestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BufferedReader bf = request.getReader();
//        String line = null;
//        while((line=bf.readLine())!=null){
//            System.out.println(line);
//        }
//        String[] hobbies = request.getParameterValues("hobby");
//        System.out.println(Arrays.toString(hobbies));
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keyset = parameterMap.keySet();
        for (String name:keyset){
            System.out.println(name);
                String values[] = parameterMap.get(name);
                for (String value : values){
                    System.out.println(value);
                }
                System.out.println("-------");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
