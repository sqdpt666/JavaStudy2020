package dao;

import entry.User;

public class UserDao extends BaseDao {
    /**
     * 通过名字查找
     * @param username
     * @return
     */
    public User queryUserByName(String username){
  String sql = "select * from user where username = ?";
  return queryForOne(User.class,sql,username);

}

    /**
     * 通过名字和密码
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password){
    String sql = "select `userid`,`username`,`userpassword`,`usertype` from user where username = ? and userpassword = ?";
    return  queryForOne(User.class,sql,username,password);

}

    /**
     * 保存用户
     * @param user
     * @return
     */
    public int saveUser(User user){
String sql="insert into user(`username`,`userpassword`,`usertype`) values(?,?,?)";
return update(sql,user.getUserName(),user.getUserPassword(),user.getUserType());

}

   public int updateUser(User user){
        String sql="update user set username = ?, userpassword = ? where userid = ?";
        return update(sql,user.getUserName(),user.getUserPassword(),user.getUserId());

   }
   public User queryUserById(Integer userId){
        String sql ="select * from user where userid =?";
    return queryForOne(User.class,sql,userId);
   }

}
