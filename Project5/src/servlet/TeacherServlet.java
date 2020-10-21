package servlet;

import entry.*;
import service.ITeacherService;
import service.IUserService;
import service.impl.TeacherServiceImpl;
import service.impl.UserServiceImpl;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class TeacherServlet extends  BaseServlet{
    ITeacherService teacherService=new TeacherServiceImpl();
    IUserService userService=new UserServiceImpl();
    /**
     * 跳转到老师编辑页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Teacher teacher = teacherService.queryByUserId(user.getUserId());
        req.setAttribute("teacher",teacher);
        req.getRequestDispatcher("/teacher/teacher_info.jsp").forward(req,resp);


    }

    /**
     * 编辑信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = WebUtils.copyParamToBean(req.getParameterMap(), new Teacher());
        teacherService.update(teacher);
     //   req.setAttribute("user",userService.queryUserById(teacher.getUserId()));
        req.getRequestDispatcher("/teacher/teacher.jsp").forward(req,resp);

       // resp.sendRedirect("/Project05/teacher/teacher.jsp");

    }

    //-----老师主界面------


    /**
     * 展示所有课
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if(user!=null ) {
            Teacher teacher = teacherService.queryByUserId(user.getUserId());
            List<Clazz> clazzList = teacherService.queryAllClassByTeacherId(teacher.getTeacherId());
            req.setAttribute("clazzList",clazzList);
           // req.setAttribute("user",userService.queryUserById(userId));
            req.getRequestDispatcher("/teacher/teacher_class_manager.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/teacher/teacher.jsp").forward(req,resp);
        }



    }

    /**
     * 展示学生成绩
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showGrade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  Integer userId = Integer.valueOf(req.getParameter("uid"));
        User user = (User) req.getSession().getAttribute("user");
        Teacher teacher = teacherService.queryByUserId(user.getUserId());
        List<Grade> gradeList = teacherService.queryAllGrade(teacher.getTeacherId());
        List<Course> courseList = teacherService.queryAllCourse(teacher.getTeacherId());
        int avg=0;
        for(Grade g:gradeList){
            avg += g.getGrade();
        }
        avg /= gradeList.size();
        req.setAttribute("courseList",courseList);
        if(req.getParameter("isReverse").equals("true"))
        Collections.reverse(gradeList);
        req.setAttribute("gradeList",gradeList);
      //  req.setAttribute("user",userService.queryUserById(userId));
       // req.setAttribute("avg",teacherService.queryAvgGradeByTeacherId(teacher.getTeacherId()));
        req.setAttribute("avg",avg);
        req.getRequestDispatcher("/teacher/teacher_grade_manager.jsp").forward(req,resp);


    }

    /**
     * 展示该老师的所有学生
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Teacher teacher = teacherService.queryByUserId(user.getUserId());
        List<Student> studentList = teacherService.queryAllMyStudent(teacher.getTeacherId());
        req.setAttribute("studentList",studentList);
        req.getRequestDispatcher("/teacher/teacher_student_manager.jsp").forward(req,resp);


    }

    //-----Class功能-----
    /**
     * 去添加课程界面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void toAddClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Teacher teacher = teacherService.queryByUserId(user.getUserId());
        req.setAttribute("teacher",teacher);
        req.getRequestDispatcher("/teacher/class_add.jsp").forward(req,resp);
    }
    /**
     * 添加课程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Clazz clazz=WebUtils.copyParamToBean(req.getParameterMap(),new Clazz());
        Integer integer = teacherService.addClass(clazz);
        showMyClass(req,resp);

    }

    /**
     * 去修改课程界面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void toEditClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("classId");
        Clazz clazz=teacherService.queryClassByClassId(Integer.valueOf(classId));
        req.setAttribute("clazz",clazz);
        req.getRequestDispatcher("/teacher/class_edit.jsp").forward(req,resp);
    }
    /**
     * 编辑课程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void editClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Clazz clazz=WebUtils.copyParamToBean(req.getParameterMap(),new Clazz());
        Integer integer = teacherService.updateClass(clazz);
        showMyClass(req,resp);

    }


    /**
     * 删除课程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void toDeleteClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       User user = (User) req.getSession().getAttribute("user");
       Integer userId = user.getUserId();
        if(user!=null ){
          //  Integer userId = Integer.valueOf(uid);
            Teacher teacher = teacherService.queryByUserId(userId);
          //  req.setAttribute("user",userService.queryUserById(userId));
            req.setAttribute("teacher",teacher);
            String classId = req.getParameter("classId");
           // req.setAttribute("user",userService.queryUserById(userId));
            if(classId!=null && classId!=""){
                teacherService.deleteClassByClassId(Integer.valueOf(classId));
            }
        }
         //   req.getRequestDispatcher("/teacher/teacher_class_manager.jsp").forward(req,resp);
        showMyClass(req,resp);

    }




    //-----Student功能-----
    protected void toAddStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        List<Student> studentList = teacherService.queryAllStudent();
        req.setAttribute("studentList",studentList);

        req.getRequestDispatcher("/teacher/student_edit.jsp").forward(req,resp);

    }

    protected void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Integer classId= Integer.valueOf(req.getParameter("classId"));
       // Integer studentId = Integer.valueOf(req.getParameter("studentId"));
      //  Student student = teacherService.queryStudentByStudentId(studentId);
      //  student.setClassId(classId);
      //  teacherService.updateStudent(student);
        User user = (User) req.getSession().getAttribute("user");
        Teacher teacher = teacherService.queryByUserId(user.getUserId());
        List<Clazz> clazzList = teacherService.queryAllClassByTeacherId(teacher.getTeacherId());
        req.setAttribute("clazzList",clazzList);
        String studentId = req.getParameter("studentId");
        req.setAttribute("studentId",studentId);
        req.getRequestDispatcher("/teacher/student_add.jsp").forward(req,resp);

    }

    protected void addStudentClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer classId= Integer.valueOf(req.getParameter("classId"));
        Integer studentId = Integer.valueOf(req.getParameter("studentId"));
        Student student = teacherService.queryStudentByStudentId(studentId);
        student.setClassId(classId);
        teacherService.updateStudent(student);
        showStudent(req,resp);

    }
    protected void toDeleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Integer studentId= Integer.valueOf(req.getParameter("studentId"));
       // Student student=WebUtils.copyParamToBean(req.getParameterMap(),new Student());
        teacherService.deleteStudentByStudentId(studentId);
        showStudent(req,resp);

    }
    //-----Grade功能-----
    protected void toExcel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/teacher/teacher_grade_manager.jsp?exportToExcel=YES").forward(req,resp);
    }

}
