package kz.f12.school.model.dto;

import lombok.Data;

@Data
public class UserDTO extends AbstractDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Character isActive;
    private DepartmentDTO department;
    private PositionDTO position;
}
