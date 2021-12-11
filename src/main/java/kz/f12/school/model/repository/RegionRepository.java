package kz.f12.school.model.repository;

import kz.f12.school.model.dto.RegionDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegionRepository extends AbstractRepository<RegionDTO> {

    public void create(RegionDTO regionDTO) {
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into main.regions(name, create_date, last_update_date) values (?,?,?)");
            statement.setString(1, regionDTO.getName());
            statement.setDate(2, new Date(System.currentTimeMillis()));
            statement.setDate(3, new Date(System.currentTimeMillis()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTableName() {
        return "regions";
    }
}
