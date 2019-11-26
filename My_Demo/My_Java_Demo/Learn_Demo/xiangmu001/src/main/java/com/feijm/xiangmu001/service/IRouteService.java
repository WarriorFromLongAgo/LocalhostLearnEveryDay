package com.feijm.xiangmu001.service;

import com.feijm.xiangmu001.domain.PageBean;
import com.feijm.xiangmu001.domain.ResultInfo;
import com.feijm.xiangmu001.domain.Route;

public interface IRouteService {
    PageBean<Route> getPageBeanService(String currentPage, String pageSize, String cid, String searchInput);

    Route getRouteService(String rid);

    ResultInfo getFavoriteResultService(String rid, int uid);

    ResultInfo addFavoriteService(String rid, int uid);

    ResultInfo removeFavoriteService(String ridStr, int uid);
}
