package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author radio
 * @create 2021-02-21 4:49 PM
 */
public class SqlSessionUtil {
    //取得sqlsession对象；
    private SqlSessionUtil(){}//对象私有化
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    private static ThreadLocal<SqlSession> thread=new ThreadLocal<>();
    public static SqlSession getSession(){
            SqlSession session= thread.get();
            if (session==null){
                session=sqlSessionFactory.openSession();
                thread.set(session);

            }
            return session;


    }

    //关闭sqlsession对象
    public  static  void myClose(SqlSession session){
            if (session!=null){
                session.close();
                thread.remove();
            }

    }
}
