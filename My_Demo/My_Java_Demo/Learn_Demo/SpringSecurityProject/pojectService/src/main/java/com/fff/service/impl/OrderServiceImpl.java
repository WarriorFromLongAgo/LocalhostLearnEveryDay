package com.fff.service.impl;

import com.fff.dao.IOrderDao;
import com.fff.domain.Order;
import com.fff.service.IOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 0:06
 */
@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public PageInfo<Order> findOrderPageService(Integer pageNum, Integer pageSize) {
        System.out.println(" findOrderPageService 1 ");

        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderDao.findAllOrderDao();

        System.out.println(" orderList ");
        for (Order order : orderList) {
            System.out.println(order);
        }

        System.out.println(" findOrderPageService 2 ");

        return new PageInfo<>(orderList);
    }

    @Override
    public Order findOrderByIdService(Integer orderId) {
        System.out.println(" findOrderByIdService 1 ");

        Order order = orderDao.findOrderByIdDao(orderId);

        System.out.println(" orderList ");
        System.out.println(order);

        System.out.println(" findOrderByIdService 2 ");

        return order;
    }
}
