package id.my.hendisantika.springbootk8s.component;

import id.my.hendisantika.springbootk8s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
public class Cache implements CommandLineRunner {

    @Autowired
    private final UserService userService;

    public Cache(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.getUserById(Long.valueOf("1")));
        System.out.println(userService.getUserById(Long.valueOf("1")));
    }
}
