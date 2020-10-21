package service.impl;

import dao.UserDao;
import entry.User;
import service.IUserService;

public class UserServiceImpl implements IUserService {

    UserDao userDao=new UserDao();

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUserName(),user.getUserPassword());
    }

    @Override
    public boolean existsUser(User user) {
           if(userDao.queryUserByName(user.getUserName())==null){
               return false;
           }
            return true;
    }

    @Override
    public boolean existsUserName(String username) {
        if(userDao.queryUserByName(username)==null){
            return false;
        }
        return true;
    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }
}
