package id.my.hendisantika.springbootk8s.service;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 13.06
 * To change this template use File | Settings | File Templates.
 */
@Service
public abstract class PaymentService {

    private final Payment payment;

    public PaymentService(Payment payment) {
        this.payment = payment;
    }
}
