package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Student;
import service.StudentService;

/**
 * @author radio
 * @create 2021-02-21 7:12 PM
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao=new StudentDaoImpl();

    @Override
    public Student getById(String sid) {
        Student stu1 = studentDao.getById(sid);
        return stu1;
    }

    @Override
    public void save(Student stu) {
        studentDao.save(stu);
    }
}
