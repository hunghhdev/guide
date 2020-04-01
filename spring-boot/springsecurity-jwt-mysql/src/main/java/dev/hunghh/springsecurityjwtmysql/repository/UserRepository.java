package dev.hunghh.springsecurityjwtmysql.repository;

import dev.hunghh.springsecurityjwtmysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
