package com.feijm.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/verificationCodeServlet")
public class ServletNumPhoto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1，在内存中创建一个对象，验证码图片对象
        int width = 100;
        int heigth = 50;
        BufferedImage bufferedImage = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);

//        2，美化图片
//        2.1，填充背景色
//            画笔对象
        Graphics graphics = bufferedImage.getGraphics();
//        设置画笔颜色
        graphics.setColor(Color.green);
//        填充底部颜色
        graphics.fillRect(0, 0, width, heigth);

//        2.2 画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, heigth - 1);


        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        graphics.setFont(new Font("微软雅黑", Font.PLAIN, 50));
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            graphics.drawString(str.charAt(index) + "", width / 5 * i, heigth / 2);

        }

//        2.3 写字
//        graphics.drawString("A", 20, 25);
//        graphics.drawString("A", 40, 25);
//        graphics.drawString("A", 60, 25);
//        graphics.drawString("A", 80, 25);

//        2.4 画干扰线
//        设置干扰线的颜色，随机生成干扰线的坐标
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(heigth);
            int y2 = random.nextInt(heigth);

            graphics.drawLine(x1, y1, x2, y2);
        }

//        3，将图片输出到页面展示
        System.out.println("111111111111");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

//        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        System.out.println("2222222");

        ServletOutputStream servletOutputStream = response.getOutputStream();
        /*为什么要执行两次呢*/
        byteArrayOutputStream.writeTo(servletOutputStream);
        System.out.println("333333333333333");
        servletOutputStream.close();

    }

}
