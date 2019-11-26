package com.feijm.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/textServlet")
public class SensitiveWordsFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        1，创建代理对象，增强 getParameter 方法
        System.out.println("textServlet执行le ");
        System.out.println(strArrList);
        ServletRequest proxyRequest = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                增强 getParameter 方法
                if ("getParameter".equals(method.getName())) {
//                    "增强返回值"，获取返回值
                    String value = (String) method.invoke(request, args);
                    System.out.println(value);
                    if (value != null) {
                        for (String string : strArrList) {
                            if (value.contains(string)) {
                                value = value.replaceAll(string, printStar(string.length()));
                                System.out.println(value);
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(request, args);
            }
        });
//        2，放行


        filterChain.doFilter(proxyRequest, response);
    }

    private String printStar(int strLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            stringBuilder.append("*");
        }
        return stringBuilder.toString();
    }

    //    敏感词汇
    private List<String> strArrList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        1，加载文件
        String path = "";
        try {
            path = SensitiveWordsFilter.class.getClassLoader().getResource("敏感词汇.txt").getPath();
        } catch (NullPointerException e) {
            System.out.println("  没有找到文件  ");
            e.printStackTrace();
        }
//        2，读取文件
        BufferedReader bufferedReader = null;
        Reader reader = null;
        try {
//            inputStreamReader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
            reader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);


            bufferedReader = new BufferedReader(reader);
//        3，将文件的每一行添加到list
            String tempStr = null;
            while ((tempStr = bufferedReader.readLine()) != null) {
                strArrList.add(tempStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(strArrList);

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
