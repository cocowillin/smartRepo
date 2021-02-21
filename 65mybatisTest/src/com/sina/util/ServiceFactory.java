package util;

/**
 * @author radio
 * @create 2021-02-21 6:55 PM
 */
public class ServiceFactory {

    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();

    }
}
