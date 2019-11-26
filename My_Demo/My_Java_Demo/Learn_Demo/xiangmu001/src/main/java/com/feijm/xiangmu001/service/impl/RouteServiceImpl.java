package com.feijm.xiangmu001.service.impl;

import com.feijm.xiangmu001.dao.IFavoriteDao;
import com.feijm.xiangmu001.dao.IRouteDao;
import com.feijm.xiangmu001.dao.impl.FavoriteDaoImpl;
import com.feijm.xiangmu001.dao.impl.RouteDaoImpl;
import com.feijm.xiangmu001.domain.*;
import com.feijm.xiangmu001.service.IRouteService;

import java.util.List;

public class RouteServiceImpl implements IRouteService {
    private IRouteDao routeDao = new RouteDaoImpl();
    private IFavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> getPageBeanService(String currentPageStr, String pageSizeStr, String cidStr, String searchInput) {
        int cid = 0;
        if (cidStr != null && cidStr.length() > 0 && !("null".equals(cidStr))) {
            cid = Integer.parseInt(cidStr);
        }

        //总记录数          totalCount;
        Integer totalCount = routeDao.findTotalCountDao(cid, searchInput);
        System.out.println("totalCount = " + totalCount);
        //当前页码          currentPage;
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        System.out.println("currentPage = " + currentPage);
        //每页显示的条数     pageSize;
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        }
        System.out.println("pageSize = " + pageSize);
        //总页数            totalPage;
        int totalPage = ((totalCount % pageSize) == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        System.out.println("totalPage = " + totalPage);
        //每页显示的数据集合 list;
        System.out.println("findRouteListDao qian");
        List<Route> routeList = routeDao.findRouteListDao(cid, (currentPage - 1) * pageSize, pageSize, searchInput);
        System.out.println("findRouteListDao hou");

        System.out.println(routeList);

        PageBean<Route> routePageBean = new PageBean<>();
        routePageBean.setTotalCount(totalCount);
        routePageBean.setTotalPage(totalPage);
        routePageBean.setCurrentPage(currentPage);
        routePageBean.setPageSize(pageSize);
        routePageBean.setList(routeList);

        return routePageBean;
    }

    @Override
    public Route getRouteService(String ridStr) {
        System.out.println(" getRouteService rid =" + ridStr);
        int rid = 0;
        if (ridStr != null && ridStr.length() > 0) {
            rid = Integer.parseInt(ridStr);
        }
        Route route = routeDao.findRouteByRidDao(rid);
        System.out.println("route = " + route);
        List<RouteImg> routeImgList = routeDao.findRouteImgByRidDao(rid);
        System.out.println("routeImgList = " + routeImgList);
        route.setRouteImgList(routeImgList);
        Category category = routeDao.findCategoryByCidDao(route.getCid());
        System.out.println("category = " + category);
        route.setCategory(category);
        Seller seller = routeDao.findSellerBySidDao(route.getSid());
        System.out.println("seller = " + seller);
        route.setSeller(seller);

        return route;
    }

    @Override
    public ResultInfo getFavoriteResultService(String ridStr, int uid) {
        ResultInfo resultInfo = new ResultInfo();

        int rid = 0;
        if (ridStr != null && ridStr.length() > 0 && !"null".equals(ridStr)) {
            rid = Integer.parseInt(ridStr);
        }
        int countByRid = favoriteDao.findCountByRidDao(rid);

        System.out.println(" rid = " + rid);
        System.out.println(" uid = " + uid);
//        获取 这个账号，是否有收藏这个 rid 的路线
        Favorite favorite = favoriteDao.findFavoriteByRidUidDao(rid, uid);
        if (favorite != null) {
//            则代表 这个账号 有收藏这个 路线
            resultInfo.setFlag(true);
//            查找 这个路线的 被收藏数量
            resultInfo.setData(countByRid);
            System.out.println("resultInfo = " + resultInfo);

            return resultInfo;

        } else {
//            没查到，就代表这个账号没有收藏，就要返回false
            resultInfo.setFlag(false);
            resultInfo.setData(countByRid);
            System.out.println("resultInfo = " + resultInfo);
            return resultInfo;
        }
    }

