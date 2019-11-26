package com.fff.service.impl;

import com.fff.dao.IPermissionDao;
import com.fff.dao.IRoleDao;
import com.fff.dao.IUserInfoDao;
import com.fff.domain.Role;
import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 21:09
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserInfoDao userInfoDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    private IPermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        System.out.println(" loadUserByUsername userName = " + userName);

        UserInfo userInfo = null;
        try {
            userInfo = userInfoDao.findUserInfoByUserNameDao(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("userInfo = " + userInfo);

//        enabled = 0 未开启 ， = 1 开启
//        User user = new User(userInfo.getUserName(), "{noop}" + userInfo.getPassWord(),
        User user = new User(userInfo.getUserName(), userInfo.getPassWord(),
                userInfo.getStatus() != 0, true, true,
                true, getAuthority(userInfo.getRoleList()));

//        User user = new User(userInfo.getUserName(), "{noop}" + userInfo.getPassWord(),
//                getAuthority());


        System.out.println("user.getPassword() = " + user.getPassword());

        System.out.println(user);

        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        System.out.println(" = roleList = ");
        for (Role role : roleList) {
            System.out.println(role);
            simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
//        simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

        return simpleGrantedAuthorityList;
    }

    @Override
    public List<UserInfo> findAllUserService() {
        System.out.println(" findAllUserService 1 ");

        List<UserInfo> userInfoList = userInfoDao.findAllUserDao();
        System.out.println(" findAllUserService 2 ");
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
        System.out.println(" findAllUserService 3 ");

        return userInfoList;
    }

    @Override
    public UserInfo findUserInfoByIdService(Integer userInfoId) {
        System.out.println(" findUserInfoByIdService 1 ");

        UserInfo userInfo = userInfoDao.findUserInfoByIdDao(userInfoId);
//        permissionDao.findPermissionByIdDao(userInfo.)
        System.out.println(userInfo);

        System.out.println(" findUserInfoByIdService 2 ");

        return userInfo;
    }

    /**
     * @param userInfo :
     * @Title:
     * @MethodName: addUserService
     * @Return com.fff.domain.UserInfo
     * @Description:
     * @Description:添加用户，后台帮助添加
     * @Description:
     * @author: 作者名
     * @date: 2019/11/13 16:28
     */
    @Override
    public Integer addUserService(UserInfo userInfo) {
        System.out.println(" addUserService 1 ");

        String encode = bCryptPasswordEncoder.encode(userInfo.getPassWord());
        System.out.println("encode = " + encode);

        userInfo.setPassWord(encode);

        Integer integer = userInfoDao.insertUserDao(userInfo);

        System.out.println(" addUserService 2 ");

        return integer;
    }


}
