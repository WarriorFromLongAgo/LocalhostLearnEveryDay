package com.feijm.xiangmu001.dao.impl;

import com.feijm.xiangmu001.dao.ICategoryDao;
import com.feijm.xiangmu001.domain.Category;
import com.feijm.xiangmu001.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findCategoryListDao() {
//        System.out.println("findCategoryListDao");
        String sql = "SELECT cid, cname FROM tab_category";

        List<Category> categoryList = null;
        try {
            categoryList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
            return categoryList;

        } catch (DataAccessException e) {

            System.out.println("findCategoryListDao");
            return null;
        }
    }
}
