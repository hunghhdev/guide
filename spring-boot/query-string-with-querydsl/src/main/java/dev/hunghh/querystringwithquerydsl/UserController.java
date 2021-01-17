package dev.hunghh.querystringwithquerydsl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import com.querydsl.core.types.Predicate;

@RestController
public class UserController {

    @Resource
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(@RequestParam(required = false) String username,
                              @RequestParam(required = false) String address,
                              @RequestParam(required = false) String password) {
        return repository.findAll(username, address, password);
    }

    @GetMapping("/user")
    public Page<User> filter(@QuerydslPredicate(root = User.class) Predicate predicate, Pageable pageable) {
        return repository.findAll(predicate, pageable);
    }

}
