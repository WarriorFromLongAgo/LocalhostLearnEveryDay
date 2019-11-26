package com.fff.controller;

import com.fff.domain.Dept;
import com.fff.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/21 9:40
 */
@Controller
public class DeptController {

    @Autowired
    DeptService deptService;

    public Integer insertDeptController(@RequestBody Dept dept){
        System.out.println("insertDeptController 1");
        Integer integer = deptService.insertDeptServiceImpl(dept);
        System.out.println("insertDeptController 2");
        System.out.println(integer);

        return integer;
    }

    public Dept findDeptByIdController(Integer deptId){
        System.out.println("findDeptByIdController 1");
        Dept dept = deptService.findDeptByIdServiceImpl(deptId);
        System.out.println("findDeptByIdController 2");
        System.out.println(dept);

        return dept;

    }

    public List<Dept> findAllDeptController(){

        System.out.println("findAllDeptController 1");
        List<Dept> deptList = deptService.findAllDeptServiceImpl();
        System.out.println("findAllDeptController 2");
        for (Dept dept : deptList) {
            System.out.println(dept);
        }

        return deptList;
    }



}
