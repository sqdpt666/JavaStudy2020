package service;

import entry.User;

public interface IUserService {

   void updateUser(User user);

    /**
     * 注册;
     * @param user
     */
   void registUser(User user);

    /**
     * 登录;
     * @param user
     * @return
     */
   User login(User user);

    /**
     * 判断是否存在此用户
     * 返回false就不存在,返回true为存在
     * @param user
     * @return
     */
   boolean existsUser(User user);

    /**
     * 判断用户名是否存在
     * 存在返回true
     * 不存在返回false
     * @param username
     * @return
     */
   boolean existsUserName(String username);

    /**
     * 查找用户
     * @param id 用户ID
     * @return
     */
   User queryUserById(Integer id);


}
