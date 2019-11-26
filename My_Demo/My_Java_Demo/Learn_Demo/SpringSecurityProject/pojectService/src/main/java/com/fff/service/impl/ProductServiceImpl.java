package com.fff.service.impl;

import com.fff.dao.IProductDao;
import com.fff.domain.Product;
import com.fff.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/10 19:21
 */
@Service(value = "productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAllProductService() {

        System.out.println(" findAllProductService 1");
        System.out.println("=======================Service1");
        List<Product> productList = productDao.findAllProductDao();
        System.out.println("=======================Service2");
        System.out.println(" findAllProductService 2");

        return productList;
    }

    @Override
    public Integer insertProductService(Product product) {

        System.out.println(" insertProductService 1");
        System.out.println("=======================Service1");
        Integer integer = productDao.insertProductDao(product);
        System.out.println("=======================Service2");
        System.out.println(" insertProductService 2");

        return integer;
    }

}
