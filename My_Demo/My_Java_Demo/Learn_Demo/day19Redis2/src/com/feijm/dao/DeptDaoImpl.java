package com.feijm.dao;

import com.feijm.domain.Dept;
import com.feijm.util.JdbcDruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class DeptDaoImpl implements IDeptDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtil.getDataSource());

    @Override
    public List<Dept> findAllDeptDao() {
        String sql = "select * from dept";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class));
    }
}
