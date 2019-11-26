package com.fff.service.impl;

import com.fff.dao.IRoleDao;
import com.fff.domain.Role;
import com.fff.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/13 20:47
 */
@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAllRoleService(){
        System.out.println(" findAllRoleService 1 ");
        List<Role> roleList = roleDao.findAllRoleDao();

        System.out.println(" findAllRoleService 1 ");

        return roleList;
    }
}
