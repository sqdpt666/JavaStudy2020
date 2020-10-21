package service;

import entry.Clazz;
import entry.Grade;
import entry.Student;

import java.util.List;

public interface IStudentService {

    public Clazz classinfo(Integer userId);

    public List<Grade> gradeinfo(Integer studentId);

    public Student queryStudentById(Integer userId);
}
