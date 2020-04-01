package dev.hunghh.springsecurityjwtmysql.repository;

import dev.hunghh.springsecurityjwtmysql.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByToken(String token);
}
