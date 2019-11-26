package com.fff.controller;

import com.fff.domain.Account;
import com.fff.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/27 15:20
 */
@Controller
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    @Qualifier(value = "accountService")
    private IAccountService accountService;

    @RequestMapping(path = "/findAll")
    public ModelAndView findAccountAllController() {
        ModelAndView modelAndView = new ModelAndView();

        System.out.println(" findAccountAllController ");
        List<Account> accountList = accountService.addUser();
        for (Account account : accountList) {
            System.out.println(account);
        }

        modelAndView.addObject(accountList);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(path = "/insert")
    public ModelAndView insertAccountController(Account account) {
        ModelAndView modelAndView = new ModelAndView();

        Boolean aBoolean = accountService.insertAccountService(account);
        System.out.println(aBoolean);



        modelAndView.setViewName("success2");
        return modelAndView;
    }

}
