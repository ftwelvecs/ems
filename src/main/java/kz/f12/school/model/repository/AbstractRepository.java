package kz.f12.school.model.repository;

import kz.f12.school.model.dto.AbstractDTO;
import kz.f12.school.utils.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T extends AbstractDTO> {

    private static final String URL = "jdbc:postgresql://localhost:5432/emsdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public T findById(Integer id) {
        Connection connection = getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from main." + getTableName() +" where id = ?");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            return (T) Mapper.map(resultSet, getTableName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();;
        }
        return null;
    }

    public List<T> getAll() {
        Connection connection = getConnection();
        List<T> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from main." + getTableName());
            while (resultSet.next()) {
                resultList.add((T) Mapper.map(resultSet, getTableName()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultList;
    }

    public abstract String getTableName();

}
