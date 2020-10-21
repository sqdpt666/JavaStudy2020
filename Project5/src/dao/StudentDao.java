package dao;

import entry.Clazz;
import entry.Grade;
import entry.Student;

import java.util.List;

public class StudentDao  extends BaseDao{

    /**
     * 班级信息查看
     *
     * @param userId
     * @return
     */
    public Clazz classinfo(Integer userId) {
        String sql = "SELECT\n" +
                "clazz.classid,\n" +
                "clazz.classname,\n" +
                "clazz.teacherid\n" +
                "FROM\n" +
                "clazz\n" +
                "JOIN student ON student.classid = clazz.classid\n" +
                "where student.userid = ?";
        return queryForOne(Clazz.class, sql, userId);
    }

    /**
     * 查看个人成绩
     *
     * @param studentId
     * @return
     */
    public List<Grade> gradeinfo(Integer studentId) {
        String sql = "SELECT grade.courseid,grade.studentid,grade.grade\n" +
                "FROM grade where studentid = ?";
        return queryForList(Grade.class, sql, studentId);
    }

    /**
     * 通过userid查找学生
     *
     * @param userId
     * @return
     */
    public Student queryStudentById(Integer userId) {
        String sql = "select * from student where userid =?";
        return queryForOne(Student.class, sql, userId);
    }
}
