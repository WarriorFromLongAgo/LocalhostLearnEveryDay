package com.feijm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feijm.dao.DeptDaoImpl;
import com.feijm.dao.IDeptDao;
import com.feijm.domain.Dept;
import com.feijm.util.JedisPoolUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

public class DeptServiceImpl implements IDeptService {

    private IDeptDao iDeptDao = new DeptDaoImpl();

    @Override
    public List<Dept> findAllService() {

        return iDeptDao.findAllDeptDao();
    }

    @Override
    public String findAllJsonService() {
        /*
         * 使用缓存
         * */
//        1，从Redis中查询数据
        Jedis jedis = JedisPoolUtil.getJedis();
        String provinceJson = jedis.get("province");

//        判断数据是否为空
        if (provinceJson == null || "".equals(provinceJson) || provinceJson.length() == 0) {
//            redis中没有数据
//            就去数据库中查询
            System.out.println("Redis中没有数据");

            List<Dept> deptList = iDeptDao.findAllDeptDao();

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                provinceJson = objectMapper.writeValueAsString(deptList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            jedis.set("province", provinceJson);

            jedis.close();
        } else {

        }


        return provinceJson;
    }
}
