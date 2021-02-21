package dao;

import domain.Student;

/**
 * @author radio
 * @create 2021-02-21 6:59 PM
 */
public interface StudentDao {
    public Student getById(String sid);
    public void save(Student stu);
}
