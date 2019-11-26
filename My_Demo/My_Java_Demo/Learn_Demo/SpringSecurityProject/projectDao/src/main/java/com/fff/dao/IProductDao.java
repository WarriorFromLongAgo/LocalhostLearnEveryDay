package com.fff.dao;

import com.fff.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/10 18:50
 */
public interface IProductDao {


    @Select("select * from product")
    List<Product> findAllProductDao();

    @Select("select * from product where productId = #{productId}")
    Product findProductByIdDao(Integer productId);

    @Insert("INSERT INTO product(productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus) VALUES " +
            " (NULL, #{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    Integer insertProductDao(Product product);
}
