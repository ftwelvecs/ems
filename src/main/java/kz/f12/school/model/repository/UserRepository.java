package kz.f12.school.model.repository;

import kz.f12.school.model.dto.UserDTO;
import kz.f12.school.utils.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository {

    public List<UserDTO> getAll() {
        Connection connection = getConnection();
        List<UserDTO> userDTOList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from main.users");
            while (resultSet.next()) {
                userDTOList.add(Mapper.toUserDTO(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userDTOList;
    }

}
