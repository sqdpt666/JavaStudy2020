package entry;

public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer teacherAge;
    private Integer userId;

    public Teacher() {
    }

    public Teacher(Integer teacherId, String teacherName, Integer teacherAge, Integer userId) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        this.userId = userId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
