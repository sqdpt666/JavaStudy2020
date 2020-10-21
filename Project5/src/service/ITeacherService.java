package service;

import entry.*;

import java.util.List;

public interface ITeacherService {
    //teacher
    void add(Teacher teacher);
    void delete(String teacherId);
    void update(Teacher teacher);
    Teacher queryById(Integer teacherId);
    List<Teacher> queryAll();
    Teacher queryByUserId(Integer userId);
    //user
    User queryUserByTeacherId(Integer teacherId);
    //clazz
    List<Clazz> queryAllClassByTeacherId(Integer teacherId);
    Integer addClass(Clazz clazz);
    Integer deleteClassByClassId(Integer classId);
    Integer updateClass(Clazz clazz);
    Clazz queryClassByClassId(Integer classId);

    //grade
    List<Grade> queryAllGrade(Integer teacherId);
    Integer queryAvgGradeByTeacherId(Integer id);

    //course
    List<Course> queryAllCourse(Integer teacherId);

    //student
    List<Student> queryAllMyStudent(Integer teacherId);
    List<Student> queryAllStudent();
    Integer addStudent(Student student);
    Integer deleteStudentByStudentId(Integer studentId);
    Student queryStudentByStudentId(Integer studentId);
    Integer updateStudent(Student student);

}
