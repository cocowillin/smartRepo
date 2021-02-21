package service;

import domain.Student;

/**
 * @author radio
 * @create 2021-02-21 7:11 PM
 */
public interface StudentService {
    public Student getById(String sid);
    public void save(Student stu);
}
