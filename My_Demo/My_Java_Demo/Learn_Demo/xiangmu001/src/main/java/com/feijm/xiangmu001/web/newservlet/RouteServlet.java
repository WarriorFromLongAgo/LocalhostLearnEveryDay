package com.feijm.xiangmu001.web.newservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feijm.xiangmu001.domain.PageBean;
import com.feijm.xiangmu001.domain.ResultInfo;
import com.feijm.xiangmu001.domain.Route;
import com.feijm.xiangmu001.domain.UserInfo;
import com.feijm.xiangmu001.service.IRouteService;
import com.feijm.xiangmu001.service.impl.RouteServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/route/*")
public class RouteServlet extends BaseServlet {
    public void getPage(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        System.out.println("currentPage = " + currentPage);
        String pageSize = request.getParameter("pageSize");
        System.out.println("pageSize = " + pageSize);
        String cid = request.getParameter("cid");
        System.out.println("cid = " + cid);
        String searchInput = request.getParameter("searchInput");
        System.out.println("searchInput = " + searchInput);

        IRouteService routeService = new RouteServiceImpl();
        PageBean<Route> routePageBean = routeService.getPageBeanService(currentPage, pageSize, cid, searchInput);
        System.out.println("getPageBeanService");
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        try {
            System.out.println("getWriter");
            objectMapper.writeValue(response.getWriter(), routePageBean);
        } catch (IOException e) {
            System.out.println("RouteServlet IOException");
            System.out.println(" ========================== ");
            System.out.println(" ========================== ");
            e.printStackTrace();
        }
    }

    public void findOneInfo(HttpServletRequest request, HttpServletResponse response) {
        String rid = request.getParameter("rid");
        System.out.println("rid = " + rid);

        IRouteService routeService = new RouteServiceImpl();
        Route route = routeService.getRouteService(rid);
        System.out.println("RouteImgList = " + route.getRouteImgList().size());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            response.setContentType("application/json;charset=utf-8");
            objectMapper.writeValue(response.getWriter(), route);
            System.out.println("findOneInfo");
            System.out.println(" ========================== ");
            System.out.println(" ========================== ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getFavorite(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("getFavorite  ");
        String rid = request.getParameter("rid");
        System.out.println(rid);
        System.out.println("getAttribute  qian ");

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        int uid = 0;

        if (userInfo != null) {
            uid = userInfo.getUid();
        }

        System.out.println("getAttribute hou ");
        System.out.println("uid = " + uid);
//        如果get不到的话，默认则是为 0 ，int的默认为 0

        IRouteService routeService = new RouteServiceImpl();
        ResultInfo resultInfo = routeService.getFavoriteResultService(rid, uid);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            objectMapper.writeValue(response.getWriter(), resultInfo);
            System.out.println(" getFavorite ");

            System.out.println(" ========================== ");
            System.out.println(" ========================== ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addFavorite(HttpServletRequest request, HttpServletResponse response) {
        String rid = request.getParameter("rid");
        System.out.println(" addFavorite rid = " + rid);

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        int uid = 0;

        ResultInfo resultInfo = new ResultInfo();
        if (userInfo != null) {
            uid = userInfo.getUid();
        } else {
            System.out.println("您尚未登录，请登录后再试");
//            设置的是按钮的 是否可以点击的状态
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("您尚未登录，请登录后再试");
//            没有登录
            return;
        }

        IRouteService routeService = new RouteServiceImpl();
        resultInfo = routeService.addFavoriteService(rid, uid);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            objectMapper.writeValue(response.getWriter(), resultInfo);
            System.out.println(resultInfo);
            System.out.println(" ========================== ");
            System.out.println(" ========================== ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFavorite(HttpServletRequest request, HttpServletResponse response) {

        String rid = request.getParameter("rid");
        System.out.println(rid);

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        int uid = 0;

        ResultInfo resultInfo = new ResultInfo();
        if (userInfo != null) {
            uid = userInfo.getUid();
        } else {
            System.out.println("您尚未登录，请登录后再试");
//            设置的是按钮的 是否可以点击的状态
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("您尚未登录，请登录后再试");
//            没有登录
            return;
        }

        IRouteService routeService = new RouteServiceImpl();
        resultInfo = routeService.removeFavoriteService(rid, uid);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            objectMapper.writeValue(response.getWriter(), resultInfo);
            System.out.println(resultInfo);
            System.out.println(" ========================== ");
            System.out.println(" ========================== ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
