package kz.f12.school.service;

import kz.f12.school.model.dto.UserDTO;
import kz.f12.school.model.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository = new UserRepository();

    public UserDTO findById(int userId) {
        return repository.findById(userId);
    }

    public List<UserDTO> getAll() {
        return repository.getAll();
    }
}
