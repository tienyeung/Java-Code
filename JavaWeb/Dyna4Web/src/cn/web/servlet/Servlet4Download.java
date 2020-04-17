package cn.web.servlet;

import cn.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/Servlet4Download")
public class Servlet4Download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        //2 获取文件真实路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        //3 写入内存
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //设置response响应头类型content-type
        String mimeType = context.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //设置response响应头打开方式content-disposition
        //解决中文文件名编码问题
        String agent = request.getHeader("User-Agent");
        String fileName = DownLoadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition","attachment;filename="+fileName);
        //4 输入流到输出流
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fileInputStream.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        fileInputStream.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
