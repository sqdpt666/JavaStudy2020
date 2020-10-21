package service.impl;

import dao.StudentDao;
import entry.Clazz;
import entry.Grade;
import entry.Student;
import service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {


    StudentDao studentDao = new StudentDao();

    /**
     * 班级信息查看
     * @param userId
     * @return
     */
    @Override
    public Clazz classinfo(Integer userId) {
        return studentDao.classinfo(userId);
    }

    /**
     * 查看个人成绩
     * @param studentId
     * @return
     */
    @Override
    public List<Grade> gradeinfo(Integer studentId) {
        return studentDao.gradeinfo(studentId);
    }

    /**
     * 通过userid查找学生
     * @param userId
     * @return
     */
    @Override
    public Student queryStudentById(Integer userId) {
        return studentDao.queryStudentById(userId);
    }
}
