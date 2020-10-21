package servlet;

import entry.User;
import service.IUserService;
import service.impl.UserServiceImpl;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends BaseServlet {
    IUserService userService=new UserServiceImpl();


    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= WebUtils.copyParamToBean(req.getParameterMap(),new User());
        User oldUser=userService.login(user);
        String oldName = req.getParameter("oldName");
        //如果 新的用户可以登录
        if(oldUser!=null){
            if(user.getUserName().equals(oldName)){//没有修改的话,跳转会学生主页面
                req.getRequestDispatcher("/student/student.jsp").forward(req,resp);
            }else {//否则用户名冲突,跳转会修改页面
                getUser(req,resp);
            }
        }else {
            //用户不存在,可以进行更新,跳转到登录页面重新登录
            userService.updateUser(user);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }

    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     /*   String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("userpwd");
        User user = userService.login(new User(null,username,password,0));*/
        User user= WebUtils.copyParamToBean(req.getParameterMap(),new User());
        user = userService.login(user);
        if(user!=null){
            //根据用户类型跳转
            int t=  user.getUserType();
            System.out.println(t);
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
           // req.setAttribute("user",user);
            switch (t){
                case 0:
                 //   resp.sendRedirect("/admin.jsp");
                    req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
                    break;
                case 1:
                  //  resp.sendRedirect("/teacher/teacher.jsp");
                   req.getRequestDispatcher("/teacher/teacher.jsp").forward(req,resp);
                    break;
                case 2:
                   // resp.sendRedirect("/student.jsp");
                    req.getRequestDispatcher("/student/student.jsp").forward(req,resp);
                    break;
                default:
                  //  resp.sendRedirect("/index.jsp");
                   req.getRequestDispatcher("/index.jsp").forward(req,resp);
                    break;
            }

        }else{
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }



    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("userpwd");
        String type = req.getParameter("type");
        System.out.println();
        //检查用户名是否可用
        if(userService.existsUserName(username)){
            //用户已存在
            //返回注册页面
            System.out.println("注册失败");
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);

        }else {
            //用户名可用,注册成功
            //存储用户

            userService.registUser(new User(null,username,password,new Integer(type)));
            //返回登录页面
            System.out.println("注册成功");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }



    }
    protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  Integer id = Integer.valueOf(req.getParameter("uid"));
       // System.out.println("获取到的user对象的ID为：" + id);
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/student/student-info.jsp").forward(req, resp);
    }

}
