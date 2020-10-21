package entry;

public class Student {
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private Integer classId;
    private Integer userId;

    public Student() {
    }

    public Student(Integer studentId, String studentName, Integer studentAge, Integer classId, Integer userId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.classId = classId;
        this.userId = userId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
