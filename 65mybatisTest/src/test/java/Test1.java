
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author radio
 * @create 2021-02-20 11:04 PM
 */
public class Test1 {
    public static void main(String[] args) {
        String resource = "src/main/resources/mybatis-config.xml";
        InputStream inputStream=null;

        {
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SqlSessionFactory
                sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        Student a0001 = session.selectOne("test1.getById", "a0001");
        System.out.println(a0001);
        session.close();


    }


}
