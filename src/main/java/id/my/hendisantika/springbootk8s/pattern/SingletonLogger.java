package id.my.hendisantika.springbootk8s.pattern;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 12.58
 * To change this template use File | Settings | File Templates.
 */
public class SingletonLogger {
    private static volatile SingletonLogger instance = null;

    private SingletonLogger() {

    }

    public static SingletonLogger getInstance() {
        if (instance == null) {
            synchronized (SingletonLogger.class) {
                if (instance == null) {
                    instance = new SingletonLogger();
                }
            }

        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public void log2(String message) {
        System.out.println("[LOG2] " + message);
    }
}
