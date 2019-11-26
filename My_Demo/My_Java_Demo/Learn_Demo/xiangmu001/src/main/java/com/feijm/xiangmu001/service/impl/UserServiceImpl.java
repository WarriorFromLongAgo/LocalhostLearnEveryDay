package com.feijm.xiangmu001.service.impl;


import com.feijm.xiangmu001.dao.IUserDao;
import com.feijm.xiangmu001.dao.impl.UserDaoImpl;
import com.feijm.xiangmu001.domain.UserInfo;
import com.feijm.xiangmu001.service.IUserService;
import com.feijm.xiangmu001.util.MailUtils;
import com.feijm.xiangmu001.util.UuidUtil;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public boolean registerService(UserInfo userInfo) {
        UserInfo byUserNameDao = userDao.findByUserNameDao(userInfo.getUsername());

        if (byUserNameDao != null) {
//        1，根据用户名查询一次，用户存在就返回false
            return false;
        }
        userInfo.setStatus("0");
        String uuid = UuidUtil.getUuid();
        userInfo.setCode(uuid);

        boolean flag = userDao.registerDao(userInfo);
        String text = "<a href='http://localhost:80/qunar/user/active?code=" + uuid + "'>点击激活账号</a>";
        MailUtils.sendMail(userInfo.getEmail(), text, "官方的邮件");

//        2，不存在就保存用户信息
        return flag;
    }

    @Override
    public boolean activeService(String code) {

        String userNameByCode = userDao.findByCodeDao(code, "0");
        if (userNameByCode.isEmpty()) {
            return false;
        }

        return userDao.activeDao("1", userNameByCode);
    }

    @Override
    public UserInfo loginService(String userName, String passWord) {
        return userDao.loginDao(userName, passWord);
    }

}
