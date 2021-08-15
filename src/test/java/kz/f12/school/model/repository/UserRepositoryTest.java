package kz.f12.school.model.repository;

import kz.f12.school.model.dto.AddressDTO;
import kz.f12.school.model.dto.DepartmentDTO;
import kz.f12.school.model.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserRepositoryTest {

    @Test
    public void testGetAllUsers() {
       DepartmentRepository departmentRepository = new DepartmentRepository();
       List<DepartmentDTO> list = departmentRepository.getAll();
        System.out.println(list);
    }

    @Test
    public void testFindById() {
        UserRepository userRepository = new UserRepository();
        UserDTO userDTO = userRepository.findById(17);
        System.out.println(userDTO);
    }
}
