package kz.f12.school.model.repository;

import kz.f12.school.model.dto.UserDTO;

public class UserRepository extends AbstractRepository<UserDTO> {

    public String getTableName() {
        return "users";
    }

}
