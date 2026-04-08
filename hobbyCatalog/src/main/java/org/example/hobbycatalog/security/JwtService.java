package org.example.hobbycatalog.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.hobbycatalog.DTO.AuthRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.function.Function;

import io.jsonwebtoken.Claims;

@Service
public class JwtService {

    @Value("${app.jwt.secret}")
    private String private_key;

    @Value("${app.jwt.expirationMs}")
    private Long access_token_valid_time;

    @Value("${app.jwt.refreshExpirationMs}")
    private Long refresh_token_valid_time;

    public String generateAccessJwtToken(AuthRequestDTO authRequestDTO) {
        return "access";
    }

    public String generateRefreshToken() {
        return "refresh";
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Универсальный метод извлечения claim'а из токена
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Валидация токена (подпись + срок действия)
     */
    public boolean isTokenValid(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Извлечение всех claims из токена
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Создание ключа из секретной строки (обязательно для HS256)
     */
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(private_key);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
