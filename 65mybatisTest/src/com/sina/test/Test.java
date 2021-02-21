package test;

import domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author radio
 * @create 2021-02-21 11:17 AM
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        String resource = "mybatis-config.xml";
        InputStream inputStream =null;
        try {
           inputStream= Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
//        List<Student> studentList = session.selectOne("test1.getById");挑选一个错误
       /* List<Student> studentList = session.selectList("test1.getById");
       *//* for (Student s:
             studentList) {
            System.out.println(s);
        }*/
       /* Student stu1 = new Student();
        stu1.setSid("a0004");
        stu1.setSname("杰克");
        stu1.setAge(15);
        session.insert("test1.save",stu1);
        session.commit();*/
        Student stu2=new Student();
        stu2.setSid("a0001");
        stu2.setSname("威廉姆斯");
        stu2.setAge(31);
        session.update("test1.update",stu2);
        session.commit();
        session.delete("test1.delete","a0004");
        session.commit();


        Thread.sleep(5000);
        List<Student> studentList = session.selectList("test1.getById");
        for (Student s:
                studentList) {
            System.out.println(s);
        }
        session.close();




    }
}
