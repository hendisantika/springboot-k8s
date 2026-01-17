package id.my.hendisantika.springbootk8s;

import id.my.hendisantika.springbootk8s.config.TestSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Import(TestSecurityConfig.class)
class SpringbootK8sApplicationTests {

    @Test
    void contextLoads() {
    }

}
