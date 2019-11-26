package com.fff.controller;

import com.fff.domain.Order;
import com.fff.domain.Product;
import com.fff.service.IOrderService;
import com.fff.service.IProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/10 23:39
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Qualifier(value = "orderService")
    private IOrderService orderService;

    @RequestMapping("/findAll")
    public ModelAndView findAllController(
//            @RequestParam(name = "pageNum", required = true, defaultValue = "1") String pageNum,
            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
//            @RequestParam(name = "pageSize", required = true, defaultValue = "5") String pageSize
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
    ) {

        System.out.println(" findAllController 1");

        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Order> orderPageInfo = orderService.findOrderPageService(pageNum, pageSize);

        System.out.println("=======================controller");

        modelAndView.setViewName("order-list");
        modelAndView.addObject("orderPageInfo", orderPageInfo);

        System.out.println(orderPageInfo);

        System.out.println(" findAllController 2");

        return modelAndView;
    }

    @RequestMapping("/findPage")
    public ModelAndView findPageController(
//            @RequestParam(name = "pageNum", required = true, defaultValue = "1") String pageNum,
            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
//            @RequestParam(name = "pageSize", required = true, defaultValue = "5") String pageSize
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
    ) {

        System.out.println(" findPageController 1");

        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Order> orderPageInfo = orderService.findOrderPageService(pageNum, pageSize);

        System.out.println("=======================controller");

        modelAndView.setViewName("order-page");
        modelAndView.addObject("orderPageInfo", orderPageInfo);

        System.out.println(" = orderPageInfo = ");
        System.out.println(orderPageInfo);

        System.out.println(" orderPageInfo.getList() ");
        for (Order order : orderPageInfo.getList()) {
            System.out.println(order);
        }

        System.out.println(" findPageController 2");

        return modelAndView;
    }


    @RequestMapping("/findById")
    public ModelAndView findByIdController(Integer orderId) {

        System.out.println(" findByIdController 1");
        System.out.println("Integer orderId = " + orderId);

        ModelAndView modelAndView = new ModelAndView();

        Order order = orderService.findOrderByIdService(orderId);

        System.out.println("=======================controller");
        modelAndView.setViewName("order-show");
        modelAndView.addObject("order", order);


        System.out.println(" findByIdController 2");

        return modelAndView;
    }
}
