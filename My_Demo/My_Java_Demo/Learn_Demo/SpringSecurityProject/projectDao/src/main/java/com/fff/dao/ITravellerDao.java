package com.fff.dao;

import com.fff.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 17:33
 */
public interface ITravellerDao {


    @Select("SELECT * FROM traveller " +
            "WHERE travellerId in (SELECT travellerId FROM order_traveller WHERE orderId = #{orderId})")
    List<Traveller> findTravellerByIdDao(Integer orderId);

}

