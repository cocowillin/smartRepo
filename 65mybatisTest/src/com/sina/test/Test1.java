package test;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;
import util.ServiceFactory;

/**
 * @author radio
 * @create 2021-02-21 7:17 PM
 * mybatis 初体验
 */
public class Test1 {
    public static void main(String[] args) {
//        StudentService ss = new StudentServiceImpl();
        StudentService ss= (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        /*Student stu1=new Student();
        stu1.setSid("a0004");
        stu1.setSname("杰克逊");
        stu1.setAge(33);
        ss.save(stu1);*/
        Student stu1 = ss.getById("a0001");
        System.out.println(stu1);

    }
}
