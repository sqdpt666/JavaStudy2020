package dao;

import entry.*;
import util.JdbcUtilsOnly;

import java.util.List;

public class TeacherDao extends BaseDao{

    public int updateTeacher(Teacher teacher) {
     /*   if (teacher.getTeacherName() != null && teacher.getTeacherAge() != 0) {
            String sql1 = "update teacher set teachername = ?, teacherage = ? where teacherid = ?";
            update(sql1, teacher.getTeacherName(), teacher.getTeacherAge(),teacher.getTeacherId());
        } else if (teacher.getTeacherName() != null) {
            String sql1 = "update student set studentname = ? where studentid = ?";
            update(sql1, teacher.getTeacherName(),teacher.getTeacherId());
        } else if (teacher.getTeacherAge() != 0) {
            String sql1 = "update student set studentage = ? where studentid = ?";
            update(sql1, teacher.getTeacherAge(),teacher.getTeacherId());
        }
*/
        String sql = "update teacher set teachername = ?, teacherage = ? where teacherid = ?";
        return update(sql, teacher.getTeacherName(), teacher.getTeacherAge(),teacher.getTeacherId());
    }

    public Teacher qureyTeacherById(Integer teacherId){
        String sql="select * from teacher where teacherid=?";
        return queryForOne(Teacher.class,sql,teacherId);
    }

    public List<Teacher> qureyTeacherAll(){
        String sql="select * from teacher ";
        return queryForList(Teacher.class,sql);
    }
    public int saveTeacher(Teacher teacher){
        String sql="insert into teacher(`teachername`,`teacherage`,`userid`) values(?,?,?)";
        return update(sql,teacher.getTeacherAge(),teacher.getTeacherAge(),teacher.getUserId());

    }

    public Teacher queryByUserId(Integer userId){
        String sql="select * from teacher where userId=?";
        return queryForOne(Teacher.class,sql,userId);

    }

    public List<Clazz> queryAllClassById(Integer id){
        String sql="select * from clazz where teacherid = ?";
        return queryForList(Clazz.class,sql,id);
    }

    public List<Course> queryAllCourse(Integer teacherId){
        String sql ="select * from course where teacherid= ?";
        return queryForList(Course.class,sql,teacherId);
    }
    public List<Grade> queryAllGrade(Integer teacherId){
        String sql ="select g.* from course as c inner join grade as g on g.courseid = c.courseid where c.teacherid = ?";
      //  String sql ="select * from grade where courseid = ( select courseid from course where teacherid = ?)";
        return queryForList(Grade.class,sql,teacherId);
    }

    public Integer queryAvgGrade(Integer teacherId){
        String sql ="select AVG(g.grade) from course as c inner join grade as g on g.courseid = c.courseid where c.teacherid = ?";
        //  String sql ="select * from grade where courseid = ( select courseid from course where teacherid = ?)";
        Object o = queryForSingleValue(sql, teacherId);
        System.out.println((Integer) o);
        return  (Integer)o;
    }

    public List<Student> queryAllMyStudent(Integer teacherId){
        String sql="select s.* from clazz as c inner join student as s on c.classid = s.classid where teacherid = ?";
        return queryForList(Student.class,sql,teacherId);

    }

    public List<Student> queryAllStudent(){
        String sql="select * from student";
        return queryForList(Student.class,sql);

    }

    public User queryUserByTeacherId(Integer teacherId){
       // String sql="select * from user where userid = (select userid from teacher where teacherid = ?)";
        String sql="select u.* from teacher as t inner join user as u on u.userid = t.userid where teacherid = ?";
        return queryForOne(User.class,sql,teacherId);

    }

    public Integer addStudent(Student student){
        String sql="insert into student(`studentname`,`studentage`,`classid`) values(?,?,?)";
        return update(sql,student.getStudentName(),student.getStudentAge(),student.getClassId());
    }
    public Integer updateStudent(Student student){
        String sql="update student set classid=?";
        return update(sql,student.getClassId());
    }
    public Integer deleteStudentByStudentId(Integer studentId){
        update(JdbcUtilsOnly.closeForeignKey);
       String sql="delete  from student where studentid=?";
       update(JdbcUtilsOnly.openForeignKey);
       return update(sql,studentId);
    }

    public Student queryStudentBystudentId(Integer studentId){
        String sql = "select * from student where studentid=?";
        return queryForOne(Student.class,sql,studentId);
    }

}
