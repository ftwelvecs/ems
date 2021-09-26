package kz.f12.school.service;

import kz.f12.school.model.dto.UserDTO;
import kz.f12.school.model.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private UserRepository repository = new UserRepository();

    public UserDTO findById(int userId) {
        return repository.findById(userId);
    }

    public void create(UserDTO userDTO) {
        userDTO.setPassword(md5(userDTO.getPassword()));
        repository.create(userDTO);
    }

    private String md5(String password) {
        // в будущем напишем логику хэширования
        return password;
    }

    public void update(UserDTO userDTO) {
        repository.update(userDTO);
    }

    public void delete(UserDTO userDTO) {
        repository.delete(userDTO);
    }

    public List<UserDTO> getAll() {
        return repository.getAll().stream().filter(userDTO -> userDTO.getIsActive() == 'Y')
                .collect(Collectors.toList());
    }
}
