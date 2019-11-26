package com.fff.dao;

import com.fff.domain.Member;
import com.fff.domain.Order;
import com.fff.domain.Product;
import com.fff.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 0:06
 */
public interface IOrderDao {

    @Select("SELECT * FROM `order`")
    @Results({
//            value = {

            @Result(id = true, column = "orderId", property = "orderId"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(property = "product", javaType = Product.class,
                    column = "productId",   //一对多，需要传递的参数
                    one = @One(select = "com.fff.dao.IProductDao.findProductByIdDao")
            )}
//            }
    )
    List<Order> findAllOrderDao();

    @Select("SELECT * FROM `order` WHERE orderId = #{orderId}")
    @Results({
            @Result(id = true, column = "orderId", property = "orderId"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(property = "product", javaType = Product.class,
                    column = "productId",   //一对多，需要传递的参数
                    one = @One(select = "com.fff.dao.IProductDao.findProductByIdDao")
            ),
            @Result(property = "member", javaType = Member.class,
                    column = "memberId",
                    one = @One(select = "com.fff.dao.IMemberDao.findMemberByIdDao")
            ),
            @Result(property = "travellerList", javaType = java.util.List.class,
                    column = "orderId",
                    many = @Many(select = "com.fff.dao.ITravellerDao.findTravellerByIdDao")
            )
    })
    Order findOrderByIdDao(Integer orderId);

}
