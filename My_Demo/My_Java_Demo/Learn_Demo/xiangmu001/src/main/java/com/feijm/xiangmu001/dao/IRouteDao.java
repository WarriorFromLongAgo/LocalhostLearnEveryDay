package com.feijm.xiangmu001.dao;

import com.feijm.xiangmu001.domain.Category;
import com.feijm.xiangmu001.domain.Route;
import com.feijm.xiangmu001.domain.RouteImg;
import com.feijm.xiangmu001.domain.Seller;

import java.util.List;

public interface IRouteDao {
    Integer findTotalCountDao(int cid, String searchInput);

    List<Route> findRouteListDao(int cid, int start, int length, String searchInput);

    Route findRouteByRidDao(int rid);

    List<RouteImg> findRouteImgByRidDao(int rid);

    Category findCategoryByCidDao(int cid);

    Seller findSellerBySidDao(int sid);

}
