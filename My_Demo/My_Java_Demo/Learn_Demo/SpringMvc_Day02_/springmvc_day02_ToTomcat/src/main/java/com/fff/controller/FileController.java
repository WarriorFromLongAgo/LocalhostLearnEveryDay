package com.fff.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/26 17:01
 */
@Controller
@RequestMapping(path = "/file")
public class FileController {

    @RequestMapping(path = "/testFile3")
    public String testFile3(MultipartFile toTomcat) {
//        toTomcat  和 页面的属性保持一致

        String realPath = "http://localhost:9090/toTomcat/";

//        获得文件名称
        String filename = toTomcat.getOriginalFilename();

//        创建客户端对象
        Client client = Client.create();

        WebResource webResource = client.resource(realPath + filename);
        try {
            webResource.put(toTomcat.getBytes());
        } catch (IOException e) {
            System.out.println(" getBytes ");
            e.printStackTrace();
        }

        return "success";
    }


    @RequestMapping(path = "/testFile2")
    public String testFile2(HttpServletRequest request, MultipartFile toTomcat) {
//        toTomcat  和 页面的属性保持一致

        String realPath = request.getSession().getServletContext().getRealPath("/toTomcat/");
        System.out.println(realPath);

        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }

//        获得文件名称
        String filename = toTomcat.getOriginalFilename();

        try {
            toTomcat.transferTo(new File(realPath, filename));


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }


    @RequestMapping(path = "/testFile")
    public String testFile(HttpServletRequest request) {
        System.out.println(" testFile ");

        String realPath = request.getSession().getServletContext().getRealPath("/toTomcat/");
//        D:\GithubClone\LocalhostLearnEveryDay\My_Demo\My_Java_Demo\Learn_Demo\SpringMvc_Day02_\s
//        pringmvc_day02_ToTomcat\target\springmvc_day02_ToTomcat\toTomcat\
        System.out.println(realPath);

        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> fileItemList = servletFileUpload.parseRequest(request);

            for (FileItem fileItem : fileItemList) {

/** name=新建文本文档.txt
 // toreLocation=D:\IDE\apache-tomcat-8.5.31\temp\  pload_2f604500_98e0_4c6e_9120_0ac751f206a4_00000000.tmp//
 // size=116 bytes
 // isFormField=false
 // FieldName=toTomcat
 */
                System.out.println(fileItem);

                if (fileItem.isFormField()) {
//                    说明是普通表单向

                } else {
//                    说明是上传文件向
//                    获取文件上传的名称
                    String itemName = fileItem.getName();
                    //通过UUID和时间，可以生成唯一的ID值
                    System.out.println(realPath);
                    System.out.println(itemName);

//                    完成文件的上传
                    fileItem.write(new File(realPath, itemName));
//                    删除临时文件
                    fileItem.delete();
                }

            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
