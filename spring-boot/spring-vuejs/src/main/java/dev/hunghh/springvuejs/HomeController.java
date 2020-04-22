package dev.hunghh.springvuejs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("{?:(?:(?!api|static|\\.).)*}/**")
    public String redirectApi() {
        return "/index.html";
    }
}
