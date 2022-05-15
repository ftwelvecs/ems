package kz.f12.school.ems.web;

import kz.f12.school.ems.model.entity.User;
import kz.f12.school.ems.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

}

