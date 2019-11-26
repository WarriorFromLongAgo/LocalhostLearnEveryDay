package com.fff.controller;

import com.fff.domain.Product;
import com.fff.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/10 19:48
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    @Qualifier(value = "productService")
    private IProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAllController() {

        System.out.println(" findAllController 1");

        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAllProductService();

        System.out.println("=======================controller");
        System.out.println(productList);

        modelAndView.setViewName("product-list");
        modelAndView.addObject("productList", productList);

        System.out.println(" findAllController 2");

        return modelAndView;
    }

//    @RequestMapping("/findPage")
//    public ModelAndView findPageController() {
//
//        System.out.println(" findAllController 1");
//
//        ModelAndView modelAndView = new ModelAndView();
//        List<Product> productList = productService.findAllProductService();
//
//        System.out.println("=======================controller");
//        System.out.println(productList);
//
//        modelAndView.setViewName("product-list");
//        modelAndView.addObject("productList", productList);
//
//        System.out.println(" findAllController 2");
//
//        return modelAndView;
//    }

    @RequestMapping("/addProduct")
    public String addProductController(Product product) {

        System.out.println(" addProductController 1");

        System.out.println(product);

        ModelAndView modelAndView = new ModelAndView();
        Integer integer = productService.insertProductService(product);

        System.out.println("=======================controller");
        System.out.println(integer > 0);

        modelAndView.setViewName("product-list");

        System.out.println(" addProductController 2");

//        return  "forward:/product/findAll";
        return  "redirect:/product/findAll";

    }
}
