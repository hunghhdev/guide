package dev.hunghh.springsecurityjwtmysql.service;

import dev.hunghh.springsecurityjwtmysql.entity.Token;

public interface TokenService {

    Token createToken(Token token);

    Token findByToken(String token);
}
