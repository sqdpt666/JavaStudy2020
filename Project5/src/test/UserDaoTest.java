package test;

import dao.UserDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByName() {
        UserDao userDao=new UserDao();
        if(userDao.queryUserByName("abc") == null){
            System.out.println("失败");
        }else {
            System.out.println("成功");
        }

    }

    @Test
    public void queryUserByUsernameAndPassword() {
    }

    @Test
    public void saveUser() {
    }
}