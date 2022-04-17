package kz.f12.school.ems.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
    private String role;
}
