package dao.impl;

import dao.StudentDao;
import domain.Student;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionUtil;

/**
 * @author radio
 * @create 2021-02-21 7:01 PM
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public Student getById(String sid) {
        SqlSession session= SqlSessionUtil.getSession();
        Student stu1 = session.selectOne("test1.getById", sid);
        return stu1;

    }

    @Override
    public void save(Student stu) {
        SqlSession session= SqlSessionUtil.getSession();
        session.insert("test1.save",stu);


    }
}
