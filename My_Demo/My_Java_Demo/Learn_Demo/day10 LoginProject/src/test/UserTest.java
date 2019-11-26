package test;

import com.feijm.dao.UserDao;
import com.feijm.model.User;
import com.feijm.service.UserService;
import org.junit.Test;

public class UserTest {

    @Test
    public void loginDaoTest() {
        User loginUser = new User("feijm", "123456");
        UserDao userDao = new UserDao();
        User user = userDao.loginDao(loginUser);

        System.out.println(user);
    }

    @Test
    public void loginServiceTest() {
        User loginUser = new User("feijm", "123456");
        UserService userService = new UserService();
        boolean b = userService.loginService(loginUser);

        System.out.println(b);
    }
}
