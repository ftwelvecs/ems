package kz.f12.school;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppTest {

    private static final String URL = "jdbc:postgresql://localhost:5432/emsdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    @Test
    public void testJdbcConnect() {
        // Driver, DriverManager, Connection, Statement, ResultSet

        // #1 регистрируем driver
        try {
            Class.forName("java.sql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // #2 получаем подключение
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // #3 создаем объект для запросов
            Statement statement = connection.createStatement();

            // #4 вызываем запрос
            statement.execute("insert into main.users(username, password, first_name, email, last_update_date) values('moderator', 'moderator', 'moderator', 'moderator@moderator.com', current_timestamp)");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
