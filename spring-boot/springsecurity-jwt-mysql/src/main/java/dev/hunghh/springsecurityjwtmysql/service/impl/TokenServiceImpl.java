package dev.hunghh.springsecurityjwtmysql.service.impl;

import dev.hunghh.springsecurityjwtmysql.entity.Token;
import dev.hunghh.springsecurityjwtmysql.repository.TokenRepository;
import dev.hunghh.springsecurityjwtmysql.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
