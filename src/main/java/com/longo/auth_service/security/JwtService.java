package com.longo.auth_service.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String username) {
        JwtBuilder builder = Jwts.builder()
                .subject(username)
                .expiration(new Date(expiration));

        return builder.compact();
    }

    public String extractUsername(String token) {

    }

    public boolean isTokenValid(String token, String username) {
        // verifica che il token sia valido e non scaduto
    }

    private boolean isTokenExpired(String token) {
        // verifica la scadenza
    }
}