    @Override
    public ResultInfo addFavoriteService(String ridStr, int uid) {
        int rid = 0;
        if (ridStr != null && ridStr.length() > 0 && !"null".equals(ridStr)) {
            rid = Integer.parseInt(ridStr);
        }

        System.out.println("uid = " + uid);
        System.out.println("rid = " + rid);
        Favorite favorite = favoriteDao.findFavoriteByRidUidDao(rid, uid);
        ResultInfo resultInfo = new ResultInfo();

//        当你查找到关于rid 和 uid 和收藏了，则不能够进行收藏操作
        if (favorite != null) {
            int countByRid = favoriteDao.findCountByRidDao(rid);
            resultInfo.setData(countByRid);
            System.out.println("countByRid = " + countByRid);
//            设置已经收藏，修改 按钮的颜色为灰色，禁止点击
            resultInfo.setFlag(true);
            resultInfo.setErrorMsg("已经收藏，请不要重复收藏");

            return resultInfo;

        } else {
//        当你没有查找到关于rid 和 uid 的收藏，则进行收藏操作
            System.out.println(" addFavoriteDao addFavoriteFlag ");
            boolean addFavoriteFlag = favoriteDao.addFavoriteDao(rid, uid);
            System.out.println(" addFavoriteDao addFavoriteFlag 11111111111111 ");
            int countByRid = favoriteDao.findCountByRidDao(rid);
            resultInfo.setData(countByRid);
            System.out.println("countByRid = " + countByRid);

            if (addFavoriteFlag) {
//                设置已经收藏，修改 按钮的颜色为灰色，禁止点击
                resultInfo.setFlag(true);
//                添加成功

            } else {

                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("您未收藏过该产品，因为未知收藏失败");
            }

            return resultInfo;
        }
    }

    @Override
    public ResultInfo removeFavoriteService(String ridStr, int uid) {
        int rid = 0;
        if (ridStr != null && ridStr.length() > 0 && !"null".equals(ridStr)) {
            rid = Integer.parseInt(ridStr);
        }

        System.out.println("uid = " + uid);
        System.out.println("rid = " + rid);
        Favorite favorite = favoriteDao.findFavoriteByRidUidDao(rid, uid);
        ResultInfo resultInfo = new ResultInfo();

//        当你没有查找到关于rid 和 uid 的收藏，则进行刷新 按钮 操作，以及刷新次数的操作
        if (favorite == null) {
            int countByRid = favoriteDao.findCountByRidDao(rid);
            resultInfo.setData(countByRid);
            System.out.println("countByRid = " + countByRid);
//            设置已经收藏，修改 按钮的颜色为红色，可以点击
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("已经取消收藏，请不要重复取消收藏");

            return resultInfo;

        } else {
//        当你查到了 关于rid 和 uid 的收藏，则进行 删除收藏的操作， 删除完成后进行 刷新按钮操作，以及刷新次数的操作

            System.out.println(" removeFavoriteService removeFavoriteService ");
            boolean removeFavoriteFlag = favoriteDao.removeFavoriteDao(rid, uid);
            System.out.println(" removeFavoriteService removeFavoriteService 11111111111111 ");
            int countByRid = favoriteDao.findCountByRidDao(rid);
            resultInfo.setData(countByRid);
            System.out.println("countByRid = " + countByRid);

            if (removeFavoriteFlag) {
//                删除收藏成功，就设置可以点击，false可以点击
                resultInfo.setFlag(false);

            } else {

                resultInfo.setFlag(true);
                resultInfo.setErrorMsg("您未成功删除该产品，因为未知 删除收藏失败");
            }

            return resultInfo;
        }

    }
}
