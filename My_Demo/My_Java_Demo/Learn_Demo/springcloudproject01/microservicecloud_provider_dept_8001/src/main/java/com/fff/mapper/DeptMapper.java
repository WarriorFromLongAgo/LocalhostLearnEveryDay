package com.fff.mapper;

import com.fff.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @PackageName：com.fff.mapper
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/21 9:14
 */
@Mapper
public interface DeptMapper {

    public Integer insertDeptMapper(Dept dept);

    public Dept findDeptByIdMapper(Integer deptId);

    public List<Dept> findAllDeptMapper();

}
