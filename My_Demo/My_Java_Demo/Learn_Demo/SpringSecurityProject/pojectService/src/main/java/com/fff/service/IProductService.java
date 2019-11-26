package com.fff.service;

import com.fff.domain.Product;

import java.util.List;

/**
 * @PackageName：com.fff.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/10 19:19
 */
public interface IProductService {

    List<Product> findAllProductService();

    Integer insertProductService(Product product);
}
