package kz.f12.school.ems;

import kz.f12.school.ems.model.entity.Position;
import kz.f12.school.ems.model.entity.User;
import kz.f12.school.ems.model.repository.PositionRepository;
import kz.f12.school.ems.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmsApplicationTests {

	@Autowired
	private PositionRepository positionRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testPosition() {
		List<Position> positions = positionRepository.findAll();
		System.out.println(positions);
	}

	@Test
	void testUser() {
		List<User> users = userRepository.findAll();

		System.out.println(users);
	}

}
