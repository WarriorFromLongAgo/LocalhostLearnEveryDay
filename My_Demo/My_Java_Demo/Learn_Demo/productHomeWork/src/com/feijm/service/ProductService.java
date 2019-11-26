package com.feijm.service;

import com.feijm.dao.ProductDao;
import com.feijm.pojo.Product;
import com.feijm.until.JdbcDruidUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDao productDao = new ProductDao();
    private Connection connection = JdbcDruidUtil.getConnection();

    public int addProductService(Product product) {
        try {
            connection.setAutoCommit(false);
            int count = productDao.addProductDao(product);
            connection.commit();
            return count;

        } catch (SQLException e) {
            try {
                System.out.println("addProductService事务，提交失败");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteProductService(int productId) {
        try {
            connection.setAutoCommit(false);
            int count = productDao.deleteProductDao(productId);
            connection.commit();
            return count;

        } catch (SQLException e) {
            try {
                System.out.println("addProductService事务，提交失败");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }

    public int[] deleteAllProductService(List<Integer> productPidList) {
        try {
            connection.setAutoCommit(false);
            int[] intArr = productDao.deleteAllProductDao(productPidList);
            connection.commit();
            return intArr;

        } catch (SQLException e) {
            try {
                System.out.println("addProductService事务，提交失败");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    public Product findByIdService(int productId) {
        return productDao.findByIdDao(productId);
    }

    public List<Product> findAllService() {
        return productDao.findAllDao();
    }

    public int updateByIdService(Product product) {
        try {
            connection.setAutoCommit(false);
            int count = productDao.updateByIdDao(product);
            connection.commit();
            return count;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }
}
