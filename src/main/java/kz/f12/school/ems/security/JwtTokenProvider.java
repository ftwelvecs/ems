package kz.f12.school.ems.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kz.f12.school.ems.exception.InvalidTokenException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

@Component
@Setter
public class JwtTokenProvider {

    @Value("${jwt.token.expirationInSec}")
    private long expirationInSec;

    @Value("${jwt.token.secretKey}")
    private String secretKey;

    private final UserDetailsService userDetailsService;

    public JwtTokenProvider(@Qualifier("defineUserService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String generateToken(String username, String role) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationInSec * 1000);
        // объект claims хранит внутри информацию о токене
        Claims claims = Jwts.claims()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration);
        claims.put("role", role);

        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;
    }

    public String resolveToken(HttpServletRequest request) {
        // токен берем из заголовка Authorization
        String token = request.getHeader("Authorization");
        if (Objects.nonNull(token)) {
            return token.replace("Bearer ", "");
        } else {
            throw new InvalidTokenException("token is null");
        }
    }

    public boolean checkToken(String token) {
        // проверка на время действия токена
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration().after(new Date());
    }

    public Authentication getAuthentication(String token) {
        // создаем объект Authentication из токена
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
