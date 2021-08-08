package kz.f12.school.model.repository;

import kz.f12.school.model.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserRepositoryTest {

    @Test
    public void testGetAllUsers() {
        UserRepository userRepository = new UserRepository();
        List<UserDTO> userDTOList = userRepository.getAll();
        Assert.assertNotNull(userDTOList);
        Assert.assertTrue(userDTOList.size() > 0);
    }
}
