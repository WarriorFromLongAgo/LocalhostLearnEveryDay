package com.feijm.xiangmu001.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feijm.xiangmu001.dao.impl.CategoryDaoImpl;
import com.feijm.xiangmu001.domain.Category;
import com.feijm.xiangmu001.service.ICategoryService;
import com.feijm.xiangmu001.dao.ICategoryDao;
import com.feijm.xiangmu001.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public String findCategoryListJsonService() {
//        1，先从jadis中获取

//        傻逼，报错记得开radis
//        傻逼，报错记得开radis
//        傻逼，报错记得开radis
//        傻逼，报错记得开radis
//        傻逼，报错记得开radis

        Jedis jedis = JedisUtil.getJedis();
        String categoryListJson = jedis.get("categoryListJson");
//        System.out.println(categoryListJson);

        if (categoryListJson != null) {

            System.out.println("从jadis中获取");
            return categoryListJson;

        } else {
            //        2，jadis中没有的话，再去从数据中获取，
//        并且将从数据库中获取到的数据，存入到jadis中
            List<Category> categoryList = categoryDao.findCategoryListDao();
//            System.out.println("categoryList = " + categoryList);
            System.out.println("从数据库中获取");

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                categoryListJson = objectMapper.writeValueAsString(categoryList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            jedis.set("categoryListJson", categoryListJson);

            return categoryListJson;
        }

    }
}
