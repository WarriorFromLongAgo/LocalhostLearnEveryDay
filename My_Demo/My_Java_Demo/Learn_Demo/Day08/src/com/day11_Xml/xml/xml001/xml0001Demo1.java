package com.day11_Xml.xml.xml001;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class xml0001Demo1 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
//        获取xml文件路径
        String path = xml0001Demo1.class.getClassLoader().getResource("xml0001.xml").getPath();
        System.out.println(path);
        System.out.println("========================================");
        //        parse解析文件路径
        Document document = Jsoup.parse(new File(path), "utf-8");

//        根据 对象里面的属性 获得数组文件
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements);
        System.out.println("========================================");

        Element element1 = document.getElementById("n0001");
        System.out.println(element1);
        System.out.println("========================================");

        Element element3 = document.getElementById("u0001");
        System.out.println(element3);
        System.out.println("========================================");

//        get可以获得单个文件
        Element element2 = elements.get(0);
        System.out.println(element2);
        System.out.println("========================================");

        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("========================================");

        Elements elements2 = document.getElementsByAttribute("userid");
        System.out.println(elements2);
        System.out.println("========================================");

        Elements elements3 = document.getElementsByAttributeValue("userid", "u0002");
        System.out.println(elements3);
        System.out.println("========================================");

        System.out.println(elements3.text());
        System.out.println("========================================");

        System.out.println(elements3.html());
        System.out.println("========================================");

        Elements elements4 = document.select("student[userid='u0001']");
        System.out.println(elements4);
        System.out.println("========================================");

        Elements elements5 = document.select("name[id='n0002']");
        System.out.println(elements5);
        System.out.println("========================================");

        Elements elements6 = document.select("name[id='n0001'] > xing");
        System.out.println(elements6);
        System.out.println("========================================");

        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student/name[@id='n0001']");
        System.out.println(jxNodes);
    }
}
