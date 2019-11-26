package com.fff.service;

import com.fff.domain.Order;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Results;

/**
 * @PackageName：com.fff.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 0:06
 */
public interface IOrderService {


    PageInfo<Order> findOrderPageService(Integer pageNum, Integer pageSize);


    Order findOrderByIdService(Integer orderId);

}
