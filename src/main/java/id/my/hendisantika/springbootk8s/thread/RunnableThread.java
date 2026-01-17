package id.my.hendisantika.springbootk8s.thread;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 13.08
 * To change this template use File | Settings | File Templates.
 */
public class RunnableThread implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + "Runnable count===>" + i);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
