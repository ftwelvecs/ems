package kz.f12.school.service;

import kz.f12.school.model.dto.UserDTO;

public class UserService {

    public UserDTO findById(int userId) {
        UserDTO user = new UserDTO();
        user.setUsername("admin");
        user.setEmail("admin@gmail.com");
        return user;
    }

}
