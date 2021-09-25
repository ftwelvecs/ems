package kz.f12.school.model.repository;

import kz.f12.school.model.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository extends AbstractRepository<UserDTO> {

    public void create(UserDTO userDTO) {
        Connection connection = getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into main.users(username, password, first_name, last_name, patronymic, email) values (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, userDTO.getUsername());
            stmt.setString(2, userDTO.getPassword());
            stmt.setString(3, userDTO.getFirstName());
            stmt.setString(4, userDTO.getLastName());
            stmt.setString(5, userDTO.getPatronymic());
            stmt.setString(6, userDTO.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(UserDTO userDTO) {

    }

    public void delete(UserDTO userDTO) {

    }

    public String getTableName() {
        return "users";
    }

}
