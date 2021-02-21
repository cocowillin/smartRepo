package test;

import domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author radio
 * @create 2021-02-21 11:17 AM
 */
public class Test {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream =null;
        try {
           inputStream= Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        Student a0001 = session.selectOne("test1.getById", "a0003");
        System.out.println(a0001);
        session.close();

    }
}
