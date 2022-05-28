package kz.f12.school.ems.service;

import kz.f12.school.ems.exception.DeleteUsedRecordException;
import kz.f12.school.ems.model.entity.User;
import kz.f12.school.ems.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void delete(User user) {
        try {
            userRepository.delete(user);
        } catch (DataIntegrityViolationException e) {
            throw new DeleteUsedRecordException();
        }
    }

}
