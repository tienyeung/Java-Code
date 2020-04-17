package cn.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Servlet4CheckCode")
public class Servlet4CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建图片对象，内存中存储
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        //2.美化图片
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);

        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);
        
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //2.3写验证码
            graphics.drawString(ch+"",width/5*i,height/2);
        }


        //2.4画干扰线
        graphics.setColor(Color.GREEN);

        //随机生成坐标点

        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        //3.图片输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
