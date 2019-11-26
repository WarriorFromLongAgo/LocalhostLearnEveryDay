package com.fff.service.impl;

import com.fff.domain.Dept;
import com.fff.mapper.DeptMapper;
import com.fff.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/21 9:31
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public Integer insertDeptServiceImpl(Dept dept) {
        System.out.println("insertDeptService 1");
        Integer integer = deptMapper.insertDeptMapper(dept);
        System.out.println("insertDeptService 2");
        System.out.println(integer);
        return integer;
    }

    @Override
    public Dept findDeptByIdServiceImpl(Integer deptId) {
        System.out.println("findDeptByIdService 1");
        Dept dept = deptMapper.findDeptByIdMapper(deptId);
        System.out.println("findDeptByIdService 2");
        System.out.println(dept);
        return dept;
    }

    @Override
    public List<Dept> findAllDeptServiceImpl() {
        System.out.println("findAllDeptService 1");
        List<Dept> deptList = deptMapper.findAllDeptMapper();
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
        System.out.println("findAllDeptService 2");

        return deptList;
    }
}
