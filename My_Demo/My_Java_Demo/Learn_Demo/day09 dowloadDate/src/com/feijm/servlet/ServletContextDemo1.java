package com.feijm.servlet;

import com.feijm.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/dowloadServlet1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获得来自前端的字符串，里面写了想要下载的文件名称
        String filename = request.getParameter("filename");
        System.out.println(filename);
//        获得上下文对象
        ServletContext servletContext = getServletContext();
//        去当前路径(web目录)里面你找该文件的路径
        String filenamePath = servletContext.getRealPath( filename);
        System.out.println(filenamePath);
//        通过上下文对象，获得该文件是什么文件
//        String mimeType = servletContext.getMimeType(filename); 对的
        String mimeType = servletContext.getMimeType(filename);
//        在输出流中设定输出流的文件格式
        response.setContentType(mimeType);
//        获取用户的 user-agen
        String userAgent = request.getHeader("user-agent");
//        通过 DownLoadUtils 对文件名称或者路径进行转码
        filename = DownLoadUtils.getFileName(userAgent, filename);
//        告诉浏览器以附件的形式下载
        response.setHeader("content-disposition", "attachment;filename=" + filename);

//        通过输出字节流输出到本地
        FileInputStream fileInputStream = new FileInputStream(new File(filenamePath));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] byteArr = new byte[1024];
        int length = -1;
        while ((length = fileInputStream.read(byteArr)) != -1) {
            outputStream.write(byteArr, 0, length);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}











