package dev.hunghh.springvuejs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller()
public class SpringVuejsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringVuejsApplication.class, args);
    }

}
