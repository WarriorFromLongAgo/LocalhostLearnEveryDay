package com.feijm.xiangmu001.dao.impl;

import com.feijm.xiangmu001.dao.IRouteDao;
import com.feijm.xiangmu001.domain.Category;
import com.feijm.xiangmu001.domain.Route;
import com.feijm.xiangmu001.domain.RouteImg;
import com.feijm.xiangmu001.domain.Seller;
import com.feijm.xiangmu001.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteDaoImpl implements IRouteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Integer findTotalCountDao(int cid, String searchInput) {
        String sql = "SELECT COUNT(*) FROM tab_route WHERE 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        searchInput = new String(searchInput.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        List<Object> paramStrList = new ArrayList<>();

        if (cid != 0) {
            stringBuilder.append(" and cid = ? ");
            paramStrList.add(cid);
        }

        if (searchInput.length() > 0 && !"null".equals(searchInput) && searchInput != null) {
            stringBuilder.append(" and rname like ? ");
            paramStrList.add("%" + searchInput + "%");
        }

        sql = stringBuilder.toString();
        System.out.println(sql);

        Integer integer = null;
        try {
            System.out.println("------findTotalCountDao qian");
            System.out.println(paramStrList.toString());
            integer = jdbcTemplate.queryForObject(sql, Integer.class, paramStrList.toArray());

            System.out.println("-----integer" + integer);

            System.out.println("------findTotalCountDao hou");
            return integer;

        } catch (DataAccessException e) {
            System.out.println("findTotalCountDao");
            return null;
        }


    }

    @Override
    public List<Route> findRouteListDao(int cid, int start, int length, String searchInput) {
        String sql = "SELECT * FROM tab_route WHERE 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        List<Object> paramStrList = new ArrayList<>();

        searchInput = new String(searchInput.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        if (cid != 0) {
            stringBuilder.append(" and cid = ? ");
            paramStrList.add(cid);
        }
        if (searchInput.length() > 0 && !"null".equals(searchInput) && searchInput != null) {
            stringBuilder.append(" and rname like ? ");
            paramStrList.add("%" + searchInput + "%");
        }

        stringBuilder.append(" LIMIT ?, ? ");
        paramStrList.add(start);
        paramStrList.add(length);

        sql = stringBuilder.toString();
//        String sql = "SELECT * FROM tab_route WHERE cid = ? LIMIT ?, ?";
        System.out.println(sql);

        try {
            System.out.println("jdbcTemplate qian ");

            List<Route> routeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class), paramStrList.toArray());
            System.out.println("jdbcTemplate hou");

            return routeList;

        } catch (DataAccessException e) {
            System.out.println("findRouteListDao");
            return null;
        }

    }

    @Override
    public Route findRouteByRidDao(int rid) {
        String sql = "SELECT * FROM tab_route WHERE rid = ? ";
        try {
            System.out.println("route zhiqian ");
            Route route = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Route.class), rid);
            System.out.println("route === ");
            return route;
        } catch (DataAccessException e) {
            System.out.println("findRouteByRidDao");
            return null;
        }
    }

    @Override
    public List<RouteImg> findRouteImgByRidDao(int rid) {
        String sql = "SELECT * FROM tab_route_img WHERE rid = ? ";
        try {
            System.out.println("RouteImg zhiqian ");
            List<RouteImg> routeImgList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
            System.out.println("RouteImg === ");
            return routeImgList;

        } catch (DataAccessException e) {
            System.out.println("findRouteImgByRidDao");
            return null;
        }
    }

    @Override
    public Category findCategoryByCidDao(int cid) {
        String sql = "SELECT * FROM tab_category WHERE cid = ? ";
        try {
            System.out.println("category zhiqian ");
            Category category = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Category.class), cid);
            System.out.println("category === ");
            return category;

        } catch (DataAccessException e) {
            System.out.println("findCategoryByCidDao");
            return null;
        }
    }

    @Override
    public Seller findSellerBySidDao(int sid) {

        String sql = "SELECT * FROM tab_seller WHERE sid = ? ";
        try {
            System.out.println("seller zhiqian ");
            Seller seller = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Seller.class), sid);
            System.out.println("seller === ");
            return seller;

        } catch (DataAccessException e) {
            System.out.println("findSellerBySidDao");
            return null;
        }
    }

}
