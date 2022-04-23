package kz.f12.school.ems.web;

import kz.f12.school.ems.model.entity.User;
import kz.f12.school.ems.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;

    @PreAuthorize("hasAuthority('write')")
    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

}

