package com.feijm.servlet;


import com.feijm.util.DownLoadUtils;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ：ChunlinCao
 * @date ：Created in 2019/9/9 16:17
 * @description：${description}
 * @modified By：
 * @version: since 1.0
 */
@WebServlet("/dowloadServlet2")
public class dowloadServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext servletContext = getServletContext();
        String filenamePath = servletContext.getRealPath("/img/"+filename);
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
        String useragent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(useragent, filename);
        response.setHeader("content-disposition", "attachment;filename=" + filename);


        System.out.println(filenamePath);
        FileInputStream fis = new FileInputStream(filenamePath);

        ServletOutputStream os = response.getOutputStream();
//           4.1.1 创建byte数组用于存放读取的数据
        byte[] b = new byte[1024];
//            4.1.2用于记录读取字节数量的length
        int length = -1;
//        4.2 将图片读取较进内存 并且将数据写到用户侧
        while ((length = fis.read(b)) != -1) {
            os.write(b, 0, length);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}