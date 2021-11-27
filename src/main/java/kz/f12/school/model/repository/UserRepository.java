package kz.f12.school.model.repository;

import kz.f12.school.model.dto.UserDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository extends AbstractRepository<UserDTO> {

    public void create(UserDTO userDTO) {
        // переделаем потом
        /*Connection connection = getConnection();
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
        }*/
    }

    public void update(UserDTO userDTO) {
        // переделаем потом
        /*Connection connection = getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("update main.users set first_name = ?, last_name = ?, patronymic = ?, last_update_date = ? where id = ?");
            stmt.setString(1, userDTO.getFirstName());
            stmt.setString(2, userDTO.getLastName());
            long currentTime = new java.util.Date().getTime();
            stmt.setDate(4, new Date(currentTime));
            stmt.setInt(5, userDTO.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void delete(UserDTO userDTO) {
        Connection connection = getConnection();
        try {
            // если нужно физически удалить пользователя, то раскомментировать
            // PreparedStatement stmt = connection.prepareStatement("delete from main.users where id = ?");
            PreparedStatement stmt = connection.prepareStatement("update main.users set is_active = 'N', last_update_date = ? where id = ?");
            long currentTime = new java.util.Date().getTime();
            stmt.setDate(1, new Date(currentTime));
            stmt.setInt(2, userDTO.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getTableName() {
        return "users";
    }

}
