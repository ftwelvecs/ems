package kz.f12.school.ems.web;

import kz.f12.school.ems.enums.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @GetMapping
    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }

}
