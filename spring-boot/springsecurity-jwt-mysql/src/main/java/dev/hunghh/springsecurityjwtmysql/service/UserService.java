package dev.hunghh.springsecurityjwtmysql.service;

import dev.hunghh.springsecurityjwtmysql.entity.User;
import dev.hunghh.springsecurityjwtmysql.security.UserPrincipal;

public interface UserService {
    User createUser(User user);

    UserPrincipal findByUsername(String username);
}
