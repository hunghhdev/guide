package dev.hunghh.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping({"","/"})
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Xin chào");
    }
}
