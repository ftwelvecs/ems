package kz.f12.school.ems.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kz.f12.school.ems.dto.AuthenticationRequestDto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Setter
public class JwtTokenProvider {

    @Value("${jwt.token.expirationInSec}")
    private long expirationInSec;

    @Value("${jwt.token.secretKey}")
    private String secretKey;

    private final PasswordEncoder passwordEncoder;

    public JwtTokenProvider(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String generateToken(AuthenticationRequestDto request) {
        Date now = new Date();
        Map<String, Object> properties = new HashMap<>();
        properties.put("role", request.getRole());
        properties.put("password", passwordEncoder.encode(request.getPassword()));

        String token = Jwts.builder()
                .setSubject(request.getUsername())
                .setClaims(properties)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationInSec * 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;
    }

   /* public boolean checkToken(String token) {
        getParam(token);
        return true;
    }

    private String getParam(String token) {
        return Jwts.parser().parse(token).toString();
    }
*/
}
