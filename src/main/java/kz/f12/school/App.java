package kz.f12.school;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kz.f12.school.model.repository.EmployeeRepository;
import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class App extends Application {

    private EmployeeRepository employeeRepository = EmployeeRepository.getInstance();

    public static void main(String[] args) {
        launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(App.class.getResource("/templates/main.fxml"));
        primaryStage.setTitle("EMS - Employee Management System");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        String path = System.getenv("APPDATA") + "/employee_list.json";
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        JSONArray jsonArray = new JSONArray(employeeRepository.getEmployeeList());
        bufferedWriter.write(jsonArray.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
