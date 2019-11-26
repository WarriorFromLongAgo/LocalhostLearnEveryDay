package com.feijm.controller.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int heigth = 50;

        BufferedImage bufferedImage = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
//        填充背景色
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, width, heigth);
//        画边框
        graphics.setColor(Color.GREEN);
        graphics.drawRect(0, 0, width - 1, heigth - 1);
//        设置每个字符放置的位置
        String tempStr = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        graphics.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(tempStr.length());
            char tempChar = tempStr.charAt(index);
            stringBuilder.append(tempChar);
            graphics.drawString(tempChar + "", 25 * (i - 1), heigth / 2);
        }
//        画干扰线
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(heigth);
            int y2 = random.nextInt(heigth);

            graphics.drawLine(x1, y1, x2, y2);
        }

        boolean outFlag = ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        if (outFlag) {
            System.out.println("输出验证码成功");
        } else {
            System.out.println("输出验证码失败");
        }
        System.out.println(stringBuilder.toString());
//        将验证码放入session
        HttpSession session = request.getSession();
        session.setAttribute("rearEndCheckCode",stringBuilder.toString());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
