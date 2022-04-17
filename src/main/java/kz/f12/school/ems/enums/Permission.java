package kz.f12.school.ems.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permission {
    WRITE("write"),
    READ("read");

    private final String permission;
}
