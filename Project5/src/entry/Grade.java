package entry;

public class Grade {
    private  Integer courseId;
    private Integer studentId;
    private Integer grade;

    public Grade(Integer courseId, Integer studentId, Integer grade) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
    }

    public Grade() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
