package id.my.hendisantika.springbootk8s.component;

import org.springframework.stereotype.Component;

import java.text.ParseException;
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
 * Time: 12.52
 * To change this template use File | Settings | File Templates.
 */
@Component
public class CreditCard implements Payment {

    @Override
    public String paymentMethod(String mode) {
        System.out.println("CreditCard Method===>" + mode);
        return "Payment Method===>  " + mode + " Credit Card Transaction Date ===>";
    }


    public LocalDate transactionDate() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return LocalDate.now();
    }
}
