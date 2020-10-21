package dao;

import entry.Clazz;
import util.JdbcUtilsOnly;

public class ClazzDao extends  BaseDao{

    public Integer addClass(Clazz clazz){
        String sql="insert into clazz(`classname`,`teacherid`) values(?,?)";
        return update(sql,clazz.getClassName() ,clazz.getTeacherId());
    }

    public Integer deleteClassByTeacherId(Clazz clazz){
       String sql = "delete from clazz where teacherId=?";
        return update(sql,clazz.getTeacherId());
    }
    public Integer deleteClassByClassId(Integer classId){

       // String closeForeignKey = "SET @ORIG_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0";
        Integer close = update(JdbcUtilsOnly.closeForeignKey);

        String sql = "delete from clazz where classid=?";

        //打开mysql的外键检查功能,FOREIGN_KEY_CHECKS=1，表示检查外键
     //   closeForeignKey = "SET @ORIG_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1";
        Integer open = update(JdbcUtilsOnly.openForeignKey);

        return update(sql,classId);
    }

    /**
     * 更新课程信息
     */
    public Integer updateClass(Clazz clazz){
        String sql = "update clazz set classname=? ,teacherid =? where classid=?";
        return update(sql,clazz.getClassName(),clazz.getTeacherId(),clazz.getClassId());
    }

    public Clazz queryClassByClassId(Integer classId){
        String sql="select * from clazz where classid = ?";
        return queryForOne(Clazz.class,sql,classId);

    }
}
