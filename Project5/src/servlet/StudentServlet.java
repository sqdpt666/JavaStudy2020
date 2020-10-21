package servlet;

import entry.Clazz;
import entry.Grade;
import entry.Student;
import entry.User;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends BaseServlet {

    private StudentServiceImpl studentService = new StudentServiceImpl();

    protected void classinfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Integer id = user.getUserId();
        Clazz classinfo = studentService.classinfo(id);
        System.out.println(classinfo);
        req.setAttribute("classinfo", classinfo);
        req.getRequestDispatcher("/student/student-class.jsp").forward(req, resp);
    }


    protected void gradeinfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Integer gid = user.getUserId();
        Student student = studentService.queryStudentById(gid);
        List<Grade> gradeinfo = studentService.gradeinfo(student.getStudentId());
        System.out.println(gradeinfo.get(0));
        req.setAttribute("gradeinfo", gradeinfo);
        req.getRequestDispatcher("/student/student-grades.jsp").forward(req, resp);
    }
}
