package com.fff.service;

import com.fff.domain.Dept;

import java.util.List;

/**
 * @PackageName：com.fff.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/21 9:29
 */
public interface DeptService {


    public Integer insertDeptServiceImpl(Dept dept);

    public Dept findDeptByIdServiceImpl(Integer deptId);

    public List<Dept> findAllDeptServiceImpl();


}
