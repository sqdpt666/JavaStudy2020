package servlet;

import service.impl.Admin_Class;
import service.impl.Admin_Course;
import service.impl.Admin_Student;
import service.impl.Admin_Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends BaseServlet{

  //Class
    protected void toAddClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Admin_Class.add();
    req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);

    }
    protected void toDeleteClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin_Class.delete();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }
    protected void toFindClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Admin_Class.find();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }
//Course
    protected void toAddCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin_Course.add();
       // req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
        resp.sendRedirect("/Project05/manager/admin.jsp");
    }
    protected void toDeleteCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Admin_Course.delete();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }
    protected void toFindCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Admin_Course.find();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }
//Student
    protected void toAddStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin_Student.add();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }
    protected void toDeleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin_Student.delete();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }
    protected void toFindStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Admin_Student.find();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }
    //Teacher
    protected void toAddTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin_Teacher.add();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);

    }
    protected void toDeleteTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Admin_Teacher.delete();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }
    protected void toFindTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin_Teacher.find();
        req.getRequestDispatcher("/manager/admin.jsp").forward(req,resp);
    }



}
