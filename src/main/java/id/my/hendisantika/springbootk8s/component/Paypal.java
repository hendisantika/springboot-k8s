package id.my.hendisantika.springbootk8s.component;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 12.53
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Paypal implements Payment, Transaction {

    @Override
    public String paymentMethod(String mode) {
        System.out.println("Paypal Method===>" + mode);
        return "Payment Method===>  " + mode + " Paypal Transaction Date ===>";
    }

    public LocalDate transactionDate() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return LocalDate.now();
    }

}
