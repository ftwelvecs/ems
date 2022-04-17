package kz.f12.school.ems.web;

import kz.f12.school.ems.dto.AuthenticationRequestDto;
import kz.f12.school.ems.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto authentication) {
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok()
                .header("Authorization", token)
                .build();

    }

}
