package service.impl;

import dao.ClazzDao;
import dao.GradeDao;
import dao.TeacherDao;
import entry.*;
import service.ITeacherService;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    TeacherDao teacherDao=new TeacherDao();
    GradeDao gradeDao=new GradeDao();
    ClazzDao clazzDao = new ClazzDao();
    @Override
    public void add(Teacher teacher) {
        teacherDao.saveTeacher(teacher);
    }

    @Override
    public void delete(String teacherId) {

    }

    @Override
    public void update(Teacher teacher) {
       teacherDao.updateTeacher(teacher);
    }

    @Override
    public Teacher queryById(Integer teacherId) {
        return teacherDao.qureyTeacherById(teacherId);
    }

    @Override
    public List<Teacher> queryAll() {
        return teacherDao.qureyTeacherAll();
    }

    @Override
    public Teacher queryByUserId(Integer userId) {

        return teacherDao.queryByUserId(userId);
    }

    @Override
    public List<Clazz> queryAllClassByTeacherId(Integer teacherId) {
        return teacherDao.queryAllClassById(teacherId);
    }


    @Override
    public List<Grade> queryAllGrade(Integer teacherId) {

        return teacherDao.queryAllGrade(teacherId);



    }

    @Override
    public List<Course> queryAllCourse(Integer teacherId) {

        //通过老师id找到课程,
        List<Course> courses = teacherDao.queryAllCourse(teacherId);
       return courses;

    }

    @Override
    public List<Student> queryAllMyStudent(Integer teacherId) {
        return teacherDao.queryAllMyStudent(teacherId);
    }

    @Override
    public List<Student> queryAllStudent() {
        return teacherDao.queryAllStudent();
    }

    @Override
    public Integer addStudent(Student student) {
        return teacherDao.addStudent(student);
    }

    @Override
    public Integer deleteStudentByStudentId(Integer studentId) {
        return teacherDao.deleteStudentByStudentId(studentId);
    }

    @Override
    public Student queryStudentByStudentId(Integer studentId) {
        return teacherDao.queryStudentBystudentId(studentId);
    }

    @Override
    public Integer updateStudent(Student student) {
        return teacherDao.updateStudent(student);
    }

    @Override
    public User queryUserByTeacherId(Integer teacherId) {
        return teacherDao.queryUserByTeacherId(teacherId);
    }

    @Override
    public Integer queryAvgGradeByTeacherId(Integer id) {
        return teacherDao.queryAvgGrade(id);
    }

    @Override
    public Integer addClass(Clazz clazz) {
        return clazzDao.addClass(clazz);
    }


    @Override
    public Integer deleteClassByClassId(Integer classId) {
        return clazzDao.deleteClassByClassId(classId);
    }

    @Override
    public Integer updateClass(Clazz clazz) {
        return clazzDao.updateClass(clazz);
    }

    @Override
    public Clazz queryClassByClassId(Integer classId) {
        return clazzDao.queryClassByClassId(classId);
    }


}
