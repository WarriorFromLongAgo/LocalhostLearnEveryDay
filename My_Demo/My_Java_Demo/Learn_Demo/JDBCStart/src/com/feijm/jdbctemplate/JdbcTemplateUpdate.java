package com.feijm.jdbctemplate;

import com.feijm.jdbcutil.jdbcUtilDruid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplateUpdate {
    private static JdbcTemplate jdbcTemplate = null;

    @Before
    public void initJdbcTemplate() {
        jdbcTemplate = new JdbcTemplate(jdbcUtilDruid.getDataSource());
    }

    @Test
    public void updateDemo() {
        String sql = "update student set age = age + ? where NAME = ?";
        int age = 1;
        String name = "苍井空";
        int count = jdbcTemplate.update(sql, age, name);

        Assert.assertEquals(1, count);
        System.out.println("修改了 " + count);
    }

    @Test
    public void insertDemo() {
        Connection connection = jdbcUtilDruid.getConnection();
        String sql = "insert into student (id, Name, age) values (?,?,?)";

        int count = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, 9);
                preparedStatement.setString(2, "费久猛");
                preparedStatement.setInt(3, 23);
            }
        });

        System.out.println("修改了 " + count);
    }
}
