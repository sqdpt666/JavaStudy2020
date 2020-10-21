package entry;

public class Clazz {

    private Integer classId;
    private String className;
    private Integer teacherId;

    public Clazz(Integer classId, String className, Integer teacherId) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
    }

    public Clazz() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
