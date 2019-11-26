package com.feijm.dao;

import com.feijm.pojo.Product;
import com.feijm.until.JdbcDruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：
 * @more info   ：
 * @more info   ：
 */
public class ProductDao {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtil.getDataSource());

    public int addProductDao(Product product) {
        String sql = "INSERT INTO product1 (productId, productName, productPrice, productFlag) VALUES (null, ?, ?, ?)";
        return jdbcTemplate.update(sql, product.getProductName(), product.getProductPrice(), product.getProductFlag());
    }

    public int deleteProductDao(int productId) {
        String sql = "DELETE FROM product1 WHERE productId = ?";
        return jdbcTemplate.update(sql, productId);
    }

    public int[] deleteAllProductDao(List<Integer> productPidList) {
        String sql = "DELETE FROM product1 WHERE productId = ?";
//        jdbcTemplate.batchUpdate 批量删除的方法
        int[] intArr = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                1 和 productPidList.get(i)
//                1 对应的是 sql语句中的 索引位置，也就是问号
//                productPidList.get(i) 对应的是 productPidList的从头开始遍历删除
                preparedStatement.setInt(1, productPidList.get(i));
            }

            @Override
            public int getBatchSize() {
//                productPidList.size() 决定 batchUpdate运行多少次
                return productPidList.size();
            }
        });
        return intArr;
    }

    public Product findByIdDao(int productId) {
        try {
            String sql = "SELECT * FROM product1 WHERE productId = ?";
            Map<String, Object> strObjectMap = jdbcTemplate.queryForMap(sql, productId);
            Product product = new Product();
            BeanUtils.populate(product, strObjectMap);
            return product;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> findAllDao() {
        String sql = "select * from product1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public int findByIdReturnIntDao(int productId) {
        String sql = "SELECT * FROM product1 WHERE productId = ?";
        return jdbcTemplate.update(sql, productId);
    }

    public int updateByIdDao(Product product) {
        String sql = "UPDATE product1 SET productName = ?, productPrice = ?, productFlag = ?  WHERE productId = ?";
        String productName = product.getProductName();
        Double productPrice = product.getProductPrice();
        Integer productFlag = product.getProductFlag();
        Integer productId = product.getProductId();
        return jdbcTemplate.update(sql, productName, productPrice, productFlag, productId);
    }

}
