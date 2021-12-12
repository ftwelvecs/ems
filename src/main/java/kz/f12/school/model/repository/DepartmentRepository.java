package kz.f12.school.model.repository;

import kz.f12.school.model.dto.DepartmentDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentRepository extends AbstractRepository<DepartmentDTO> {

    public void create(DepartmentDTO departmentDTO) {
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into main.departments(name, region_id, create_date, last_update_date) values (?,?,?,?)");
            statement.setString(1, departmentDTO.getName());
            statement.setInt(2, departmentDTO.getRegionId());
            statement.setDate(3, new Date(System.currentTimeMillis()));
            statement.setDate(4, new Date(System.currentTimeMillis()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(DepartmentDTO departmentDTO) {
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update main.departments set name = ?, region_id = ?, last_update_date = ? where id = ?");
            statement.setString(1, departmentDTO.getName());
            statement.setInt(2, departmentDTO.getRegionId());
            statement.setDate(3, new Date(System.currentTimeMillis()));
            statement.setInt(4, departmentDTO.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTableName() {
        return "departments";
    }
}
